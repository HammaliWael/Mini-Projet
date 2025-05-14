import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class AffichageEtEnregistrement {
    private PrintWriter writer;

    public AffichageEtEnregistrement(String filename) {
        try {
            writer = new PrintWriter(new FileWriter(filename, true)); // append mode
        } catch (IOException e) {
            System.err.println("Erreur lors de l'ouverture du fichier : " + e.getMessage());
        }
    }

    public void afficherEtEnregistrer(String message) {
        System.out.println(message);
        if (writer != null) {
            writer.println(message);
        }
    }

    public void close() {
        if (writer != null) {
            writer.close();
        }
    }
}
