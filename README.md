# Clipper

In Revature's Social Network everyone is friends with everyone else. Users can register, login to the application, and start sharing multimedia with everyone. Registered users are allowed to modify their personal information and upload their profile pictures. The application provides a search feature that allows users to search out friends and look at their profiles. Users are provided with a "feed", in which they can see what everyone is posting and like posts. Users can access and use the application via an interactive client-side single paged application that stores and retrieves multimedia using AWS S3 and consumes a RESTful web service that provides business logic and access to a database.

### [Link to Front-end](https://github.com/MatthewLThomas/ClipperFront)

## Technologies Used

* PostgreSQL
* Agile-Scrum
* HTML
* SCSS
* JavaScript
* Typescript
* React
* Redux
* Agile-Scrum
* Enzyme/Jest
* AWS S3
* AWS EC2

## Features
* As a user
  * I can login.
  * I can register.
  * I can write a post.
  * I can like a post.
  * I can search other users and view their profile.
  * I can edit my profile. change my name, password and profile picture.
  * I can ask for a password reset and the application will send me an email on how to reset my password.

## Getting Started
1. Navigate to your desired directory in your terminal, and run this command: `git clone https://github.com/ricksnp/Clipper.git`
2. Import the project into your desired IDE as a Maven project. This is confirmed to work in Eclipse.
3. Get access to an SQL database. This project was created using PostgreSQL on an AWS RDS.
     a. Change the url, username, and password variables in your ApplicationConfig file, and hibernate config files, in src/main/resources.
4. Use Maven commands to build your project into a .war file. For more information on Maven, refer to documentation [here.](https://maven.apache.org/guides/index.html)
5. Deploy your application using a Server Runtime. This project originally ran on an Apache Tomcat server. You can find information on Apache Tomcat [here.](http://tomcat.apache.org/)

## Usage
1. Login:
<img src="login.JPG" />

2. Feed:
<img src="feed.JPG" />

3. Post Example:
<img src="post.JPG" />

4. Profile:
<img src="profile.JPG" />



## Contributors
* Matthew Thomas
* Nathan Ricks
* Dawit Wondim
* Nicolas Hernandez
* Daniel Constantinescu
