To run WebApp use command
> mvn clean jetty:run

Sample web pages should be available by the following links:
http://localhost:8080/WebApp/ucu/hello?name=Man!
http://localhost:8080/WebApp/ucu/add

To add new page you should implement WebCommand interface and register this implementation at WebAppServlet.commandsMap (with appropriate url mapping)