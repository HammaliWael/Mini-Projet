import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Enregistrement E = new Enregistrement();
        List<Pretraiteur> pretraiteurs = new ArrayList<>();


        pretraiteurs.add(new DeleteChiffres());

        //pretraiteurs.add(new CombinaisonDeSeparation());
        //pretraiteurs.add(new DeleteCaracteresSpeciaux());
        //pretraiteurs.add(new UpperCase());

        ComparateurDeDeuxNoms comparateur = new ExactMatch();
        GenerateurDeCondidat generateur = new Generateur1(0);
        Selectionneur selectionneur = new SelectionneurNmeilleur(10);

        List <Filtre> F = new ArrayList<>();

        F.add(new FiltreParLongeur(0));
        F.add(new FiltreParPartage(0));

        MoteurMatching moteur = new MoteurMatching(null, comparateur, pretraiteurs, generateur, selectionneur,F);
        Nom test = new Nom("Uth2man Hus1000000000000sain Faid al-MUJA@@@@@@LI", "3");
        List<Nom> base = new ArrayList<>();
        String filePath = "C:\\Users\\wael\\Downloads\\peps_names_1k.csv";

        LocalCSVDataImporter Local = new LocalCSVDataImporter (filePath);
        base = Local.importData();

        System.out.println("\n\n\n=========================== Comparaison =================================\n\n");

        //List<MyTuple> resultats = moteur.rechercher(test, base);
        List<MyTuple> resultats = moteur.ComparerDeuxListes( base , base);
        for (MyTuple t : resultats) {
            System.out.printf("Comparaison: %-20s <->       %-20s              | Score: %.2f%n",
                    t.getItem1(), t.getItem2(), t.getValue());
        }
        String shemin = "C:\\Users\\wael\\Desktop" ;

        //E.enregistrer(resultats,shemin);

        System.out.println("\n");
        System.out.println("Résultats du matching pour: " + test.getNom() + " D'identifiant " + test.getId());
        }
    }

