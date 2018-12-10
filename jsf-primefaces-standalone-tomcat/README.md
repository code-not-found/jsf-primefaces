# jsf-primefaces-standalone-tomcat

An example project on how to deploy PrimeFaces on a standalone Tomcat instance.

* [https://github.com/joinfaces/joinfaces/issues/77](https://github.com/joinfaces/joinfaces/issues/77)
* [https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#howto-create-a-deployable-war-file](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#howto-create-a-deployable-war-file)

Create the WAR file using: `mvn clean install`

Copy the WAR file in the `webapps` directory.

Access the application at: [http://localhost:8080/jsf-primefaces-standalone-tomcat-0.0.1-SNAPSHOT/helloworld.xhtml](http://localhost:8080/jsf-primefaces-standalone-tomcat-0.0.1-SNAPSHOT/helloworld.xhtml)
