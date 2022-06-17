## start the local dynamoDB using docker-compose
``` docker-compose up -d```
## Start the springboot application
## Use below api's
GET ```localhost:8001/producer```  
GET ```localhost:8001/consumer```   
POST ```localhost:8001/producer/orders ```   --> publish messages
``` 
{
    "orderId":"1380661f-de81-485b-a4ab-8110bba8c8fa",
    "name":"Monitor",
    "price": 23749
}
```

GET ```localhost:8001/consumer/orders  ```   --> retrieve List of unprocessed messages from orders topic
