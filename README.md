# Introduction
## What it does
SDNCommunicationModule is a part of an academic project which let exchanges information between RYU and Floodlight controllers.
This part collect data from Floodlight controller and share it in the form of REST API using Java EE.
## What do you need
* Adjust Eclipse to work with JAVA EE 

```
Eclipse menu Help -> Install new software -> "Oxygen - http://download.eclipse.org/releases/oxygen" (or your eclipse version)
Then choose : Web, XML, Java EE and OSGi ... Then select: Eclipse Java EE Developer Tools
continue the update and I think that's it" 
```

* Install apache tomcat v9

Do it according to this tutorial - [URL](https://www.digitalocean.com/community/tutorials/how-to-install-apache-tomcat-8-on-ubuntu-16-04). 
In the tutorial, I find an incorrect link to download Tomcat. Correct mirror is - [mirror](apache.mirrors.ionfish.org/tomcat/tomcat-9/v9.0.5/bin/apache-tomcat-9.0.5.tar.gz)
* Change in eclipse Apache Tomcat HTTP port to e.g. 8090 

Do it according this tutorial - [URL](http://www.codejava.net/servers/tomcat/how-to-change-port-numbers-for-tomcat-in-eclipse)

* Download json library to eclipse

Download the ZIP file from this [URL](http://www.java2s.com/Code/JarDownload/java/java-json.jar.zip) and extract it to get the Jar. Add the Jar to your build path.

To Add this Jar to your build path:
```
Right click the Project > Build Path > Configure build path> Select Libraries tab > Click Add External Libraries > Select the Jar file Download"
```
Apart of buildpath you have to add this in:
```
Project properties > deployment assembly > add > java Build Path entries > json.jar > apply and close
```
