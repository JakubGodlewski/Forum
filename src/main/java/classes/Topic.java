package classes;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

/**
 * Created by jakub on 14.06.2017.
 */

@Entity
@Table(name="topic")
public class Topic implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    private String title;
    @Lob()
    private String content;
    private Timestamp date;
    @ManyToOne
    @JoinColumn(name="iduser")
    private User user;
    @OneToMany(mappedBy = "topic", fetch = FetchType.EAGER)
    @OrderBy("date ASC")
    private Set<Inscription> inscriptions;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Inscription> getInscriptions() {
        return inscriptions;
    }

    public void setInscriptions(Set<Inscription> inscriptions) {
        this.inscriptions = inscriptions;
    }

    public Topic(int id, Timestamp date, String title, String content, User user, Set<Inscription> inscriptions) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.content = content;
        this.user = user;
        this.inscriptions = inscriptions;
    }

    public Topic() {
    }

    @Override
    public String toString() {
        return "Topic{" +
                "id=" + id +
                ", date=" + date +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", user=" + user +
                ", inscriptions=" + inscriptions +
                '}';
    }
}
