import org.apache.commons.text.similarity.LevenshteinDistance;

public class Levenshtein implements ComparateurDeDeuxNoms{

    public double comparer1(Nom nom1, Nom nom2) {
        LevenshteinDistance levenshtein = new LevenshteinDistance();
        int distance = levenshtein.apply(nom1.getNom(), nom2.getNom());
        int max = Math.max(nom1.getNom().length(), nom2.getNom().length());
        if (max == 0) return 1.0;
        return 1.0 - ((double) distance / max);

    }


}