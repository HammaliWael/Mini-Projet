import org.apache.commons.text.similarity.JaroWinklerDistance;
import java.util.Comparator;

 public class JaroWinkler implements ComparateurDeDeuxNoms {

     @Override
     public double comparer1(String s1, String s2) {
         JaroWinklerDistance jaroWinkler = new JaroWinklerDistance();
         return 1-jaroWinkler.apply(s1, s2);
     }
 }


