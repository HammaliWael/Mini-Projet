import javax.lang.model.element.Name;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class LocalCSVDataImporter implements DataImport {
    private String filePath;


    public LocalCSVDataImporter(String filePath){
        this.filePath = filePath;
    }

    public List<Nom> importData() {
        List<Nom> noms = new ArrayList<>();
        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            lines.skip(1) // Ignorer la ligne d'en-tête
                    .map(this::parseLine)
                    .filter(values -> values.length >= 2)
                    .forEach(values -> {
                        String nom = values[1].trim();
                        String id = values[0].trim();
                        noms.add(new Nom(nom, id));
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return noms;
    }

    private String[] parseLine(String line) {
        return line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
    }
}

