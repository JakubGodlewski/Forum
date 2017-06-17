package classes;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

/**
 * Created by jakub on 14.06.2017.
 */
@Entity
@Table(name = "user")
public class User implements Serializable{
    @Id
    @GeneratedValue
    private int id;
    private String login;
    private String password;
    private Timestamp date;
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Set<Topic> topics;
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Set<Inscription> inscriptions;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Set<Topic> getTopics() {
        return topics;
    }

    public void setTopics(Set<Topic> topics) {
        this.topics = topics;
    }

    public Set<Inscription> getInscriptions() {
        return inscriptions;
    }

    public void setInscriptions(Set<Inscription> inscriptions) {
        this.inscriptions = inscriptions;
    }

    public User(int id, String login, String password, Timestamp date, Set<Topic> topics, Set<Inscription> inscriptions) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.date = date;
        this.topics = topics;
        this.inscriptions = inscriptions;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", date=" + date +
                ", topics=" + topics +
                ", inscriptions=" + inscriptions +
                '}';
    }
}
