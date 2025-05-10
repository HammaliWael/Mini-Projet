import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Filtre> filtres = new ArrayList<>();
        List<Pretraiteur> pretraiteurs = new ArrayList<>();
        ComparateurDeDeuxNoms comparateur = null;
        GenerateurDeCondidat generateur = null;
        Selectionneur selectionneur = null;

        String[] fichiers = {
                "C:\\Users\\wael\\Downloads\\peps_names_100.csv",
                "C:\\Users\\wael\\Downloads\\peps_names_200.csv",
                "C:\\Users\\wael\\Downloads\\peps_names_400.csv",
                "C:\\Users\\wael\\Downloads\\peps_names_800.csv",
                "C:\\Users\\wael\\Downloads\\peps_names_1k.csv",
                "C:\\Users\\wael\\Downloads\\peps_names_2k.csv",
                "C:\\Users\\wael\\Downloads\\peps_names_4k.csv",
                "C:\\Users\\wael\\Downloads\\peps_names_8k.csv",
                "C:\\Users\\wael\\Downloads\\peps_names_16k.csv",
                "C:\\Users\\wael\\Downloads\\peps_names_32k.csv",
                "C:\\Users\\wael\\Downloads\\peps_names_64k.csv",
                "C:\\Users\\wael\\Downloads\\peps_names_128k.csv",
                "C:\\Users\\wael\\Downloads\\peps_names_256k.csv",
                "C:\\Users\\wael\\Downloads\\peps_names_512k.csv",
                "C:\\Users\\wael\\Downloads\\peps_names_658k.csv"
        };

        List<List<Nom>> bases = new ArrayList<>();
        for (String fichier : fichiers) {
            bases.add(new LocalCSVDataImporter(fichier).importData());
        }

        boolean continuer = true;
        while (continuer) {
            System.out.println("Choisissez un prétraiteur à ajouter :");
            System.out.println("1. DeleteChiffres\n2. DeleteCaracteresSpeciaux\n3. UpperCase\n4. LowerCase\n5. CombinaisonDeSeparation\n6. Vocalizer");
            int choixPt = scanner.nextInt();
            switch (choixPt) {
                case 1 -> pretraiteurs.add(new DeleteChiffres());
                case 2 -> pretraiteurs.add(new DeleteCaracteresSpeciaux());
                case 3 -> pretraiteurs.add(new UpperCase());
                case 4 -> pretraiteurs.add(new LowerCase());
                case 5 -> pretraiteurs.add(new CombinaisonDeSeparation());
                case 6 -> pretraiteurs.add(new Vocalizer());
                default -> System.out.println("Choix invalide.");
            }
            System.out.print("Voulez-vous ajouter un autre prétraiteur ? (oui/non) : ");
            scanner.nextLine();
            String reponse = scanner.nextLine();
            continuer = reponse.equalsIgnoreCase("oui");
        }

        continuer = true;
        while (continuer) {
            System.out.println("Choisissez un filtre à ajouter :");
            System.out.println("1. FiltreParLongeur\n2. FiltreParPartage");
            int ft = scanner.nextInt();
            switch (ft) {
                case 1 -> {
                    System.out.print("Longueur minimale : ");
                    int l = scanner.nextInt();
                    filtres.add(new FiltreParLongeur(l));
                }
                case 2 -> {
                    System.out.print("Nombre de mots partagés minimum : ");
                    int p = scanner.nextInt();
                    filtres.add(new FiltreParPartage(p));
                }
                default -> System.out.println("Choix invalide.");
            }
            System.out.print("Voulez-vous ajouter un autre filtre ? (oui/non) : ");
            scanner.nextLine();
            String reponse = scanner.nextLine();
            continuer = reponse.equalsIgnoreCase("oui");
        }

        System.out.println("Choisissez un comparateur :\n1. ExactMatch\n2. Levenshtein\n3. JaroWinkler");
        int cmp = scanner.nextInt();
        switch (cmp) {
            case 1 -> comparateur = new ExactMatch();
            case 2 -> comparateur = new Levenshtein();
            case 3 -> comparateur = new JaroWinkler();
            default -> System.out.println("Choix invalide.");
        }

        System.out.print("Entrez la valeur de mode pour Generateur1 : ");
        int mode = scanner.nextInt();
        generateur = new Generateur1(mode);

        System.out.println("Choisissez un sélectionneur :\n1. SelectionneurNmeilleur\n2. SelectionneurParSeuil");
        int sel = scanner.nextInt();
        if (sel == 1) {
            System.out.print("Entrez le nombre de meilleurs candidats : ");
            int n = scanner.nextInt();
            selectionneur = new SelectionneurNmeilleur(n);
        } else if (sel == 2) {
            System.out.print("Entrez le seuil minimal (ex : 0.8) : ");
            double seuil = scanner.nextDouble();
            selectionneur = new SelectionneurParSeuille(seuil);
        }

        MoteurMatching moteur = new MoteurMatching(null, comparateur, pretraiteurs, generateur, selectionneur, filtres);

        // Affichage de TOUS les fichiers disponibles
        System.out.println("\n===== Liste des fichiers disponibles =====");
        for (int i = 0; i < fichiers.length; i++) {
            System.out.println((i + 1) + ". " + fichiers[i]);
        }

        System.out.println("\n===== Que voulez-vous faire maintenant ? =====");
        System.out.println("1. Dédoublonner une liste\n2. Rechercher un nom\n3. Comparer deux listes");
        System.out.print("Choix : ");
        int action = scanner.nextInt();
        scanner.nextLine();

        switch (action) {
            case 1 -> {
                System.out.print("Choisissez un fichier pour dédoublonner (1 à " + fichiers.length + ") : ");
                int listChoice = scanner.nextInt();
                List<Nom> selectedBase = bases.get(listChoice - 1);
                int tailleAvant = selectedBase.size();
                selectedBase = new ArrayList<>(new HashSet<>(selectedBase));
                int tailleApres = selectedBase.size();
                System.out.println("Fichier " + listChoice + " : " + tailleAvant + " -> " + tailleApres);
            }

            case 2 -> {
                System.out.print("Choisissez un fichier pour rechercher (1 à " + fichiers.length + ") : ");
                int baseIndex = scanner.nextInt();
                scanner.nextLine();

                List<Nom> base = bases.get(baseIndex - 1);
                System.out.println("Base sélectionnée contient " + base.size() + " noms.");

                System.out.print("Entrez le nom à rechercher : ");
                String nomRech = scanner.nextLine();
                Nom nomTest = new Nom(nomRech, "test");

                System.out.println("Nom recherché : " + nomTest.getNom());

                List<MyTuple> res = moteur.rechercher(nomTest, base);

                if (res.isEmpty()) {
                    System.out.println("Aucun résultat trouvé.");
                } else {
                    for (MyTuple t : res) {
                        System.out.printf("Résultat: %-20s <-> %-20s | Score: %.2f%n",
                                t.getItem1(), t.getItem2(), t.getValue());
                    }
                }
            }

            case 3 -> {
                System.out.print("Choisissez le premier fichier à comparer (1 à " + fichiers.length + ") : ");
                int base1Index = scanner.nextInt();
                System.out.print("Choisissez le deuxième fichier à comparer (1 à " + fichiers.length + ") : ");
                int base2Index = scanner.nextInt();

                List<MyTuple> res = moteur.ComparerDeuxListes(bases.get(base1Index - 1), bases.get(base2Index - 1));

                if (res.isEmpty()) {
                    System.out.println("Aucun couplage trouvé.");
                } else {
                    for (MyTuple t : res) {
                        System.out.printf("Comparaison: %-20s <-> %-20s | Score: %.2f%n",
                                t.getItem1(), t.getItem2(), t.getValue());
                    }
                }
            }

            default -> System.out.println("Choix invalide.");
        }

        System.out.println("Fin du programme.");
        scanner.close();
    }
}

