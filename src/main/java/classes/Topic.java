package classes;

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
    private Timestamp dateTopic;
    @ManyToOne
    @JoinColumn(name="iduser")
    private User user;
    @OneToMany(mappedBy = "topic", fetch = FetchType.EAGER)
    @OrderBy("dateInscription ASC")
    private Set<Inscription> inscriptions;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getDateTopic() {
        return dateTopic;
    }

    public void setDateTopic(Timestamp date) {
        this.dateTopic = date;
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

    public Topic(int id, Timestamp dateTopic, String title, String content, User user, Set<Inscription> inscriptions) {
        this.id = id;
        this.dateTopic = dateTopic;
        this.title = title;
        this.content = content;
        this.user = user;
        this.inscriptions = inscriptions;
    }

    public Topic() {
    }

}
