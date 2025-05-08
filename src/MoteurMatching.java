import java.util.ArrayList;
import java.util.List;

public class MoteurMatching {


        private  ComparateurDeDeuxStrings ComparateurString;
        private  ComparateurDeDeuxNoms ComparateurNom;
        private List<Pretraiteur> Preprocesseurs;
        private  GenerateurDeCondidat Generateur;
        private Selectionneur selectionneur;



        public MoteurMatching(ComparateurDeDeuxStrings stringComparateur,ComparateurDeDeuxNoms nameComparateur,List<Pretraiteur> newPreprocesseur, GenerateurDeCondidat candidateGenerateur, Selectionneur selectionneur    ) {


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

        public GenerateurDeCondidat getGenerateur() {
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
    public void setGenerateur(GenerateurDeCondidat generateur) {
            Generateur = generateur;
    }

    public void setSelectionneur(Selectionneur selectionneur) {
        this.selectionneur = selectionneur;
    }

    public List<MyTuple> rechercher(Nom s , List<Nom> L) {

            List<Pretraiteur> pretraiteurs = getPreprocesseurs();
            List<MyTuple> result = new ArrayList<>();
            List<Nom> S = new ArrayList<>();
            S.add(s);
            for (Pretraiteur p :pretraiteurs){
                L=p.pretraiter(L);
                S=p.pretraiter(S);
            }


            ComparateurDeDeuxNoms comparateurNom = getComparateurNom();

            for (int i = 0; i < L.size() ; i++) {
                double comp= comparateurNom.comparer1(S.getFirst(),L.get(i) );
                result.add(new MyTuple(S.getFirst(),L.get(i),comp));
            }
            Selectionneur Selec = getSelectionneur();
            result=Selec.selectionner(result);

            return result ;
        }
        public List<Nom> Dedupliquer (List<Nom> L1, List<Nom> L2) {
            List<Nom> result= new ArrayList<>();
            for( Nom n:L1){
                List <MyTuple>  rech = rechercher(n,L2);
                for (MyTuple t : rech) {
                    if(t.getValue()!=0.0){
                        result.add(t.getItem1());
                        break;
                    }
                }
            }
            return result;
        }

    }
