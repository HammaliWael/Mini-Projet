import java.util.ArrayList;
import java.util.List;

public class UpperCase implements Pretraiteur {
    public List <String> pretraiter(List<String> s){
        List<String> result = new ArrayList<>();
        for(String str : s) {
            str.toUpperCase();
            result.add(str);
        }
        return result;
    }
}
