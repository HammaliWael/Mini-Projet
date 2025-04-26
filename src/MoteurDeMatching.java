public class MoteurDeMatching {
    private  ComparateurDeDeuxStrings ComparateurString;
    private  ComparateurDeDeuxNoms ComparateurNom;
    private Pretraiteur Preprocesseur;
    private final GenerateurDeCondidats Generateur;

    public MoteurDeMatching(ComparateurDeDeuxStrings stringComparator,ComparateurDeDeuxNoms nameComparator,Pretraiteur textPreprocessor, GenerateurDeCondidats candidateGenerator) {
        this.ComparateurString = stringComparator;
        this.ComparateurNom = nameComparator;
        this.Preprocesseur = textPreprocessor;
        this.Generateur = candidateGenerator;
    }

}
