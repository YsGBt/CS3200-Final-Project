package ebooks.database.purchase;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ebooks.database.ebook.Ebook;
import ebooks.database.user.User;
import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "purchases")
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
//    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp purchaseDate;

    @ManyToOne
    @JsonIgnore
    private User user;
    @ManyToOne
    @JsonIgnore
    private Ebook ebook;

    @Transient
    private Integer userId;
    @Transient
    private String userName;
    @Transient
    private Integer ebookId;
    @Transient
    private String ebookName;

    ///////////////////////////////////////////////////////////////////////////
    @Transient
    public Integer getUserId() {
        if (user == null) {
            return userId;
        }
        return user.getId();
    }

    @Transient
    public String getUserName() {
        if (user == null) {
            return null;
        }
        return user.getFirstName() + " " + user.getLastName();
    }

    @Transient
    public Integer getEbookId() {
        if (ebook == null) {
            return ebookId;
        }
        return ebook.getId();
    }

    @Transient
    public String getEbookName() {
        if (ebook == null) {
            return null;
        }
        return ebook.getTitle();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Ebook getEbook() {
        return ebook;
    }

    public void setEbook(Ebook ebook) {
        this.ebook = ebook;
    }

    public Timestamp getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Timestamp purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
}
