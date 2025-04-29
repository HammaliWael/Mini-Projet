import java.util.ArrayList;
import java.util.List;

public class Noms {
    private String nom;
    private int id;

    public Noms(String nom,  int id){
        this.nom = nom;
        this.id = id;
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
}

