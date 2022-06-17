## Start the local kafka, zookeeper nodes using docker-compose
``` docker-compose up -d```  
This brings up zookeeper: ```localhost:2181```   
kafka nodes: ```localhost:9092```,```localhost:9093```   
And also kafdrop, a UI tool to visualize topics and messages on: ```localhost:9000```
## Start the springboot application
## Use below ReST  APIs in postman
GET ```localhost:8001/producer```--> check health of producer  
GET ```localhost:8001/consumer```--> check health of consumer  
POST ```localhost:8001/producer/orders ```   --> publish messages
``` 
{
    "orderId":"1380661f-de81-485b-a4ab-8110bba8c8fa",
    "name":"Monitor",
    "price": 23749
}
```

GET ```localhost:8001/consumer/orders  ```   --> retrieve List of unprocessed messages from orders topic  