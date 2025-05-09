import java.util.ArrayList;
import java.util.List;

public class Nom {
    private String nom;
    private List<Nom> listNomTraitée;
    private final String id;

    public Nom(String nom, String id) {
        this.nom = nom;
        this.id = id;
        this.listNomTraitée = new ArrayList<>();
        this.listNomTraitée.add(this);

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

    public List<Nom> getListNomTraitée() {
        return listNomTraitée;
    }

    public void setListNomTraitée(List<Nom> listNomTraitée) {
        this.listNomTraitée = listNomTraitée;
    }

    public String toString() {
        return nom + " (ID: " + id + ")";
    }
}

