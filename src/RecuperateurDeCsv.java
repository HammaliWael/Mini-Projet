import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RecuperateurDeCsv implements Recuperateur{
    public  List<Nom> recuperer (String cheminFichier ) {
        List<Nom> listeNoms = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(cheminFichier))) {
            String ligne;
            while ((ligne = br.readLine()) != null) {
                String[] parties = ligne.split(",");
                if (parties.length == 2) {
                    String n = parties[0].trim();
                    int id = Integer.parseInt(parties[1].trim());
                    listeNoms.add(new Nom(n, id));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listeNoms;
    }
}