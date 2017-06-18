package classes;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by jakub on 14.06.2017.
 */
@Entity
@Table(name="inscription")
public class Inscription implements Serializable{

    @Id
    @GeneratedValue
    private int id;

    @Lob()
    private String content;

    private Timestamp dateInscription;

    @ManyToOne
    @JoinColumn(name="idtopic")
    private Topic topic;

    @ManyToOne
    @JoinColumn(name="iduser")
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(Timestamp date) {
        this.dateInscription = date;
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

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public Inscription(int id, Timestamp dateInscription, String content, User user, Topic topic) {
        this.id = id;
        this.dateInscription = dateInscription;
        this.content = content;
        this.user = user;
        this.topic = topic;
    }

    public Inscription() {
    }
}
