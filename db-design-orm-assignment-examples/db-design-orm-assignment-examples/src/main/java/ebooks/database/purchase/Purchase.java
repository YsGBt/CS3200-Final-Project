package ebooks.database.purchase;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ebooks.database.ebook.Ebook;
import ebooks.database.user.User;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "purchases")
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date purchaseDate;

    @ManyToOne
    @JsonIgnore
    private User user;
    @ManyToOne
    @JsonIgnore
    private Ebook ebook;

    @Transient
    private String userName;
    @Transient
    private String ebookName;

    ///////////////////////////////////////////////////////////////////////////
    @Transient
    public String getUserName() {
        if (user == null) {
            return null;
        }
        return user.getFirstName() + " " + user.getLastName();
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

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
}
