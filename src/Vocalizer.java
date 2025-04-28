import java.util.List;
import java.util.ArrayList;

public class Vocalizer implements Pretraiteur {
    public List <String> pretraiter(List <String>L){
        for(String s : L) {
            if (s.contains("oui")) {
                s = s.replace("oui", "wi");
            }
            if (s.contains("ss")) {
                s = s.replace("ss", "z");
            }
            if (s.contains("ph")) {
                s = s.replace("ph", "f");
            }
            if (s.contains("ck")) {
                s = s.replace("ck", "k");
            }
            if (s.contains("gh")) {
                s = s.replace("gh", "g");
            }
            if (s.contains("ks")) {
                s = s.replace("ks", "x");
            }
        }
        return L;

    }

}
