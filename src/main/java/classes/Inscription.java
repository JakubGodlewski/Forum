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

    private Timestamp date;

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

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
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

    public Inscription(int id, Timestamp date, String content, User user, Topic topic) {
        this.id = id;
        this.date = date;
        this.content = content;
        this.user = user;
        this.topic = topic;
    }

    public Inscription() {
    }

    @Override
    public String toString() {
        return "Inscription{" +
                "id=" + id +
                ", date=" + date +
                ", content='" + content + '\'' +
                ", user=" + user +
                ", topic=" + topic +
                '}';
    }
}
