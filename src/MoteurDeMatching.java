import java.util.*;
import java.util.stream.Collectors;
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
        return false;


    }
    public List<String> dedupliquer (List<String> L1, List<String> L2) {
        return null;
    }

    public double comparerDeuxListes(List<String> L1, List<String> L2) {
        return 0;
    }




}
