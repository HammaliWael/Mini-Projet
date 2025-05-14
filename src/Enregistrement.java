import java.io.*;

public class Enregistrement {

    private PrintStream printStream;


    public Enregistrement(String fileName) {
        try {

            this.printStream = new PrintStream(new File(fileName));
        } catch (FileNotFoundException e) {
            System.out.println("Erreur : Impossible d'écrire dans le fichier.");
            e.printStackTrace();
        }
    }


    public void enregistrer(String output) {
        printStream.println(output);
    }


    public void close() {
        if (printStream != null) {
            printStream.close();
        }
    }
}
