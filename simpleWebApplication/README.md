Author: SANJAIKUMAR P

Commit 1:
- In this project i have started with a simple request mapper with two url ("home", "about").
- When the url is called a specific text is mentioned in the return is sent to the front.
- All these come under a controller 

Commit 2: (message: Writing simple api to send data to front-end)
- The task for this time is to create a service that gives the data of the products.
- For this, i have created a controller (productController), that receives the request based on the URL.
- Then the controller has a object of the service, in the name of service and type serviceDataProducts. It is autowired so that object is created by spring.
- The controller sends the request by calling the service. 
- The service class then gets the data that are stored as List of type Product.
- In the generation of data, a list in instantiated and objects of the products are generated and using constructors the data is inserted.
- Finally, the data (objects) is sent back to the controller and the controller returns the data to the front end.

Commit 3: (HTTP request for GET and PUT, Adding new data)
- The task for this commit is to send get data based on a specific parameter and add new data.
- To get data based on Search:
  - We use a parameter in the URL that will bring the search parameter.
  - That parameter, prodID is then passed into the method with the annotation @PathVariable. it will say that the argument in the url must be pushed to the argument in the method.
  - From that we send the variable to service method i.e. getProductbyID. It will fetch with the StreamAPI and return the object which inturn will be sent to controller and client.
- To put data:
  - We send a data from the client in JSON format. It will be got by the Controller and saved in the argument with the annotation @RequestBody.
  - The method annotation @PutMapping says that this is an addition of data request and not a getter.
  - Rest is easily understandable in code. Just adds the sent object into the arrayList Products.

COMMIT 3: (SPRING DATA JPA - attach and do crud ops)
- The task is to attach a db with this and do crud operations on the project.
- We add the mysql driver, spring data jpa dependencies in the pom.xml file of the project. 
- Then we make the necessary configurations in the application.properties file (refer the file and the db based settings).
- declare the class that becomes the table as @Entity and the variable that becomes the primary key as @ID. 
- Create an interface that inherits JpaRepository<Class_name, PK_type> and in the same format, so that the table is created and mapped with the class mentioned.
- creating an object using @Autowired will get us a object and with that object we can perform operations on the DB, just by calling functions.