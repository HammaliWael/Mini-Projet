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
        GenerateurDeCondidats generateur = new FiltreParLongeur(7);
        Selectionneur selectionneur = new SelectionneurNmeilleur(30);
        MoteurMatching moteur = new MoteurMatching(null, comparateur, pretraiteurs, generateur, selectionneur);
        Noms test = new Noms("dhia", 0);
        List<Noms> base = new ArrayList<>();
        base.add(new Noms("Wael", 1));
        base.add(new Noms("Haythem", 2));
        base.add(new Noms("Dhia eddine Barhoumi", 3));
        base.add(new Noms("Ali", 4));
        base.add(new Noms("dhia", 5));
        base.add(new Noms("dhia eddine Barhoumi", 6));
        base.add(new Noms("DHIAe", 7));
        base.add(new Noms("Adhia", 8));
        base.add(new Noms("DHIA", 9));
        base.add(new Noms("DHiA", 10));
        base.add(new Noms("dHiA", 11));
        base.add(new Noms("DH11Ia2310", 12));
        base.add(new Noms("-+DH11Ia23@!10*", 13));

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

