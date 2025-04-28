import java.util.List;
import java.util.ArrayList;
public class DeleteCaracteresSpeciaux implements Pretraiteur {
    public List <String>  pretraiter (List<String> L){
        for(String s : L){
         s.replaceAll("[^a-zA-Z0-9\\s]", "");
    }
    return L;
    }
}
