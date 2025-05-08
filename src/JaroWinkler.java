import org.apache.commons.text.similarity.JaroWinklerDistance;
import java.util.Comparator;

 public class JaroWinkler implements ComparateurDeDeuxNoms {

     @Override
     public double comparer1(Nom nom1, Nom nom2) {
         JaroWinklerDistance jaroWinkler = new JaroWinklerDistance();
         return 1-jaroWinkler.apply(nom1.getNom(), nom2.getNom());
     }
 }


