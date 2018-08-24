# helix_leisure_singapore

How to run the code
-------------------

This code uses MySQL database.
1) Crate a MySQL database.
2) Update com.example.helixLeisure.configuration.BeanConfig.java datasource with the following:  
	a) Database  
	b) Username  
	c) Password  
3) Run the application code with the following command:  
   a) mvn spring-boot:run  
   
Note: Each time the application run, it will recreate the database schema.

How to call Restful Webservice
------------------------------

To put products, call the following service:
1) http://localhost:8080/api/put/products

Method: POST  
Json:  
{
  "id": null,
  "timestamp": "1534964400",
  "products": [
    {
      "id": null,
      "name": "Can Soup",
      "quantity": "2",
      "amount": "3.55"
    },
    {
      "id": null,
      "name": "XXL Shirt",
      "quantity": "4",
      "amount": "9.50"
    }
  ]
}

To get products, call the following service:
1) http://localhost:8080/api/get/products?id={id}

Method: GET  
Parameter: Event id
