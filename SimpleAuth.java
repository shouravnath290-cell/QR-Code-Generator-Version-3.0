import java.util.Base64;

public class SimpleAuth implements AuthService {
    private DataManager userDb = new DataManager("users.txt");

    @Override
    public boolean authenticate(String u, String p) {
        // Validation: Basic check
        if(u.isEmpty() || p.isEmpty()) return false;
        
        String hashedInput = Base64.getEncoder().encodeToString(p.getBytes());
        String target = u + ":" + hashedInput;
        return userDb.readData().stream().anyMatch(line -> line.equals(target));
    }

    @Override
    public void register(String u, String p) {
        if(u.length() < 3) return; // Simple Validation
        userDb.writeData(new User(u, p).toString());
    }
}
