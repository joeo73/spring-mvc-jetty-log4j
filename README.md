Spring MVC Embedded Jetty Example
=================================

I wasn't able to find this in the world and it took me a bit to put it together.
Hopefully this will save some one else some time if you want to utilize spring MVC without
all the weight and dependencies of Spring Boot.

Basic Spring MVC 5 application using embedded Jetty 9 server. 

* Non-xml configuration. 
* Non-spring boot implementation

Includes a simple hello world JSON REST service utilizing Jetty, Jackson and Logback

Requirements
------------
* [Java Platform (JDK) 9](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
* [Apache Gradle 4.x](https://gradle.org/)