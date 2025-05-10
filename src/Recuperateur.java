import java.util.List;

public interface Recuperateur {
    List<Nom> importData();
}







































/*public class Main {
    public static void main(String[] args) {

        /// ////////////////////////////////////////////////////////////////////////

        List <Filtre> F = new ArrayList<>();
        F.add(new FiltreParLongeur(2));
        F.add(new FiltreParPartage(2));

        /// ////////////////////////////////////////////////////////////////////
        ComparateurDeDeuxNoms comparateur = new ExactMatch();
        GenerateurDeCondidat generateur = new Generateur1(0);
        Selectionneur selectionneur = new SelectionneurNmeilleur(100);
        List<Pretraiteur> pretraiteurs = new ArrayList<>();
        pretraiteurs.add(new DeleteChiffres());
        //pretraiteurs.add(new CombinaisonDeSeparation());
        //pretraiteurs.add(new DeleteCaracteresSpeciaux());
        //pretraiteurs.add(new UpperCase());
        MoteurMatching moteur = new MoteurMatching(null, comparateur, pretraiteurs, generateur, selectionneur,F);

        Nom test = new Nom("Uth2man Hus1000000000000sain Faid al-MUJA@@@@@@LI", "3");

        ////////////////////////////////////////////////////////////////////////////////////////////////////
        List<Nom> base1 = new ArrayList<>();
        List<Nom> base2 = new ArrayList<>();
        String filePath1 = "C:\\Users\\wael\\Downloads\\peps_names_1k.csv";
        LocalCSVDataImporter Local1 = new LocalCSVDataImporter (filePath1);
        base1 = Local1.importData();
        String filePath2 = "C:\\Users\\wael\\Downloads\\peps_names_128k.csv";
        LocalCSVDataImporter Local2 = new LocalCSVDataImporter (filePath2);
        base2 = Local2.importData();
        /////////////////////////////////////////////////////////////////////////////////////////////////


        System.out.println("\n\n\n=========================== Comparaison =================================\n\n");

        List<MyTuple> resultats = moteur.ComparerDeuxListes( base1 , base2);
        //List<MyTuple> resultats = moteur.rechercher(test, base);
        Set<MyTuple> S = new HashSet<>(resultats);


        /// //////////////////////////////////////////////////////////////////////////////////
        resultats = new ArrayList<>(S);
        for (MyTuple t : resultats) {
            System.out.printf("Comparaison: %-20s <->       %-20s              | Score: %.2f%n",
                    t.getItem1(), t.getItem2(), t.getValue());
        }
        System.out.println("\n");
        System.out.println("Résultats du matching pour: " + test.getNom() + " D'identifiant " + test.getId());
        }

    }*/