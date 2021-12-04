package ebooks.database.ebook;

import ebooks.database.author.Author;
import com.fasterxml.jackson.annotation.JsonIgnore;
import ebooks.database.genre.Genre;
import ebooks.database.purchase.Purchase;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "ebooks")
public class Ebook {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String title;
  private int publishedYear;

  @ManyToOne
  @JoinColumn(name = "genre")
  @JsonIgnore
  private Genre genre;
  @ManyToOne
  @JsonIgnore
  private Author author;
  @OneToMany(mappedBy = "ebook")
  private List<Purchase> purchases;

  @Transient
  private String genreType;
  @Transient
  private Integer authorId;
  @Transient
  private String authorName;

  ///////////////////////////////////////////////////////////////////////////
  @Transient
  public String getGenreType() {
    if (genre == null) {
      return genreType;
    }
    return genre.getId();
  }

  @Transient
  public Integer getAuthorId() {
    if (author == null) {
      return authorId;
    }
    return author.getId();
  }

  @Transient
  public String getAuthorName() {
    if (author == null) {
      return null;
    }
    return author.getFirstName() + " " + author.getLastName();
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public int getPublishedYear() {
    return publishedYear;
  }

  public void setPublishedYear(int publishedYear) {
    this.publishedYear = publishedYear;
  }

  public Genre getGenre() {
    return genre;
  }

  public void setGenre(Genre genre) {
    this.genre = genre;
  }

  public Author getAuthor() {
    return author;
  }

  public void setAuthor(Author author) {
    this.author = author;
  }

  public List<Purchase> getPurchases() {
    return purchases;
  }

  public void setPurchases(List<Purchase> purchases) {
    this.purchases = purchases;
  }
}
