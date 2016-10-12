Introduction
============
Hi there! This is the source code bundle that goes with the
"Google Guice: Agile Lightweight Dependency Injection Framework" book from
Apress. If you have any questions regarding the
code (or the book), feel free to contact me directly.

Robbie Vanbrabant (robbie.vanbrabant@gmail.com)
http://garbagecollected.org

Apress
http://www.apress.com

Google Guice
http://code.google.com/p/google-guice

JCIP anntotations license note:
Copyright (c) 2005 Brian Goetz and Tim Peierls
Released under the Creative Commons Attribution License
(http://creativecommons.org/licenses/by/2.5)
Official home: http://www.jcip.net

Chapter04
=========
Contains the source code to the example in the chapter.
Needs guice-1.0.jar and aopalliance.jar to compile and run.
(Tip: copy these files over from one of the other chapters)

Chapter06
=========
This directory contains two items:
- The ShoppingList directory, containing the Eclipse project.
- The shopping_list_20080329_1806.sql file, which you can use to set up the 
  database for the project.

Preconfigure:
1) Install Ant (http://ant.apache.org, 1.7.0 recommended) and make sure
   you've set your JAVA_HOME envirment variable and that you've added
   JAVA_HOME/bin and ANT_HOME/bin to your system path.
2) Open up a command window and change directory to the location of this
   README.txt file.
3) type "ant chapter06" and hit the enter key. This downloads most of the
   project's dependencies to Chapter06/ShoppingList/WEB-INF/lib
4) Download the JTA jar manually from http://java.sun.com/products/jta/,
   name it "jta.jar" and also put it in Chapter06/ShoppingList/WEB-INF/lib

Configure and run:
1) Install MySQL (http://www.mysql.com) and choose root/root as the 
   username/password combination.
2) Using the MySQL Guice Tools run the sql file to set up the shopping_list
   schema for use. You could also let Hibernate take care of this but this file
   also comes with a small list of products you can play with.
3) Import the ShoppingList project in Eclipse and correct its JVM settings to 
   match your workstation's configuration.
4) Run the JettyRunner class in the default package. This will start the Jetty
   web container. If you have any issues running Jetty, make sure you don't
   have another service running on that port (like Tomcat).
5) Open up your browser and go to http://localhost:8080
6) Log in using the "Robbie" or "Dhanji" user name (no password).

Appendix
========
Contains an Eclipse project.

The project contains the binder example and the various web examples. 
It does not contain the SessionPerRequestInterceptor; you can find that one in
the Chapter 6 code.

Preconfigure:
1) Install Ant (http://ant.apache.org, 1.7.0 recommended) and make sure
   you've set your JAVA_HOME envirment variable and that you've added
   JAVA_HOME/bin and ANT_HOME/bin to your system path.
2) Open up a command window and change directory to the location of this
   README.txt file.
3) type "ant appendix" and hit the enter key. This downloads all of the 
   project's dependencies to Appendix/appendix/WEB-INF/lib

Run:
To run the web examples copy the relevant web.xml file into WEB-INF
and run the JettyRunner class in the default package. Then the application,
if you can call it that, will be available at http://localhost:8080