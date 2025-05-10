import java.util.ArrayList;
import java.util.List;

public class MoteurMatching {


        private  ComparateurDeDeuxStrings ComparateurString;
        private  ComparateurDeDeuxNoms ComparateurNom;
        private List<Pretraiteur> Preprocesseurs;
        private  GenerateurDeCondidat Generateur;
        private Selectionneur selectionneur;
        private Filtre filtre;



        public MoteurMatching(ComparateurDeDeuxStrings stringComparateur,ComparateurDeDeuxNoms nameComparateur,List<Pretraiteur> newPreprocesseur, GenerateurDeCondidat candidateGenerateur, Selectionneur selectionneur ,Filtre filtre   ) {


            this.ComparateurString = stringComparateur;
            this.ComparateurNom = nameComparateur;
            this.Preprocesseurs = newPreprocesseur;
            this.Generateur = candidateGenerateur;
            this.selectionneur=selectionneur;
            this.filtre=filtre;

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
        public Filtre getFiltre() {
            return filtre;
        }

    public void setFiltre(Filtre filtre) {
        this.filtre = filtre;
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
            Filtre F= getFiltre();
            List<Pretraiteur> pretraiteurs = getPreprocesseurs();
            GenerateurDeCondidat generateur = getGenerateur();
            ComparateurDeDeuxNoms comparateurNom = getComparateurNom();
            List<MyTuple> result = new ArrayList<>();
            List<Nom> S = new ArrayList<>();
            S.add(s);

            for (Pretraiteur p :pretraiteurs){
                L=p.pretraiter(L);
                S=p.pretraiter(S);
            }
            List<Nom> M= F.Filtrer(L,S.getFirst());
            result= generateur.generer(S,M);
            for (int i = 0; i < result.size() ; i++) {
                double comp= comparateurNom.comparer1(result.get(i).getItem1(),result.get(i).getItem2() );
                result.get(i).setValue(comp);
            }

            Selectionneur Selec = getSelectionneur();
            result=Selec.selectionner(result);

            return result ;
        }
        public List<MyTuple> Dedupliquer (List<Nom> L1, List<Nom> L2) {
            List<MyTuple> result= new ArrayList<>();
            for( Nom n:L1){
                if(!L2.contains(n)){
                    List<MyTuple> L3= rechercher(n,L2);
                    result.addAll(L3);
                }
            }
            return result;
        }

        public List<MyTuple> ComparerDeuxListes(List<Nom> L1, List<Nom> L2) {
            ComparateurDeDeuxNoms C= getComparateurNom();
            List<MyTuple> result= new ArrayList<>();
            GenerateurDeCondidat G = getGenerateur();
            List<Pretraiteur> pretraiteurs = getPreprocesseurs();
            for (Pretraiteur p :pretraiteurs){
                L1=p.pretraiter(L1);
                L2=p.pretraiter(L2);
            }
            result=G.generer(L1,L2);
            for(int i=0;i<result.size();i++){
                double comp= C.comparer1(result.get(i).getItem1(),result.get(i).getItem2() );
                result.get(i).setValue(comp);
            }
            return result;
        }

    }
