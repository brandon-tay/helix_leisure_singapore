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
