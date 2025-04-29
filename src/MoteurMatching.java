import java.util.ArrayList;
import java.util.List;

public class MoteurMatching {
        private  ComparateurDeDeuxStrings ComparateurString;
        private  ComparateurDeDeuxNoms ComparateurNom;
        private List<Pretraiteur> Preprocesseurs;
        private  GenerateurDeCondidats Generateur;
        private Selectionneur selectionneur;


        public MoteurMatching(ComparateurDeDeuxStrings stringComparator,ComparateurDeDeuxNoms nameComparator,List<Pretraiteur> newPreprocessor, GenerateurDeCondidats candidateGenerateur, Selectionneur selectionneur    ) {


            this.ComparateurString = stringComparator;
            this.ComparateurNom = nameComparator;
            this.Preprocesseurs = newPreprocessor;
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

        public List<MyTuple> rechercher(Noms s , List<Noms> L) {

            List<Pretraiteur> Processing = getPreprocesseurs();
            List<MyTuple> result = new ArrayList<>();
            List<Noms> S = new ArrayList<>();
            S.add(s);
            for (Pretraiteur p : Processing){
                L=p.pretraiter(L);
                S=p.pretraiter(S);
            }

            ComparateurDeDeuxNoms comparateurNom = getComparateurNom();
            for (int i = 0; i < L.size() ; i++) {
                double comp= comparateurNom.comparer1(s.getNom(),L.get(i).getNom() );
                result.add(new MyTuple(L.get(i),comp));
            }
            Selectionneur Selec = getSelectionneur();
            result=Selec.selectionner(result);


            return result ;













            /*List<MyTuple> result = new ArrayList<>();

            S.add(s);


                L = p.pretraiter(L);
                S = p.pretraiter(S);
            }
            ComparateurDeDeuxNoms comparateurNom = getComparateurNom();

            for (int i = 0; i < L.size() ; i++) {
                double comp = comparateurNom.comparer1(L.get(i),S.get(0));
                result.add(new MyTuple(L.get(i),comp));
            }
            Selectionneur Selec=getSelectionneur();
            result=Selec.selectionner(result);
            return result;*/
        }
    }
