<h1 align="center">Training Center Management System</h1>

<p align="center">
    <a href="https://www.java.com/" target="_blank">
        <img src="https://img.shields.io/badge/Java-17-red" alt="Java 17">
    </a>
    <a href="https://maven.apache.org/" target="_blank">
        <img src="https://img.shields.io/badge/Maven-4.0.0-blue" alt="Maven 4.0.0">
    </a>
    <a href="https://spring.io/projects/spring-boot" target="_blank">
        <img src="https://img.shields.io/badge/Spring Boot-3.2.4-brightgreen" alt="Spring Boot 3.2.4">
    </a>
</p>

<hr>

The Training Center Management System is a RESTful API designed to manage training centers. It allows users to create new training centers, fetch details of existing centers, and apply various filters and sorting mechanisms to efficiently manage and view training centers data.

<hr>

## Dependencies

- [Spring Boot Starter Data JPA](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-jpa): Provides support for Spring Data JPA, enabling easy interaction with databases using JPA.

- [Spring Boot Starter Web](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web): Provides basic web support, including embedded Tomcat server and Spring MVC.

- [MySQL Connector/J](https://mvnrepository.com/artifact/com.mysql/mysql-connector-j): JDBC driver for connecting to MySQL databases.

- [Lombok](https://mvnrepository.com/artifact/org.projectlombok/lombok): Reduces boilerplate code by providing annotations to generate getters, setters, constructors, and more.
 
- [Springdoc OpenAPI Starter WebMVC UI](https://mvnrepository.com/artifact/org.springdoc/springdoc-openapi-starter-webmvc-ui): Integrates OpenAPI documentation into Spring Boot applications.

- [Spring boot Starter validation](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-validation): Integrates Spring boot starter validation into Spring Boot applications.

## Features
  - **Create Training Center:** `Add new training centers with detailed attributes.`
  - **Fetch All Training Centers:** `Retrieve all training centers with options for filtering, sorting, and pagination.`
  - **Filtering:** `Filter the training centers based on various attributes such as center name, center code and student capacity etc.`
  - **Pagination:** `Efficiently manage large datasets by paginating the results.`
  - **Sorting:** `Sort training centers in ascending or descending order based on various attributes.`

## Enpoints

### Register New Training center

- **URL:** `/training-center/register`
- **Method:** `POST`
- **Description:** Registers a new Traning Center.
- **Request Body:**
    - JSON object representing the Training Center to be registered.
    - Includes details such as center name,center code, address etc.
 ```json
{
    "centerName": "Inovative Center",
    "centerCode": "AB3456789017",
    "address": {
        "addressDetails": "Near new Clonoy Sundar Nagar",
        "city": "Bhopal",
        "state": "MP",
        "pincode": "423457"
    },
    "studentCapacity": 110,
    "coursesOffered": [
        "Computer Science",
        "Mechanical Engineering",
        "Data Analysis",
        "Machine Learning",
        "Para Medical"
    ],
    "contactEmail": "info@inovation.com",
    "contactPhone": "7234567892"
}
```
![Screenshot (404)](https://github.com/sjha24/Backend_Traini8_saurav/assets/98340874/e8104f32-df8e-44d9-8434-9e944b51bf44)

## center registration response

```json
{
  "statusCode": 200,
  "message": "Training Center Created Successfully",
  "responseBody": {
    "id": 7,
    "centerName": "Inovative Center",
    "centerCode": "AB3456789017",
    "address": {
      "addressDetails": "Near new Clonoy Sundar Nagar",
      "city": "Bhopal",
      "state": "MP",
      "pincode": "423457"
    },
    "studentCapacity": 110,
    "coursesOffered": [
      "Computer Science",
      "Mechanical Engineering",
      "Data Analysis",
      "Machine Learning",
      "Para Medical"
    ],
    "createdOn": 1714274541,
    "contactEmail": "info@inovation.com",
    "contactPhone": "7234567892"
  }
}
```
![Screenshot (405)](https://github.com/sjha24/Backend_Traini8_saurav/assets/98340874/dd5e3770-945d-4f97-810a-8f376d120294)


### Fetch All Training Centers
**URL:**: `/training-center/all`
- **Method:** `GET`
- **Description:** Retrieves all training center saved in database.
- **URL ParamsOptional:** page=[integer] (default: 1),
- size=[integer] (default: 10),
- sortBy=[string] (default: 'createdOn'),
- direction=[asc|desc] (default: 'desc')
- Success Response:
**Responses Body:**
    - Success Response:
        - Status code: `200 OK`
     
  ![Screenshot (407)](https://github.com/sjha24/Backend_Traini8_saurav/assets/98340874/21d3f2c0-b0b0-45cb-b280-ed487afa8cd0)

### sort by student capacity in ascending order

![Screenshot (408)](https://github.com/sjha24/Backend_Traini8_saurav/assets/98340874/3b288d57-405a-4b5f-8da6-9768cf79656a)

### sort by center name in defending order(default)

![Screenshot (409)](https://github.com/sjha24/Backend_Traini8_saurav/assets/98340874/0bef87b5-231a-43d0-bf63-936e589b9f18)

## Users can filter the list of training centers based on the various atributes likes

![Screenshot (411)](https://github.com/sjha24/Backend_Traini8_saurav/assets/98340874/fcd50faf-4317-47a6-be53-a5cc3aaa4774)

### filter by center name
![Screenshot (410)](https://github.com/sjha24/Backend_Traini8_saurav/assets/98340874/1b034850-83a4-4f9c-8594-888255db12dc)

### filter by student capacity - which would return centers with a capacity greater than or equal to the specified number.

![Screenshot (413)](https://github.com/sjha24/Backend_Traini8_saurav/assets/98340874/4cbcb343-2e01-473a-83cd-545b5949c591)


## Swagger Support for API Documentation

The project includes Swagger support for API documentation. Swagger is a powerful tool that provides interactive documentation for RESTful APIs, enabling developers to explore and test endpoints easily. By integrating Swagger into your project, you can enhance the usability and understanding of your API, making it easier for developers to integrate with your system.

### Key Benefits of Swagger:
- **Interactive Documentation:** Swagger generates interactive documentation that allows developers to explore and test endpoints directly from the documentation interface.
- **Ease of Integration:** Developers can easily understand and integrate with your API by referring to the comprehensive documentation provided by Swagger.
- **Consistency:** Swagger ensures that the API documentation remains consistent with the actual implementation, reducing the chances of discrepancies.
- **Time-Saving:** With Swagger, developers can quickly understand the API structure and functionalities, saving time on integration and troubleshooting.

## Setup

1. Clone the repository:

   ```bash
   git clone https://github.com/sjha24/Backend_Traini8_saurav.git
   ```

2. Navigate to the project directory:

   ```bash
   cd BackendTraini8SauravApplication
   ```
3. Build the project using Maven:

   ```bash
   mvn clean install
   ```

4. Run the application:

   ```bash
   mvn spring-boot:run
   ```
## Database Setup

To set up the database for the WishlistManagement application, follow these steps:

1. Open the `application.yml` file in the project's `src/main/resources` directory.

2. Configure the datasource properties according to your MySQL database setup:
```
server:
  port: 8802

spring:
  datasource:
    driver: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://${DB_HOST_PORT}/${DB_NAME}
    username: ${DB_USER}
    password: ${DB_PASSWORD}
  jpa:
    hibernate:
      ddl-auto: update
    database: MYSQL
  ```

Replace `your_DB_HOST_PORT` , `DB_NAME`, `DB_USER` and `DB_password` with your MySQL database credentials.

## Accessing the Application

You can access the application through your web browser by navigating to `http://localhost:8802`.

## Custom Port Configuration

If you need to define your own port for accessing the application, you can do so by configuring it in the `application.yml` file. Simply specify the desired port number in the configuration file, and the application will listen on that port upon startup.

Example:
```
server:
  port:9000
```

## Contributing

Contributions are welcome! Please feel free to submit pull requests or open issues for any improvements or features you'd like to see.

