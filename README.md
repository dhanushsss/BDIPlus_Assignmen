# BDIPlus_Assignmen

Brief description of this project.

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




## Navigate to the project directory:

   cd your-project



   API Endpoints

   
### Base URL: http://localhost:8080
## Endpoint	Method	Description
### /api/v1/customers/all	GET	Get a list of all customers
### /api/v1/customers/{customerId}	GET	Get customer details by ID
### /api/v1/customers/addBankCustomer	POST	Add a new customer
### /api/v1/customers/update/{customerId}	PUT	Update an existing customer by ID
### /api/v1/customers/delete/{customerId}	DELETE	Delete a customer by ID


## Add a New Customer
### Endpoint: http://localhost:8080/api/v1/customers/add
### Method: POST
### Request Body:

{
  "customerName": "John Doe",
  "customerEmail": "john.doe@example.com",
  "customerPhoneNumber": "+1234567890",
  "customerPassword": "secret",
  "customerAddress": "123 Main St",
  "customerUserName": "johndoe",
  "customerCardNo": 1234567890123456
}







