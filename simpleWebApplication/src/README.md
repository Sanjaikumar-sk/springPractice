Author: SANJAIKUMAR P

Commit 1:
- In this project i have started with a simple request mapper with two url ("home", "about").
- When the url is called a specific text is mentioned in the return is sent to the front.
- All these come under a controller 

Commit 2: (message: Writing simple api to send data to front-end)
- The task for this time is to create a servie that gives the data of the products.\
- For this, i have created a controller (productController), that recieves the request based on the URL\
- Then the controller has a object of the service, in the name of service and type serviceDataProducts. It is autowired so that object is created by spring.\
- The controller sends the request by calling the service. 
- The service class then gets the data that are stored as List of type Product.
- In the generation of data, a list in instantiated and objects of the products are generated and using constructors the data is inserted.
- Finally, the data (objects) is sent back to the controller and the controller returns the data to the front end. 