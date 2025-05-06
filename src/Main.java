import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Pretraiteur> pretraiteurs = new ArrayList<>();
        pretraiteurs.add(new UpperCase());
        ComparateurDeDeuxNoms comparateur = new ExactMatch();
        GenerateurDeCondidats generateur = new FiltreParLongeur(1);
        Selectionneur selectionneur = new SelectionneurNmeilleur(7);
        MoteurMatching moteur = new MoteurMatching(null, comparateur, pretraiteurs, generateur, selectionneur);
        Noms cible = new Noms("dhia", 0);

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


        List<MyTuple> resultats = moteur.rechercher(cible, base);
        System.out.println("Résultats du matching pour: " + cible.getNom()+" D'identifiant "+ cible.getId());
        for (MyTuple t : resultats) {
            System.out.println(t);
        }
    }
}
