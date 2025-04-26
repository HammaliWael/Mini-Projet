import org.apache.commons.text.similarity.JaroWinklerDistance;

public class JaroWinkler {
    public static double calculateSimilarity(String s1, String s2) {
        JaroWinklerDistance jaroWinkler = new JaroWinklerDistance();
        return jaroWinkler.apply(s1, s2);
    }

}
