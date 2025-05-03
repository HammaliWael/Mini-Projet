import java.util.ArrayList;
import java.util.List;

public class MoteurMatching {


        private  ComparateurDeDeuxStrings ComparateurString;
        private  ComparateurDeDeuxNoms ComparateurNom;
        private List<Pretraiteur> Preprocesseurs;
        private  GenerateurDeCondidats Generateur;
        private Selectionneur selectionneur;



        public MoteurMatching(ComparateurDeDeuxStrings stringComparateur,ComparateurDeDeuxNoms nameComparateur,List<Pretraiteur> newPreprocesseur, GenerateurDeCondidats candidateGenerateur, Selectionneur selectionneur    ) {


            this.ComparateurString = stringComparateur;
            this.ComparateurNom = nameComparateur;
            this.Preprocesseurs = newPreprocesseur;
            this.Generateur = candidateGenerateur;
            this.selectionneur=selectionneur;

        }

        public ComparateurDeDeuxNoms getComparateurNom() {
            return ComparateurNom;
        }

        public ComparateurDeDeuxStrings getComparateurString() {
            return ComparateurString;
        }

        public GenerateurDeCondidats getGenerateur() {
            return Generateur;
        }

        public Selectionneur getSelectionneur() {
            return selectionneur;
        }

        public List<Pretraiteur> getPreprocesseurs() {
            return Preprocesseurs;
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
    public void setGenerateur(GenerateurDeCondidats generateur) {
            Generateur = generateur;
    }

    public void setSelectionneur(Selectionneur selectionneur) {
        this.selectionneur = selectionneur;
    }

    public List<MyTuple> rechercher(Noms s , List<Noms> L) {

            List<Pretraiteur> pretraiteurs = getPreprocesseurs();
            List<MyTuple> result = new ArrayList<>();
            List<Noms> S = new ArrayList<>();
            S.add(s);
            for (Pretraiteur p :pretraiteurs){
                L=p.pretraiter(L);
                S=p.pretraiter(S);
            }

            ComparateurDeDeuxNoms comparateurNom = getComparateurNom();

            for (int i = 0; i < L.size() ; i++) {
                double comp= comparateurNom.comparer1(S.getFirst().getNom(),L.get(i).getNom() );
                result.add(new MyTuple(L.get(i),comp));
            }
            Selectionneur Selec = getSelectionneur();
            result=Selec.selectionner(result);

            return result ;
        }
    }
