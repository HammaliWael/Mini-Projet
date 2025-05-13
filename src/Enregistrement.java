import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public record Enregistrement() {

    public void enregistrer(List<MyTuple> donnees, String cheminFichier) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(cheminFichier, true))) {
            for (MyTuple nv : donnees) {
                writer.write(String.format("Résultat: %-20s <-> %-20s | Score: %.2f",
                        nv.getItem1(), nv.getItem2(), nv.getValue()));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}