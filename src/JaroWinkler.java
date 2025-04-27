import org.apache.commons.text.similarity.JaroWinklerDistance;

public class JaroWinkler implements ComparateurDeDeuxNoms {
    public  double comparer1(String s1, String s2) {
        JaroWinklerDistance jaroWinkler = new JaroWinklerDistance();
        return jaroWinkler.apply(s1, s2);
    }

}
