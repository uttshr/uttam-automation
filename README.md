In this repo I have added all automation code that I have learned and practiced. In addition I have also added projects that I have worked on

**Cucumber.Java.SeleniumWebdriver | IDE Used: Intelli J |** 
It contains all the automation code written with Cucumber, Java and Selenium WebDriver

**Java.SeleniumWebdriver.Maven.JUnit | IDE Used: Eclipse |** 
It contains code written on Java, Selenium WebDriver, JUnit and Maven

**Katalon | IDE Used: Eclipse |** 
It contains code written on Katalon

-----

Maven Installation in Eclipse Now you will have to install maven. To do that, open Eclipse and select Help > Install New Software Then click Add and a popup box opens up. Give any name like Maven and given location of the Maven installation in the Location field. In this case it’s https://download.eclipse.org/technology/m2e/releases/latest/ Then Expand Maven Integration for Eclipse and check Maven Integration...below it. And click Next. Finally it will be installed.

Now to check if it is installed or not or to know if you have earlier installed Maven then, open Eclipse. Click Help > Install new software. And click already installed? Link and then you will all the installed software. Make sure m2e - Maven integration is there.

Maven is a build tool (build manager, in fact), similar to ANT. The main job of any build tool is configure the project, compile using required projects and do the final packaging. A build script in your project gives a blue-print of project's deliverable structure

If the Maven is not installed while installing eclipse then we will have to manually install it from https://download.eclipse.org/technology/m2e/releases/latest/ As we already have maven we can skip this but if you dont have maven then open eclipse. Click Help > Install new software > Add and then give name Maven and paste that URL

How to setup in Eclipse

Create maven project
Add following dependency in pom.xml
https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java
https://mvnrepository.com/artifact/junit/junit
Include required library class and execute as JUnit
