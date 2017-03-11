# Java EE Guestbook
Simple Java EE project built using Maven, Java EE 7, and Wildfly. This archetype was using [javaee 7 essentials artifact](https://github.com/AdamBien/javaee7-essentials-archetype)

## Requirements
1. Java SDK version 1.7
2. Maven version 3.3.9
3. Wildfly 10.1.0.FINAL

## Documentation

* Retrieve All Resources

```
curl -i -H "Content-Type: application/json" http://127.0.0.1:8080/guestbook/resources/messages
```

* Created New Resources

```
curl -i -H "Content-Type: application/json" -X POST -d '{"name": "sukma", "created": "2017-03-10"}'
http://127.0.0.1:8080/guestbook/resources/messages
```

*NOTES: For a better information when using curl, use python json.tool:*

 ```
 curl -i -H "Content-Type: application/json" http://127.0.0.1:8080/guestbook/resources/messages | python -m josn.tool
 ```