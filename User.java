import java.util.Base64;

public class User {
    private String username;
    private String hashedPassword;

    public User(String u, String p) {
        this.username = u;
        // Simple encryption/hashing simulation for security
        this.hashedPassword = Base64.getEncoder().encodeToString(p.getBytes());
    }

    @Override
    public String toString() {
        return username + ":" + hashedPassword;
    }
}
