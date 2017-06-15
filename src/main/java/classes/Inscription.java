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
    private Timestamp date;
    @Lob()
    private String content;
    @ManyToOne
    @JoinColumn(name="idUser")
    private User user;
    @ManyToOne
    @JoinColumn(name="idTopic")
    private Topic topic;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Inscription that = (Inscription) o;

        if (id != that.id) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        return topic != null ? topic.equals(that.topic) : that.topic == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (topic != null ? topic.hashCode() : 0);
        return result;
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
