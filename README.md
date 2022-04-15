# CS3200-Final-Project

## Final Project For CS3200 
> **Project Name:** Ebook Store <br />
> **Team member:** YsGBt, Kevin Park <br />
 
## Brief Description of The Project
> The goal of our project is to create a basic e-book store. There are users, eBooks, authors, purchase records, and eBook genres in our database. Users may buy any book in the database and see their purchase history, as well as information about the book they bought, such as the book title, genre and author. <br />
> Our User Interface is implemented through React JS. To run the User Interface: <br />
> 1. Import all the data and structure from src/main/other/sql/db_design_final_project_database.zip to sql database. <br />
> 2. Change the url, username, and password in src/main/resources/application.properties to connect with your local database. <br />
> 3. Run the `DemoApplication` in src/main/java/ebooks/database. <br />
> 4. Copy the following link and paste it into your web browser: <br />
> http://localhost:63342/db-final-project-ebook-store/spring-template/src/main/webapp/ebook.store/ <br /> <br />
> ![Link to UML class diagram](https://github.com/YsGBt/CS3200-Final-Project/blob/main/cs3200-final-project-UML.PNG?raw=true) <br />

## User Interface Requirements
> ### There are five kind of screens: <br />
> > - **`Table`** List all the tables stored in the database. Each record render allow navigating to List Screen. <br />
> > - **`List Screen`** List all the records stored in a table. Each record render allow navigating to Edit Screen. Include a "creat" button to create a new record. <br />
> > - **`Editor Screen`** Reads, updates or remove an existing record. If the record contains a one-to-many relationship, there should be a link to the many-to-one edit screen (if the record being edited is on many side)/ one-to-many list screen (if the record being edited is on one side). <br />
> > - **`Many-to-one Edit Screen`** Function the same as Editor Screen. Find the one side record by the many side id. <br />
> > - **`One-to-many List Screen`** List all the associated records on the many side. Include a "creat" button to create a new record. <br />
> ### Implementation details: <br />
> > - `User` can only purchase the e-book if the user born before the purchase date and the book is published before the purchase date. <br />
> > - `User` are not allowed to pruchase the same e-book multiple time. <br />
> > - `Author` can only publish the e-book if the author born before the publish date. <br />
> > - `Genre` cannot be create, update, or delete as it is an enumeration class. <br />

## Problem Statement:
> The problem that our project is trying to solve is to capture our newly opened EBook store in a database that can keep track of users purchases to Ebooks. We want to allow users of our EBook store to be able to purchase different kinds of EBooks and get the related information about the EBook they are purchasing. This will include the author of an EBook and the genre. We will also let the user view their purchases and to login with a profile. 

## Solution Statement:
> Our solution to this was to first represent a user with fields first name, last name, username, password, email, and date of birth. This will represent the profile of the user. We then had to represent an EBook with useful fields that a user would need to know when purchasing it such as the title, purchase year, and author. We also represented the author as its own table, so that users can find out more about that author such as their first name, last name, and date of birth. The only genres of books that our EBook sells are fantasy, mystery, science fiction, historical fiction, and romance so we had to represent this as an enumeration. Users can view a list of EBooks that are a certain genre if they are interested in one. 

## User:
> The typical users that will use our solution are people who are interested in buying EBooks. We have a number of EBooks that we sell in our EBook store and the user can look up a list of EBooks that we are selling by genre or author, and they can keep track of the purchases that they have made. 

## Domain Objects: 
> The domain we are considering is an EBook store and the two domain objects that we have implemented in our solution are an EBook and an Author. We represented an EBook to have a title, purchase year, and a reference to an author. We represented an Author to have a first name, last name, and date of birth. In the user interface, a user can interact with an EBook by clicking on it and seeing who wrote the book, the title of the book, when it was published, and the genre of the book. They can also click on the author of the book to learn more about the author. A user can interact with an author by clicking on one, to see their name, their date of birth, and a list of EBooks that they have written. 


## Description of The User Model:
> The `user` of this application is represented as a user in our EBook store. The user can see their purchases to EBooks and can view the author of those EBooks. The user is represented to have a first and last name, a username and password to login to the application, an email for notifications, and a date of birth. All of these are represented as strings except for the date of birth which is represented as a date.

## Description of The Two Domain Object Data Models:
> Our EBook store is represented to have two domain objects which are `EBooks` and `Author`. The EBooks domain object represents an EBook that has a title represented as a string, published year represented as an integer, and a genre as an enumeration. The author domain object represents an author of an EBook represented to have a first name and last name as a string and a date of birth represented as a date.

## Description of The User Domain Object Relationship:
> There is only one relationship between a user and a domain object, and this is from a user to an EBook. We represent this relationship as a user has `purchased` a specific EBook. We represent this relationship as a many-to-many relationship as one user can buy many EBooks and an EBook can we purchased by many users. We reify to a class named Purchases, but we add a field which is purchaseDate represented as a date.

## Description of The Domain Object To Domain Object Relationship:
> There is only one relationship between a domain object and another domain object, and this is from an Author to an Ebook. We represent this relationship as an Author who wrote an Ebook as a one-to-many relationship. This is because an author can write many different EBooks.

## Description of The Portable Enumeration:
> We wanted to represent the list of `genres` of books that are available in our EBook store as a portable enumeration. There are only five genres of EBooks that our store sells and those are fantasy, mystery, science fiction, historical fiction, and romance. We represented this not using the SQL keyword but as a class as its own. The value of the primary key is the name of the genre as a string. **We disallow the addition or deletion of new genres in the UI.**
