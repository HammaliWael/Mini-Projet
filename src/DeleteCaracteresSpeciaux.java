public class DeleteCaracteresSpeciaux implements Pretraiteur {
    public String  pretraiter (String s) {
        return s.replaceAll("[^a-zA-Z0-9\\s]", "");
    }
}
