import org.apache.commons.text.similarity.LevenshteinDistance;

public class Levenshtein implements ComparateurDeDeuxStrings {

    public double comparer2(String s1, String s2) {
        LevenshteinDistance levenshtein = new LevenshteinDistance();
        int distance = levenshtein.apply(s1, s2);
        int max = Math.max(s1.length(), s2.length());
        if (max == 0) return 1.0;
        return 1.0 - ((double) distance / max);

    }


}