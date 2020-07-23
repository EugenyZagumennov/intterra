###BUILD PROJECT
```
mvn clean package
```

###RUN PORJECT

```
cd <project_folder>
java -jar userservice-0.0.1-SNAPSHOT.jar
```

###TEST PROJECT
```
curl -d "[{\"name\": \"user1\", \"emails\": [\"xxx@ya.ru\", \"foo@gmail.com\", \"lol@mail.ru\"]}, {\"name\": \"user2\", \"emails\": [\"foo@gmail.com\", \"ups@pisem.net\"]}, {\"name\": \"user3\", \"emails\": [\"xyz@pisem.net\", \"vasya@pupkin.com\"]}, {\"name\": \"user4\", \"emails\": [\"ups@pisem.net\", \"aaa@bbb.ru\"]}, {\"name\": \"user5\", \"emails\": [\"xyz@pisem.net\"]}]" -H "Content-Type: application/json" -X POST "http://localhost:8080/simplify"
```
should get
```
{"user1":["aaa@bbb.ru","ups@pisem.net","lol@mail.ru","xxx@ya.ru","foo@gmail.com"],"user3":["vasya@pupkin.com","xyz@pisem.net"]}
```