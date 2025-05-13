package Workshop.AccountManager;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

public class Account implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private final UUID id;
    private final String username;
    private final String password;
    private final String fullName;
    private final int age;

    public Account(String username, String password, String fullName, int age) {
        this.id = UUID.randomUUID();
        this.username = username;
//         TODO: Hash Password
//        this.password = ???
        this.fullName = fullName;
        this.age = age;
    }

    public UUID getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }
}

