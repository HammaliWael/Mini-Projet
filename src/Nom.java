import java.util.ArrayList;
import java.util.List;

public class Nom {
    private String nom;
    private List<Nom> ListNomTraitees;
    private final String id;

    public Nom(String nom, String id) {
        this.nom = nom;
        this.id = id;
        this.ListNomTraitees = new ArrayList<>();
        this.ListNomTraitees.add(this);

    }
    public String getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Nom> getListNomTraitees() {
        return ListNomTraitees;
    }

    public void setListNomTraitees(List<Nom> listNomTraitees) {
        this.ListNomTraitees = listNomTraitees;
    }

    public String toString() {
        return nom + " (ID: " + id + ")";
    }
}