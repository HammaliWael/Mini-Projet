import java.util.List;
import java.util.ArrayList;

public class DeleteChiffres implements Pretraiteur {
    public List<String> pretraiter ( List<String> L){
        for(String s : L){
         s.replaceAll("\\d ", "");
    }
        return L;}
}

