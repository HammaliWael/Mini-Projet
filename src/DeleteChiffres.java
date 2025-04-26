public class DeleteChiffres implements Pretraiteur {
    public String pretraiter (String s){
        return s.replaceAll("\\d ", "");
    }
}

