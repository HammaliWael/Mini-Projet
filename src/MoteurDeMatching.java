import java.util.*;
import java.util.stream.Collectors;
import java.util.LinkedHashSet;


public class MoteurDeMatching {
    private  ComparateurDeDeuxStrings ComparateurString;
    private  ComparateurDeDeuxNoms ComparateurNom;
    private  List<Pretraiteur> Preprocesseurs;
    private final GenerateurDeCondidats Generateur;

    public MoteurDeMatching(ComparateurDeDeuxStrings stringComparator,ComparateurDeDeuxNoms nameComparator,List<Pretraiteur> newPreprocessor, GenerateurDeCondidats candidateGenerateur) {
        this.ComparateurString = stringComparator;
        this.ComparateurNom = nameComparator;
        this.Preprocesseurs = newPreprocessor;
        this.Generateur = candidateGenerateur;
    }

    public ComparateurDeDeuxNoms getComparateurNom() {
        return ComparateurNom;
    }

    public GenerateurDeCondidats getGenerateur() {
        return Generateur;
    }

    public List<Pretraiteur> getPreprocesseurs() {
        return Preprocesseurs;
    }

    public void setComparateurNom(ComparateurDeDeuxNoms comparateurNom) {
        ComparateurNom = comparateurNom;
    }

    public void setPreprocesseurs(List<Pretraiteur> preprocesseurs) {
        Preprocesseurs = preprocesseurs;
    }

    public void setComparateurString(ComparateurDeDeuxStrings comparateurString) {
        ComparateurString = comparateurString;
    }

    public boolean rechercher(String s , List<String> strings) {
        /*for (String test : strings) {
                if (test.equals(s)) {
                    return true;
                }
          }
         return false;*/

        return strings.contains(s);
    }
    public List<String> dedupliquer (List<String> L1, List<String> L2) {
        List<String> L3 = new ArrayList<>(L1);
        L3.addAll(L2);
        LinkedHashSet<String> set = new LinkedHashSet<>(L3);
        L3 = new ArrayList<>(set);
        return L3;
    }

    public double comparerDeuxListes(List<String> L1, List<String> L2) {
        ComparateurDeDeuxNoms comparateur = getComparateurNom();
        List<String> L3 = dedupliquer(L1, L2);
        List<Pretraiteur> Processing = getPreprocesseurs();
        int size = L3.size();
        for( String s : L3) {
            for (Pretraiteur p : Processing) {
                String S0 =p.pretraiter(s);
                s=S0;
            }
        }
        for( int i = 0; i < size; i++ ) {
            for(int j = i+1; j < size-1; j++ ) {
                double comp =comparateur.comparer1(L3.get(i),L2.get(j));


            }
        }


    return 0;
    }




}
