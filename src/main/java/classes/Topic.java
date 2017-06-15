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
    private Timestamp date;
    private String title;
    @Lob()
    private String content;
    @ManyToOne
    @JoinColumn(name="idUser")
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Topic topic = (Topic) o;

        if (id != topic.id) return false;
        if (date != null ? !date.equals(topic.date) : topic.date != null) return false;
        if (title != null ? !title.equals(topic.title) : topic.title != null) return false;
        if (content != null ? !content.equals(topic.content) : topic.content != null) return false;
        if (user != null ? !user.equals(topic.user) : topic.user != null) return false;
        return inscriptions != null ? inscriptions.equals(topic.inscriptions) : topic.inscriptions == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (inscriptions != null ? inscriptions.hashCode() : 0);
        return result;
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
