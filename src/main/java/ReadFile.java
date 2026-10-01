import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFile {
    private ArrayList<String> lines;
    private String[] paragraphs;

    public ArrayList<String> getLines() { return lines; }

    public String[] getParagraphs() { return paragraphs; }

    public Boolean doReadFile(String fname) {
        lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fname))) {
            StringBuilder builder = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                lines.add(line);
                builder.append(line).append("\n");
            }

            this.paragraphs = builder.toString().split("\\n\\s*\\n");
            return true;
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return false;
    }
    private ReadFile() {}
    public ReadFile(String fname) throws FileNotFoundException {
        if (!doReadFile(fname)) {
            throw new FileNotFoundException("Error reading file: " + fname);
        }
    }
}
