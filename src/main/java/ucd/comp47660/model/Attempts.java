package ucd.comp47660.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Attempts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private int attempts;
    private Date lastModified;

    public Attempts() {}

    public Attempts(String username, Date lastModified) {
        this.username = username;
        this.lastModified = new Date(lastModified.getTime()); // Defensive copy
        this.attempts = 1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public Date getLastModified() {
        // Return a defensive copy to prevent external modification
        return new Date(lastModified.getTime());
    }

    public void setLastModified(Date lastModified) {
        // Update with a defensive copy
        this.lastModified = new Date(lastModified.getTime());
    }
}
