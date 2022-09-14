<!-- TITLE -->
# Handle With Scare API
This is the API for a horror story fan-fic website. The frontend component can be found [here](https://github.com/revature-2206-social-capstone/angular). The full stack of this application was built using Java and Angular.

<!-- FEATURES -->
## Features
- A user can register an account and login.
- A user can reset their password.
- A user can create posts, reply to posts, and like posts.
- A user can manage a profile page, including changing their username, description, birthday, and profile picture.
- A user can search for other users and follow other users.

<!-- TECHNOLOGIES USED -->
## Technologies Used
- Java
- Spring Boot
- PostgreSQL
- Maven

<!-- GETTING STARTED -->
## Getting Started

<!-- getting started steps -->
### Clone the repo:
   ``` 
   git clone https://github.com/revature-2206-social-capstone/spring.git
   ```
### (Optional) Add database driver:
   
   This project was built using a PostgresSQL database. If you would like to use PostgreSQL do nothing, but you can use your preferred by going to https://mvnrepository.com/ and finding the driver there, adding the dependency into the POM file, and updating the maven project. 
   
### Update the application.yml file:
   
   In src/main/resources/application.yml change the url, username, password, driver class name, and (optional) port. Additionally change the database platform if neccessary and choose the ddl-auto option (none, create, create-drop, validate, update)
   

<!-- CONTRIBUTING -->
## Contributing

1. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
2. Create Branch Upstream (`git push --set-upstream origin [feature/AmazingFeature]`
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
3. Push to the Branch (`git push feature/AmazingFeature`)
4. Open a Pull Request to Development Branch Once Feature is Complete
