import java.util.ArrayList;
import java.util.List;

public class Nom {
    private String nom;
    private List<Nom> listNomTraitée;
    private final int id;

    public Nom(String nom, int id) {
        this.nom = nom;
        this.id = id;
        this.listNomTraitée = new ArrayList<>();
        this.listNomTraitée.add(this);

    }
    public int getId() {
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

