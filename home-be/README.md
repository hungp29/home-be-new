#### 1. Pre-requisites
- Scala 2.13.x
- SBT 1.10.5 or higher
- JDK 21

#### 2. How to run the application
- We are using SBT as a build tool. To run the application, you need to have SBT installed on your machine.
- The application is using the Jooq code generator to generate the database schema. So, you need to have a database schema to run the application.
After setting up the database schema, you need to update the database configuration in the `application.conf` and `jooq-codegen.xml` files.
- Run the following command to generate the Jooq classes:
```
sbt jooqCodegen
```
- Clone the repository to your local machine.
- Open the terminal and navigate to the project directory.
- Run the following command to run the application:
```
sbt run
```
