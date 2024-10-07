**Maven Installation in Eclipse**
Now you will have to install maven. To do that, open Eclipse and select Help > Install New Software
Then click Add and a popup box opens up. Give any name like Maven and given location of the Maven installation in the Location field. In this case it’s https://download.eclipse.org/technology/m2e/releases/latest/ 
Then Expand Maven Integration for Eclipse and check Maven Integration...below it. And click Next. Finally it will be installed.

Now to check if it is installed or not or to know if you have earlier installed Maven then, open Eclipse. Click Help > Install new software. And click already installed? Link and then you will all the installed software. Make sure m2e - Maven integration is there.

Maven is a build tool (build manager, in fact), similar to ANT. The main job of any build tool is configure the project, compile using required projects and do the final packaging. A build script in your project gives a blue-print of project's deliverable structure

If the Maven is not installed while installing eclipse then we will have to manually install it from https://download.eclipse.org/technology/m2e/releases/latest/ 
As we already have maven we can skip this but if you dont have maven then open eclipse. Click Help > Install new software > Add and then give name Maven and paste that URL



**How to setup in Eclipse**

1. Create maven project
2. Add following dependency in pom.xml<br>
_https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java<br>
https://mvnrepository.com/artifact/junit/junit_
4. Include required library class and execute as JUnit 
