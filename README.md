# CS3200-Final-Project

## Final Project For CS3200 
> **Project Name:** Ebook Store <br />
> **Team member:** Qishen Pang, Kevin Park <br />
 
## Brief Description of The Project
> [Link to UML class diagram](https://github.com/YsGBt/CS3200-Final-Project/blob/main/db_design_final_project_UML.pdf) <br />
> Ohe goal of our project is to create a basic e-book store. There are users, eBooks, authors, purchase records, and eBook genres in our database. Users may buy any book in the database and see their purchase history, as well as information about the book they bought, such as the book title, genre and author. <br />
> Our User Interface is implemented through JavaScript's React. To run the User Interface: <br />
> 1. Import all the data and structure from src/main/other/sql/db_design_final_project_database.zip to sql database. <br />
> 2. Change the url, username, and password in src/main/resources/application.properties to connect with your local database. <br />
> 3. Run the DemoApplication in src/main/java/ebooks/database. <br />
> 4. Copy the following link and paste it into your web browser: <br />
> http://localhost:63342/db-final-project-ebook-store/spring-template/src/main/webapp/ebook.store/ <br />

## User Interface Requirements
> ### There are five kind of screens: <br />
> > - **Table** List all the tables stored in the database. Each record render allow navigating to List Screen. <br />
> > - **List Screen** List all the records stored in a table. Each record render allow navigating to Edit Screen. Include a "creat" button to create a new record. <br />
> > - **Editor Screen** Reads, updates or remove an existing record. If the record contains a one-to-many relationship, there should be a link to the many-to-one edit screen (if the record being edited is on many side)/ one-to-many list screen (if the record being edited is on one side). <br />
> > - **Many-to-one Edit Screen** Function the same as Editor Screen. Find the one side record by the many side id. <br />
> > - **One-to-many List Screen** List all the associated records on the many side. Include a "creat" button to create a new record. <br />
> ### Implementation details: <br />
> > 1. User can only purchase the e-book if the user born before the purchase date and the book is published before the purchase date. <br />
> > 2. User are not allowed to pruchase the same e-book multiple time. <br />
> > 3. Author can only published the e-book if the author born before the published date. <br />
