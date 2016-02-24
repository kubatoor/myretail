This is a sample product REST API which responds to GET and POST and is backed by Cassandra 2.1.13 Nosql DB . This application is built using Spring boot with basic authentication(user/user).
Below are the steps to setup the whole application

(1) Download and run the open source version of apache cassandra 2.1.13 locally at port 9042
(2) Create a new keyspace called "myretail"
(3) Create a new table "product" in myretail keyspace using the following DDL statement

CREATE TABLE myretail.product (
    productid bigint PRIMARY KEY,
    currency text,
    price decimal
)

(4) Download the source code from github (https://github.com/kubatoor/myretail)
(5) Run the application locally using the command ./gradlew bootrun. The application runs at port 8080 and can be accessed using http://localhost:8080
(6) If you want to run it as an executable jar then execute following commands
    ./gradlew clean build
    java -jar build/libs/myretail-0.0.1-SNAPSHOT.jar
(7) Execute sample HTTP requests using Chrome Plugin for REST called POSTMAN. Ofcourse any other client can also be used.
(8) Below are sample request and response objects
    
    The below REST end point responds to GET and PUT
    http://localhost:8080/product/{id}
 
    (A) PUT http://localhost:8080/product/16696652
    	 Request Body {"id":16696652,"name":"BIG LEBOWSKI, THE Blu-ray","current_price":{"value":700,"currency_code":"USD"}}
    
    The above request will insert record in the product table with productId and pricing information.
    
    (B) GET http://localhost:8080/product/16483589
        Response Body {"id": 16483589,"name": "AT&T iPhone 6 plus Gold 128GB","current_price": {"value": 488,"currency_code": "USD"}}
    
    The above request will get the product price from backend database based on productID and also calls api.target.com URL to get Product Name
    and collates the information and returns the response. 
    
    PS:-Before executing a GET request for a particular productID, kindly make sure that the product exists in product table either by manually inserting the record
    or by executing PUT request before executing GET request
    
    
