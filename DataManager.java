import java.io.*;
import java.util.*;

public class DataManager {
    private final String path;
    public DataManager(String path) { this.path = path; }
    
    public void writeData(String data) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
            bw.write(data); bw.newLine();
        } catch (IOException e) { e.printStackTrace(); }
    }
    
    public List<String> readData() {
        List<String> lines = new ArrayList<>();
        File file = new File(path);
        if (file.exists()) {
            try (Scanner sc = new Scanner(file)) {
                while (sc.hasNextLine()) lines.add(sc.nextLine());
            } catch (Exception e) {}
        }
        return lines;
    }
}