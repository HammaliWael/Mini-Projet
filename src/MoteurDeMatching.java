import java.util.List;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class MoteurDeMatching {
    private  ComparateurDeDeuxStrings ComparateurString;
    private  ComparateurDeDeuxNoms ComparateurNom;
    private  List<Pretraiteur> Preprocesseurs;
    private  GenerateurDeCondidats Generateur;

    public MoteurDeMatching(ComparateurDeDeuxStrings stringComparator,ComparateurDeDeuxNoms nameComparator,List<Pretraiteur> newPreprocessor, GenerateurDeCondidats candidateGenerateur) {
        this.ComparateurString = stringComparator;
        this.ComparateurNom = nameComparator;
        this.Preprocesseurs = newPreprocessor;
        this.Generateur = candidateGenerateur;
    }

    public ComparateurDeDeuxNoms getComparateurNom() {
        return ComparateurNom;
    }
    public ComparateurDeDeuxStrings getComparateurString() {
        return ComparateurString;
    }

    public GenerateurDeCondidats getGenerateur() {
        return Generateur;
    }

    public List<Pretraiteur> getPreprocesseurs() {
        return Preprocesseurs;
    }

    public void setPreprocesseurs(List<Pretraiteur> preprocesseurs) {
        Preprocesseurs = preprocesseurs;
    }

    public boolean rechercher(String s , List<String> strings) {
        /*for (String test : strings) {
                if (test.equals(s)) {
                    return true;
                }
          }
         return false;*/
        return strings.contains(s);
    }
    public List<String> dedupliquer (List<String> L1, List<String> L2) {
        List<String> L3 = new ArrayList<>(L1);
        L3.addAll(L2);
        LinkedHashSet<String> set = new LinkedHashSet<>(L3);
        L3 = new ArrayList<>(set);
        return L3;
    }

    public List<MyTuple> comparerDeuxListes(List<String> L1, List<String> L2) {
        Scanner scanner = new Scanner(System.in);
        List<MyTuple> result = new ArrayList<>();
        List<String> L3 = dedupliquer(L1, L2);
        List<Pretraiteur> Processing = getPreprocesseurs();
        for (int i = 0; i < L3.size(); i++) {
            String s = L3.get(i);
            for (Pretraiteur p : Processing) {
                s = p.pretraiter(s);
            }
            L3.set(i, s);
        }

        int choice;
        do {
            System.out.println("1. Comparer des Noms");
            System.out.println("2. Comparer des Strings");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    ComparateurDeDeuxNoms comparateurNom = getComparateurNom();
                    for (int i = 0; i < L3.size() - 1; i++) {
                        for (int j = i + 1; j < L3.size(); j++) {
                            double comp = comparateurNom.comparer1(L3.get(i), L3.get(j));
                            result.add(new MyTuple(L3.get(i), L3.get(j), comp));
                        }
                    }
                    scanner.close();
                    return result;

                case 2:
                    ComparateurDeDeuxStrings comparateurString = getComparateurString();
                    for (int i = 0; i < L3.size() - 1; i++) {
                        for (int j = i + 1; j < L3.size(); j++) {
                            double comp = comparateurString.comparer2(L3.get(i), L3.get(j));
                            result.add(new MyTuple(L3.get(i), L3.get(j), comp));
                        }
                    }
                    scanner.close();
                    return result;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (true);
    }
}







