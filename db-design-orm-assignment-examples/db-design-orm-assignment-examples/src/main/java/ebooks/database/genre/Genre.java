package ebooks.database.genre;

import ebooks.database.ebook.Ebook;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "genres")
public class Genre {
    @Id
    private String genre;
    @OneToMany(mappedBy = "genre")
    private List<Ebook> ebooks;

    ///////////////////////////////////////////////////////////////////////////
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<Ebook> getEbooks() {
        return ebooks;
    }

    public void setEbooks(List<Ebook> ebooks) {
        this.ebooks = ebooks;
    }
}
