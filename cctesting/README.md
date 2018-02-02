1) Please create a Spring Boot application with a "Hello World" REST endpoint. 
This is a simle get call to show you a " Hello World" message
curl -XGET 'http://localhost:8080/helloworld'

2) Please add a REST endpoint that accepts a JSON object containing a paragraph of text and returns a JSON array of objects. The returned objects represent the unique words from the supplied paragraph along with a count of the number of occurrences. The array of objects must be sorted alphabetically.
This is a post call , "1" can be random input, the actual input string is the value of "1"

curl -XPOST -H "Content-type: application/json" -d '{
	"1":"The top priorities in retail are to create shopping experiences with engaging digital applications and streamlining the path to purchase. The era of integrated omnichannel retail is built on experiences that delight consumers. Nobal creates innovative and intuitive digital interfaces to enhance customer experience"
}' 'http://localhost:8080/wordscount'

3) Please add a REST endpoint that accepts a number, N, and returns a JSON array with the first N Fibonacci numbers. Please use the recursive form of Fibonacci. Be prepared to answer O() complexity questions when we review the submission by phone.
This is a get call , only need to replace the "5" to the number N

curl -XGET 'http://localhost:8080/fibonacci/5'

4) Please add a REST endpoint that creates two threads that become deadlocked with each other. 
There are two endpoints in this service, 

This threadsstart endpoint will start two deadlock threads in the backend. And printout the according thread ID
curl -XGET 'http://localhost:8080/threadsstart'

This deadlockmonitor endpoint will return the current deadlock threads amount and the according thread ID. You can call this endpoint before and after calling threadstart 
curl -XGET 'http://localhost:8080/deadlockmonitor'

5) Please add three REST endpoints that add, query, and delete rows in a database.
add method:   
curl -XPOST -H "Content-type: application/json" -d '{
	"name":"Tom",
	"age":34
}' 'http://localhost:8080/user'

query method you can replace "Tom" to other name which you want to query
curl -XGET 'http://localhost:8080/user/Tom'

delete method you can replace "Tom" to other name which you want to delete
curl -XDELETE 'localhost:8080/userremove/Tom'

6) Finally, please create a REST endpoint that queries an external REST service using Spring RestTemplate. The response should be returned to the caller. 

This endpoint will return everything from the external REST service
curl -XGET 'http://localhost:8080/extservice'

This endpoint will query the result based on UserID "2" , and return all records of UserID 2 in a List you can replace "2" to other userID
curl -XGET 'http://localhost:8080/extservice/2'
