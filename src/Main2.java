import java.util.ArrayList;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {


        List<MyTuple> result = new ArrayList<>();
        List<Nom> base1 = new ArrayList<>();
        List<Nom> base2 = new ArrayList<>();

        String filePath1 = "C:\\Users\\wael\\Downloads\\peps_names_1k.csv";
        LocalCSVDataImporter Local1 = new LocalCSVDataImporter (filePath1);
        base1 = Local1.importData();

        String filePath2 = "C:\\Users\\wael\\Downloads\\peps_names_128k.csv";
        LocalCSVDataImporter Local2 = new LocalCSVDataImporter (filePath2);
        base2 = Local2.importData();

        GenerateurDeCondidat G = new Generateur1(3);
        result =G.generer(base1, base2 );

        Selectionneur S = new SelectionneurNmeilleur(20);
        result=S.selectionner(result);

        for (MyTuple t : result) {
            System.out.printf("Comparaison: %-20s <->       %-20s              | Score: %.2f%n",
                    t.getItem1(), t.getItem2(), t.getValue());
        }
}
}
