package ucd.comp47660.model;

import javax.persistence.*;
import java.util.Date;

import static ucd.comp47660.filter.SecurityConstants.EXPIRATION_TIME;

@Entity
public class JwtToken {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "token_id")
    private Long tokenID;

    @Column(name = "token")
    private String jwtToken;

    @Temporal(TemporalType.TIMESTAMP)
    private Date expirationDate;

    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    private User user;

    @Column(name = "has_logout", nullable = false)
    private boolean logout;

    public JwtToken(){}

    public JwtToken(User user, String token){
        this.user = new User(user); // Make a copy of the User object
        this.expirationDate = new Date(new Date().getTime() + EXPIRATION_TIME);
        this.jwtToken = token;
        this.logout = false;
    }

    public String getJwtToken(){
        return jwtToken;
    }

    public void setJwtToken(String jwtToken){
        this.jwtToken = jwtToken;
    }

    public Date getExpirationDate(){
        return new Date(expirationDate.getTime()); // Make a copy of the Date object
    }

    public void setExpirationDate(Date createdDate) {
        this.expirationDate = new Date(createdDate.getTime()); // Make a copy of the Date object
    }

    public User getUser() {
        return new User(this.user); // Make a copy of the User object
    }

    public void setUser(User user) {
        this.user = new User(user); // Make a copy of the User object
    }

    public long getTokenid() {
        return tokenID;
    }

    public void setTokenid(long tokenid) {
        this.tokenID = tokenid;
    }

    public boolean isLogout() {
        return logout;
    }

    public void setLogout(boolean logout) {
        this.logout = logout;
    }
}
