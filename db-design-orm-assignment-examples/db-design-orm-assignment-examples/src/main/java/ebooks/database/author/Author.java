package ebooks.database.author;

import ebooks.database.ebook.Ebook;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "authors")
public class Author {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String firstName;
  private String lastName;
  private Timestamp dateOfBirth;

  @OneToMany(mappedBy = "author")
  private List<Ebook> ebooks;

  ///////////////////////////////////////////////////////////////////////////
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Timestamp getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(Timestamp dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public List<Ebook> getEbooks() {
    return ebooks;
  }

  public void setEbooks(List<Ebook> ebooks) {
    this.ebooks = ebooks;
  }
}
