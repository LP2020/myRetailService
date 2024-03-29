# myRetailService
# Requirements:
myRetail is a rapidly growing company with HQ in Richmond, VA and over 200 stores across the east coast. myRetail wants to make its internal data available to any number of client devices, from myRetail.com to native mobile apps. 
The goal for this exercise is to create an end-to-end Proof-of-Concept for a products API, which will aggregate product data from multiple sources and return it as JSON to the caller. 
Your goal is to create a RESTful service that can retrieve product and price details by ID. The URL structure is up to you to define, but try to follow some sort of logical convention. 
Build an application that performs the following actions: 
· Responds to an HTTP GET request at /products/{id} and delivers product data as JSON (where {id} will be a number. 
· Example product IDs: 15117729, 16483589, 16696652, 16752456, 15643793) 
· Example response: {"id":13860428,"name":"The Big Lebowski (Blu-ray) (Widescreen)","current_price":{"value": 13.49,"currency_code":"USD"}} 
· Performs an HTTP GET to retrieve the product name from an external API. (For this exercise the data will come from redsky.target.com, but let’s just pretend this is an internal resource hosted by myRetail) 
· Example: http://redsky.target.com/v2/pdp/tcin/13860428?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics 
· Reads pricing information from a NoSQL data store and combines it with the product id and name from the HTTP request into a single response. 
· BONUS: Accepts an HTTP PUT request at the same path (/products/{id}), containing a JSON request body similar to the GET response, and updates the product’s price in the data store. 


# Technology Stack:
⦁	Java v1.8.0_221
⦁	Apache Maven v3.6.2
⦁	Spring-boot v2.1.1 (Microservice)
⦁	MongoDB v4.2.0
# Technology Tools:
⦁	Postman v7.8, Eclipse IDE Neon, Robo 3T for GUI access to MongoDB to view and edit the data. GitHub

# Build:

1.	Clone the project repository from GitHub 
2.	Create retaildb database, collections (products) (Note: No credentials were given for accessing DB)
3.	Import the project as Maven project into the Eclipse IDE.
4.	Perform Maven Clean and Maven Install which will generate the artifact myretail-service-0.0.1-SNAPSHOT.war

# How to execute:
# Option A:
1.	Open Command Prompt and run the generated artifact service-0.0.1-SNAPSHOT.war from the location it is available using the below command:
java -jar myretail-service-0.0.1-SNAPSHOT.war

2.	Built-in Tomcat server is started successfully and available on port number 8000
3.	Application myRetail Service is accessible on port 8000

# Option B:
Deploy the myretail-service-0.0.1-SNAPSHOT.war in any application server(Weblogic, WebSphere etc/.)

Note: Application connects to MongoDB as a localhost

# How to test:

Open Postman and run below scenarios

# Scenario 1: Create products with the following details
URL:  http://localhost:8000/myretail/product
Method Type: POST

Request body: {
"productid": 13673298,
"productname":"Skinny Pop",
"productprice":"4.50",
"currencycode":"USD",
"mfgdate":"15-SEP-2019",
"expdate":"25-NOV-2019"
}

# Scenario 2: Find all products using the following details
URL: http://localhost:8000/myretail/products
Method Type: GET

# Scenario 3: Find Product by productid:
URL: http://localhost:8000/myretail/product/13673298 (sample product id)
Method Type: GET

# Scenario 4: Update the price for a product:
URL:http://localhost:8000/myretail/product/11090426 (sample product id)
Method Type: PUT

{
"productprice":"3.99"
}


# How to Leverage this code:
Ensure to secure the service end points

Exception Handling  needs to be incorporated

Error codes, status codes need to be incorporated

Caching needs to be enabled in the services to improve the performance of the get calls 

Ensure periodic backups on the database

Set up load balancing in production environment to efficiently and intelligently distribute client requests or incoming network traffic across multiple servers

Update the documentation and ensure that standards and best practices are followed at all stages.

