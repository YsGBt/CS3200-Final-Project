package ebooks.database.genre;

import ebooks.database.ebook.Ebook;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "genres")
public class Genre {
    @Id
    @Column(name = "genre")
    private String id;
    @OneToMany(mappedBy = "genre")
    private List<Ebook> ebooks;

    ///////////////////////////////////////////////////////////////////////////
    public String getId() {
        return id;
    }

    public void setId(String genre) {
        this.id = genre;
    }

    public List<Ebook> getEbooks() {
        return ebooks;
    }

    public void setEbooks(List<Ebook> ebooks) {
        this.ebooks = ebooks;
    }
}
