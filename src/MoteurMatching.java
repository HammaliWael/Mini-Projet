import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MoteurMatching {


        private  ComparateurDeDeuxStrings ComparateurString;
        private  ComparateurDeDeuxNoms ComparateurNom;
        private List<Pretraiteur> Preprocesseurs;
        private  GenerateurDeCondidat Generateur;
        private Selectionneur selectionneur;
        private List <Filtre>  filtres;



        public MoteurMatching(ComparateurDeDeuxStrings stringComparateur,ComparateurDeDeuxNoms nameComparateur,List<Pretraiteur> newPreprocesseur, GenerateurDeCondidat candidateGenerateur, Selectionneur selectionneur ,List <Filtre> filtres   ) {


            this.ComparateurString = stringComparateur;
            this.ComparateurNom = nameComparateur;
            this.Preprocesseurs = newPreprocesseur;
            this.Generateur = candidateGenerateur;
            this.selectionneur=selectionneur;
            this.filtres=filtres;

        }

        public ComparateurDeDeuxNoms getComparateurNom() {
            return ComparateurNom;
        }

        public ComparateurDeDeuxStrings getComparateurString() {
            return ComparateurString;
        }

        public GenerateurDeCondidat getGenerateur() {
            return Generateur;
        }

        public Selectionneur getSelectionneur() {
            return selectionneur;
        }

        public List<Pretraiteur> getPreprocesseurs() {
            return Preprocesseurs;
        }
        public List <Filtre> getFiltre() {
            return filtres;
        }




    public void setFiltre(List<Filtre> filtres) {
        this.filtres = filtres;
    }

    public void setPreprocesseurs(List<Pretraiteur> preprocesseurs) {
            Preprocesseurs = preprocesseurs;
        }

    public void setComparateurNom(ComparateurDeDeuxNoms comparateurNom) {
        ComparateurNom = comparateurNom;
    }

    public void setComparateurString(ComparateurDeDeuxStrings comparateurString) {
        ComparateurString = comparateurString;
    }
    public void setGenerateur(GenerateurDeCondidat generateur) {
            Generateur = generateur;
    }

    public void setSelectionneur(Selectionneur selectionneur) {
        this.selectionneur = selectionneur;
    }

    public List<MyTuple> rechercher(Nom s , List<Nom> L) {
            Selectionneur Selec = getSelectionneur();
            List <Filtre> F = getFiltre();
            List<Pretraiteur> pretraiteurs = getPreprocesseurs();
            GenerateurDeCondidat generateur = getGenerateur();
            ComparateurDeDeuxNoms comparateurNom = getComparateurNom();
            List<MyTuple> result = new ArrayList<>();
            List<Nom> S = new ArrayList<>();
            S.add(s);

            for (Filtre f : F) {
                L= f.Filtrer(L,S.getFirst());
            }

            for (Pretraiteur p :pretraiteurs){
                L=p.pretraiter(L);
                S=p.pretraiter(S);
            }


            result= generateur.generer(S,L);

            for (int i = 0; i < result.size() ; i++) {
                double comp= comparateurNom.comparer1(result.get(i).getItem1(),result.get(i).getItem2() );
                result.get(i).setValue(comp);
            }
            result=Selec.selectionner(result);
            return result ;
        }


    public List<MyTuple> dedupliquer(List<Nom> noms) {
            Set<MyTuple> resultSet = new HashSet<>();
            int n = noms.size();
            Selectionneur Selec = getSelectionneur();

            for (int i = 0; i < n; i++) {
                Nom nom1 = noms.get(i);
                List<Nom> rest = new ArrayList<>();
                for (int j = i + 1; j < n; j++) {
                    Nom nom2 = noms.get(j);
                    if (!nom1.getId().equals(nom2.getId()) || !nom1.getNom().equals(nom2.getNom())) {
                        rest.add(nom2);
                    }
                }

                if (!rest.isEmpty()) {
                    resultSet.addAll(rechercher(nom1, rest));
                }
            }

            List<MyTuple> deduped = new ArrayList<>(resultSet);
            return Selec.selectionner(deduped);
        }
            /*List<MyTuple> result = new ArrayList<>();
        for (int i = 0; i < noms.size(); i++) {
            Nom nom1 = noms.get(i);
            for (int j = i + 1; j < noms.size(); j++) {
                Nom nom2 = noms.get(j);
                if (!nom1.getId().equals(nom2.getId())&& !nom1.getNom().equals(nom2.getNom())) {
                    List<Nom> L = noms.subList(j,noms.size());
                    result.addAll(rechercher(nom1,L));
                }
            }
        }
        return result;
    }*/

        public List<MyTuple> ComparerDeuxListes(List<Nom> L1, List<Nom> L2) {
            ComparateurDeDeuxNoms C= getComparateurNom();
            List<MyTuple> result= new ArrayList<>();
            GenerateurDeCondidat G = getGenerateur();
            List<Pretraiteur> pretraiteurs = getPreprocesseurs();
            List<Filtre> filtres = getFiltre();

            for( Nom n:L1){
                for (Pretraiteur p :pretraiteurs){
                    L1=p.pretraiter(L1);
                    L2=p.pretraiter(L2);
                }
            }
            result= G.generer(L1,L2);
            for(int i=0;i<result.size();i++){
                double comp= C.comparer1(result.get(i).getItem1(),result.get(i).getItem2() );
                result.get(i).setValue(comp);
            }
            Selectionneur Selec = getSelectionneur();
            result=Selec.selectionner(result);
            return result;
        }

    }
