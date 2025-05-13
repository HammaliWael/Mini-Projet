import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FiltreParLongeur f = new FiltreParLongeur(3);
        List<Filtre> filtres = new ArrayList<>();
        filtres.add(f);
        List<Pretraiteur> pretraiteurs = new ArrayList<>();
        pretraiteurs.add(new DeleteChiffres());

        ComparateurDeDeuxNoms comparateur = new ExactMatch();
        GenerateurDeCondidat generateur = new Generateur1(0);
        Selectionneur selectionneur = new SelectionneurNmeilleur(50);
        AffichageEtEnregistrement afficheur = new AffichageEtEnregistrement();

        boolean running = true;
        while (running) {
            System.out.println("\n===== MENU PRINCIPAL =====");
            System.out.println("1. Effectuer une recherche");
            System.out.println("2. Comparer deux listes");
            System.out.println("3. Dédupliquer une liste");
            System.out.println("4. Configurer les paramètres");
            System.out.println("5. Quitter");
            System.out.print("Votre choix : ");
            int choix = scanner.nextInt();
            scanner.nextLine();

            MoteurMatching moteur = new MoteurMatching(null, comparateur, pretraiteurs, generateur, selectionneur, filtres);

            switch (choix) {
                case 1 -> {
                    System.out.print("Entrez le chemin du fichier : ");
                    String path = scanner.nextLine().replace("\"", "").trim();
                    List<Nom> base = new RecuperateurCSV(path).importData();
                    System.out.print("Entrez le nom à rechercher : ");
                    String nomRecherche = scanner.nextLine();
                    Nom nomTest = new Nom(nomRecherche, "test");
                    List<MyTuple> res = moteur.rechercher(nomTest, base);
                    afficheur.afficherEtEnregistrer(res, "fichier.txt");
                }

                case 2 -> {
                    System.out.print("Entrez le chemin du premier fichier : ");
                    String path1 = scanner.nextLine().replace("\"", "").trim();
                    System.out.print("Entrez le chemin du second fichier : ");
                    String path2 = scanner.nextLine().replace("\"", "").trim();
                    List<Nom> base1 = new RecuperateurCSV(path1).importData();
                    List<Nom> base2 = new RecuperateurCSV(path2).importData();
                    List<MyTuple> res = moteur.ComparerDeuxListes(base1, base2);
                    afficheur.afficherEtEnregistrer(res, "fichier.txt");
                }

                case 3 -> {
                    System.out.print("Entrez le chemin du fichier à dédupliquer : ");
                    String path = scanner.nextLine().replace("\"", "").trim();
                    List<Nom> liste = new RecuperateurCSV(path).importData();
                    List<MyTuple> res = moteur.dedupliquer(liste);
                    afficheur.afficherEtEnregistrer(res, "fichier.txt");
                }

                case 4 -> {
                    boolean configurer = true;
                    while (configurer) {
                        System.out.println("\n--- CONFIGURATION ---");
                        System.out.println("1. Choisir les prétraitements");
                        System.out.println("2. Choisir une structure d'index (mode générateur)");
                        System.out.println("3. Choisir une mesure de comparaison");
                        System.out.println("4. Définir le seuil ou nombre de résultats");
                        System.out.println("5. Choisir un filtre");
                        System.out.println("6. Retour");
                        System.out.print("Choix : ");
                        int config = scanner.nextInt();
                        scanner.nextLine();

                        switch (config) {
                            case 1 -> {
                                pretraiteurs.clear();
                                boolean ajout = true;
                                while (ajout) {
                                    System.out.println("Ajouter un prétraitement :");
                                    System.out.println("1. DeleteChiffres\n2. DeleteCaracteresSpeciaux\n3. UpperCase\n4. LowerCase\n5. CombinaisonDeSeparation1\n6. CombinaisonDeSeparation2\n7. Vocalizer");
                                    int choixPt = scanner.nextInt();
                                    scanner.nextLine();
                                    switch (choixPt) {
                                        case 1 -> pretraiteurs.add(new DeleteChiffres());
                                        case 2 -> pretraiteurs.add(new DeleteCaracteresSpeciaux());
                                        case 3 -> pretraiteurs.add(new UpperCase());
                                        case 4 -> pretraiteurs.add(new LowerCase());
                                        case 5 -> pretraiteurs.add(new CombinaisonDeSeparation1());
                                        case 6 -> pretraiteurs.add(new CombinaisonDeSeparation2());
                                        case 7 -> pretraiteurs.add(new Vocalizer());
                                        default -> System.out.println("Choix invalide.");
                                    }
                                    System.out.print("Ajouter un autre ? (oui/non) : ");
                                    ajout = scanner.nextLine().equalsIgnoreCase("oui");
                                }
                            }

                            case 2 -> {
                                System.out.println("Choisissez un générateur :\n1. Generateur1\n2. Generateur2");
                                int choixGen = scanner.nextInt();
                                if (choixGen == 1) {
                                    System.out.print("Entrez le mode pour Generateur1 : ");
                                    int mode = scanner.nextInt();
                                    generateur = new Generateur1(mode);
                                } else if (choixGen == 2) {
                                    System.out.print("Entrez le mode pour Generateur2 : ");
                                    int mode = scanner.nextInt();
                                    generateur = new Generateur2(mode);
                                } else {
                                    System.out.println("Choix invalide.");
                                }
                            }

                            case 3 -> {
                                System.out.println("Choisissez un comparateur :\n1. ExactMatch\n2. Levenshtein\n3. JaroWinkler");
                                int cmp = scanner.nextInt();
                                comparateur = switch (cmp) {
                                    case 1 -> new ExactMatch();
                                    case 2 -> new Levenshtein();
                                    case 3 -> new JaroWinkler();
                                    default -> comparateur;
                                };
                            }

                            case 4 -> {
                                System.out.println("1. Nombre de meilleurs résultats\n2. Seuil minimal");
                                int type = scanner.nextInt();
                                if (type == 1) {
                                    System.out.print("Entrez N : ");
                                    int n = scanner.nextInt();
                                    selectionneur = new SelectionneurNmeilleur(n);
                                } else if (type == 2) {
                                    System.out.print("Entrez le seuil (ex: 0.8) : ");
                                    double s = scanner.nextDouble();
                                    selectionneur = new SelectionneurParSeuille(s);
                                }
                            }

                            case 5 -> {
                                filtres.clear();
                                System.out.println("1. Filtre par longeur\n2. Filtre par partage");
                                int type = scanner.nextInt();
                                if (type == 1) {
                                    System.out.print("Entrez la longueur minimale : ");
                                    int n = scanner.nextInt();
                                    filtres.add(new FiltreParLongeur(n));
                                } else if (type == 2) {
                                    System.out.print("Entrez le minimum de partage : ");
                                    int s = scanner.nextInt();
                                    filtres.add(new FiltreParPartage(s));
                                } else {
                                    System.out.println("Choix invalide.");
                                }
                            }

                            case 6 -> configurer = false;

                            default -> System.out.println("Choix invalide.");
                        }
                    }
                }

                case 5 -> {
                    running = false;
                    System.out.println("Fin du programme.");
                }

                default -> System.out.println("Choix invalide.");
            }
        }

        scanner.close();
    }
}
