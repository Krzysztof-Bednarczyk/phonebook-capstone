# Phonebook capstone app.
PhoneBook application is an example project created as a Spring MVC (REST) application.
The REST endpoints look as follows:

**_GET_** - receive all phoneBook records.  
**_GET/{name}_** - all phones for the given name.  
**_PUT/{name}_**; _phoneNumber_ - add a phone to an existing name.  
**_POST/_**; _{“name”:”YourName”, “phoneNumber”: “+79998887711”}_ - create a new record in the phoneBook.  
**_DELETE/{name}_** - removes record by name completely (including associated phone numbers).  

Rest resources must be located under **_api/v1/contacts_**.

Uses JSON as a request/response body.  
All records are kept in memory. It uses a mysql:5.7 docker database instance.  

**_DELETE/{name}_** - throws an exception if there is no such phone in the
PhoneBook. Exception is handled and the reason is printed out as a JSON object.

Java configuration is used in the App.

## How to use the app.
### Prerequisites
1. Java version 17 :coffee: -> openjdk 17.0.4 2022-07-19 LTS.
2. Docker :whale: -> [get Docker Desktop.](https://www.docker.com/products/docker-desktop/)
3. [Postman.](https://www.postman.com/downloads/) :post_office:
4. [Maven.](https://maven.apache.org/install.html)
5. [Intellij IDEA(optional).](https://www.jetbrains.com/idea/download/)

### Usage
1. Execute command `dokcer compose up -d`. A docker mysql instance should spin up. A separate volume for persistent data will be created on Your local machine.
Be sure that Your `port #3306` is not occupied. If so You need to edit the `docker-compose.yml` file :file_folder: in the ports section.
2. Execute command `mvn spring-boot:run`. The app will run and connect :electric_plug: to the mysql instance. 
3. Open `http://localhost:7070/api/v1/contacts` - The browser will ask You for username and password since the endpoint is secured. :closed_lock_with_key:  
_Below is the table with user credentials._

Username | Password | Role
--- | --- | ---
john | fun123 | **EMPLOYEE**
mary | fun123 | **MANAGER**
susan | fun123 | **ADMIN**

After login in. You should receive an empty array in response at the first run.  
  4. Use the provided Postman collection to add some users.

  ## Have fun and enjoy the App. :smile:
