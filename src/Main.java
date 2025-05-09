import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Pretraiteur> pretraiteurs = new ArrayList<>();

        pretraiteurs.add(new CombinaisonDeSeparation());
        pretraiteurs.add(new DeleteChiffres());
        pretraiteurs.add(new UpperCase());

        ComparateurDeDeuxNoms comparateur = new ExactMatch();
        GenerateurDeCondidat generateur = new Generateur1(2);
        Selectionneur selectionneur = new SelectionneurNmeilleur(100);
        Filtre F =new FiltreParLongeur(5);

        MoteurMatching moteur = new MoteurMatching(null, comparateur, pretraiteurs, generateur, selectionneur,F);
        Nom test = new Nom("EDINALVA POSSIDONIO DE SOUSA", "3");
        List<Nom> base = new ArrayList<>();
        String filePath = "C:\\Users\\wael\\Downloads\\peps_names_658k.csv";

        LocalCSVDataImporter Local = new LocalCSVDataImporter (filePath);
        base = Local.importData();

        System.out.println("\n\n\n=========================== Comparaison =================================\n\n");

        List<MyTuple> resultats = moteur.rechercher(test, base);

        for (MyTuple t : resultats) {
            System.out.printf("Comparaison: %-20s <->       %-20s              | Score: %.2f%n",
                    t.getItem1(), t.getItem2(), t.getValue());
        }
        System.out.println("\n");
        System.out.println("Résultats du matching pour: " + test.getNom() + " D'identifiant " + test.getId());
        }
    }

