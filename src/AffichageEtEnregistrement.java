import java.util.List;

public class AffichageEtEnregistrement {
    private final Enregistrement enregistrement;

    public AffichageEtEnregistrement() {
        this.enregistrement = new Enregistrement();
    }

    public void afficherEtEnregistrer(List<MyTuple> resultats, String fichier) {
        if (resultats == null || resultats.isEmpty()) {
            System.out.println("Aucun résultat trouvé.");
            return;
        }

        for (MyTuple t : resultats) {
            String ligne = String.format("Résultat: %-20s <-> %-20s | Score: %.2f",
                    t.getItem1(), t.getItem2(), t.getValue());
            System.out.println(ligne);
        }

        enregistrement.enregistrer(resultats, fichier);
    }
}