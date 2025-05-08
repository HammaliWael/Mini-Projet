import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Pretraiteur> pretraiteurs = new ArrayList<>();
        pretraiteurs.add(new UpperCase());
        pretraiteurs.add(new DeleteChiffres());
        pretraiteurs.add(new DeleteCaracteresSpeciaux());
        pretraiteurs.add(new CombinaisonDeSeparation());
        ComparateurDeDeuxNoms comparateur = new JaroWinkler();
        GenerateurDeCondidat generateur = new Generateur1(2);
        Selectionneur selectionneur = new SelectionneurNmeilleur(30);
        MoteurMatching moteur = new MoteurMatching(null, comparateur, pretraiteurs, generateur, selectionneur);
        Nom test = new Nom("dhia", 0);
        List<Nom> base = new ArrayList<>();
        base.add(new Nom("Wael", 1));
        base.add(new Nom("Haythem", 2));
        base.add(new Nom("Dhia eddine Barhoumi", 3));
        base.add(new Nom("Ali", 4));
        base.add(new Nom("dhia", 5));
        base.add(new Nom("dhia eddine Barhoumi", 6));
        base.add(new Nom("DHIAe", 7));
        base.add(new Nom("Adhia", 8));
        base.add(new Nom("DHIA", 9));
        base.add(new Nom("DHiA", 10));
        base.add(new Nom("dHiA", 11));
        base.add(new Nom("DH11Ia2310", 12));
        base.add(new Nom("-+DH11Ia23@!10*", 13));

        System.out.println("\n\n\n=========================== Comparaison =================================\n\n");

        List<MyTuple> resultats = moteur.rechercher(test, base);

        for (MyTuple t : resultats) {
            System.out.printf("Comparaison: %-20s <->       %-20s              | Score: %.2f%n",
                    test.getNom(), t.getItem1(), t.getValue());
        }
        System.out.println("\n");
        System.out.println("Résultats du matching pour: " + test.getNom() + " D'identifiant " + test.getId());
        }
    }

