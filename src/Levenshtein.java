import org.apache.commons.text.similarity.LevenshteinDistance;

public class Levenshtein {
    public double levenshtein(String s1, String s2) {
        LevenshteinDistance levenshtein = new LevenshteinDistance();
        int distance = levenshtein.apply(s1, s2);
        int max = Math.max(s1.length(), s2.length());
        if (max == 0) return 1.0;
        return 1.0 - ((double) distance / max);
    }
}