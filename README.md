# BDIPlus_Assignment

# Bank Customer Management

- The Bank Customer Management  is a Spring Boot application designed for managing bank customer records. It provides full CRUD (Create, Read, Update, Delete) operations to handle customer data. This system offers a user-friendly interface for adding , retrieving, Deleting customer information.

## Technologies Used:

- Spring Boot: The project is built using Spring Boot, a powerful framework that simplifies the development of robust and scalable Java applications.

- RESTful API: The application exposes a RESTful API, allowing seamless communication with the backend services.

- Database: Bank customer data is stored and managed efficiently in a relational database system, like MySQL.




## Prerequisites

Before you begin, ensure you have met the following requirements:

- Java JDK 8 or higher
- Maven (for building the project)
- MySQL database
- Web browser (Chrome , firefox , safari etc.)
- Postman for API testing

## Getting Started

1. Clone the repository:

   ```shell
   git clone https://github.com/dhanushsss/BDIPlus_Assignmen.git
   ```



## Navigate to the project directory:

```shell
   cd your-project
```

## Build the project using Maven:

```shell
mvn clean install
```

## Start Spring Boot Project.

``` shell
   Maven spring-boot:run
```

## Create a MySQL database and update the application.properties file with your database configuration:

``` application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/Bank
spring.datasource.username=username
spring.datasource.password=password
```



# API Endpoints

### Base URL: http://localhost:8080
## Endpoint	Method	Description
- /api/v1/customers/all	GET	Get a list of all customers
- /api/v1/customers/{customerId}	GET	Get customer details by ID
- /api/v1/customers/addBankCustomer	POST	Add a new customer
- /api/v1/customers/update/{customerId}	PUT	Update an existing customer by ID
- /api/v1/customers/delete/{customerId}	DELETE	Delete a customer by ID

# Testing the APIs
- I used a tool Postman to test the API endpoints.
- Send requests to the API endpoints using the imported collection.


# Sample 

## Add a New Customer
### Endpoint: http://localhost:8080/api/v1/customers/add
### Method: POST



``` json
{
  "customerName": "John Doe",
  "customerEmail": "john.doe@example.com",
  "customerPhoneNumber": "+1234567890",
  "customerPassword": "secret",
  "customerAddress": "123 Main St",
  "customerUserName": "johndoe",
  "customerCardNo": 1234567890123456
}
```


## Update an Existing Customer
### Endpoint: http://localhost:8080/api/v1/customers/update/{customerId}
### Method: PUT



## Delete a Customer
### Endpoint: http://localhost:8080/api/v1/customers/delete/{customerId}
### Method: DELETE
### Send a DELETE request to delete a customer by ID. Replace {customerId} with the customer's ID.








