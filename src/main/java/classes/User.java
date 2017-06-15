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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (date != null ? !date.equals(user.date) : user.date != null) return false;
        if (topics != null ? !topics.equals(user.topics) : user.topics != null) return false;
        return inscriptions != null ? inscriptions.equals(user.inscriptions) : user.inscriptions == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (topics != null ? topics.hashCode() : 0);
        result = 31 * result + (inscriptions != null ? inscriptions.hashCode() : 0);
        return result;
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
