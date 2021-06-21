Coverage: 98.4%
# HWA: Hobby Web Application - Car Mod Tracker by Asshwin Mugundharajah

This project focuses on a web application that is coded in Java using Spring Boot. The Car Mod Tracker application is designed to store the cars you own or have owned . It also tracks the mods that you have installed on each of your cars. You can add, remove and update the mods for each car. It will also add up the total cost of all mods you have spent for each car and make it viewable.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Installing for Windows machine

A step by step series of examples that tell you how to get a development environment  running.

#### Prerequisites

To get started, please install:

- JDK (Java Development Kit) 16
  - JDK 11 is optional for SonarQube to work
- Apache Maven 3.8.1
- MySQL Server & Workbench 5.7+
- Eclipse or another Java IDE of your choice
- Optional:
  - Microsoft Visual Studio Community - Easy coding of HTML, JavaScript and CSS.

#### Java Installation

First, install [Java](https://www.oracle.com/java/technologies/javase-jdk16-downloads.html) using the installer. The same steps will apply for Java 11.

After installing it from the install you should add it to your systems path.

To do this click on the start button and search for “Edit the system environment variables” and click on it. 

Click on “Environment Variables…” option on the bottom right. This will open the Environment variables window and under that there will be an option to create a new system variable. Make sure you click New under systems variable and not under user variables.

Create a new variable which points to the java folder:

![Imgur](https://i.imgur.com/okZwzk0.png)

After that locate the PATH variable and click the edit button. Here you will add the java path by clicking on new and typing in 

```
%JAVA_HOME%\bin
```

Should look like this:

![Imgur](https://i.imgur.com/YVRZIYA.png)

You can check if its been added to your path correctly by opening Command Prompt and typing in:

```
java
```

It should output this to your command window:

![Imgur](https://i.imgur.com/xxYZqXL.png)


#### Maven Installation

To install Maven, download the binary zip archive from [here](https://maven.apache.org/download.cgi).

Extract the contents and place it in your program files folder.

![Imgur](https://i.imgur.com/BoQnhEu.png)

Just like before with the Java installation, we have to add Maven to the path. These are the two system variables you have to create:

![Imgur](https://i.imgur.com/BPk3jAp.png)

![Imgur](https://i.imgur.com/ImYxv0o.png)

Next, edit the PATH variable and add:

```
%MAVEN_HOME%\bin
```

You can test if Maven is installed by opening command prompt and typing in:

```
mvn -version
```

This should output the current version of Maven that is installed.

![Imgur](https://i.imgur.com/faNaypd.png)

#### MySQL Local Installation

1. Download the MySQL Installer from [here](https://dev.mysql.com/downloads/installer/). 

   You can install the server by itself or along with MySQL workbench which allows you to easily create and view the databases without using the command line. These instructions will show how to install both the server and the workbench.

2. Click on the installer and select the custom option.

3. Select the latest versions of MySQL Server and MySQL Workbench

![Imgur](https://i.imgur.com/NoXZG3z.png)

4. Click next and this will start installing both. Create a password for the server and finish the setup. You can simply set it to root.

5. To initialize the server for the first time, open command prompt as administrator and go in to your MySQL Server install folder by using this command:

```
 cd C:\Program Files\MySQL\MySQL Server 8.0\bin
```

6. Then type the following command to initialize the server for the first time:

```
mysqld --console --initialize
```

7. This will create a temporary password for the root user which is on the last line. Remember the password to use later.

![Imgur](https://i.imgur.com/5AQEmxO.png)

8. Next, type in:

```
 mysqld --console
```

This will check if the server will run and be ready for connection. You should notice that you won’t be able to type in the command window any longer. This means its running correctly.

![Imgur](https://i.imgur.com/cVKfP6d.png)

9. Open another command prompt window and cd in to your MySQL Server bin folder like before and enter this command:

```
 mysql -u root -p
```

10. And enter the password that was shown in the command window earlier. This will then start the MySQL server. 

11. Before the server can be used enter this command:

```mysql
 ALTER USER 'root'@'localhost' IDENTIFIED BY 'root';
```

This will reset the root user password to ‘root’

12. You can test the server out by typing in

```mysql
SHOW DATABASES;
```

And should output this:

![Imgur](https://i.imgur.com/jSBNyiM.png)

13. To get the database ready for the production environment, create a database called hwa:

```mysql
CREATE DATABASE hwa;
```

And rerun the show database command and you should see 'hwa' listed.

![Imgur](https://i.imgur.com/FxeHVy0.png)

The MySQL server is now ready to be used with the web application!

#### Importing and running the HWA program.

You can download and use any Java IDE of your choice. In these instructions I will show you how to set it up in Eclipse. It should be similar for other IDEs as well.

1. Download and install the latest version of eclipse. 
2. After its installed, open eclipse in a new workspace. 
3. Clone this repo down on to your device through Git or by downloading it as a zip.
4. Select “Import a project…” in the Package Explorer side bar on the left. This will open the import wizard. 
5. On here, under Maven, select “Existing Maven Projects” and click Next.

![Imgur](https://i.imgur.com/sDv2dOG.png)



6. Set your root directory to be the repo you just cloned down. It should show the pom.xml file and click finish. 

![Imgur](https://i.imgur.com/wDvHtVE.png)

7. The project will take a minute or two to import fully and build in to your workspace. If this is a your first time using the application, first you must edit the **application-prod.properties** file so that it is set to `spring.jpa.hibernate.ddl-auto=create`. This will create the tables in to your 'hwa' database. This file can be found under **src/main/resources**. You can also set the server port if you dont want to use the default port of **8080**.

   ![](https://i.imgur.com/qXdAQYT.png)

   ![](https://i.imgur.com/H2DDTAi.png)

   **Make sure after running the application for the first time to go back in to *application-prod.properties* and set it back to `spring.jpa.hibernate.ddl-auto=validate`. If its not set back to validate , new tables will be created every time you run the application which will destroy the records that are already created. Setting it to validate will keep the database persistent and not destroy records every time the application is run.**

   8. After this has been set, the web application can now be run. This is done by running **HwaCarTrackerApplication.java** which is under **src/main/java** in the **com.qa.hwa** package.

   ![](https://i.imgur.com/nwnPh3r.png)

9. This will run the program in the console below. If your console looks like the one below, it means the application has successfully started.

![Imgur](https://i.imgur.com/kQbkSCC.png)

10. To view the web application, open your browser and enter the URL **localhost:8080** or whatever port number if you have decided to change it. This will now load up the web application.

![Imgur](https://i.imgur.com/opfLWV1.png)

The web application is designed to be easy to use. All the function of the website can be found on the navbar at the top of the screen. Simply click on each nav item and fill out the form. All fields are required to be filled out. Below is how the page will look like with some data in the database.

![](https://i.imgur.com/G0S23yw.png)

11. If you would like to modify the look and behavior of the webpage, the web files can be found under **src/main/resources/static**. In there will be a:

    1. 'img' folder - to store the images used for the webpage.
    2. 'index.html' - the webpage itself.
    3. 'index.js' - the necessary JavaScript to display the entities on the webpage.
    4. 'style.css' - an empty css file which can be used to add custom styling to the webpage.

    These files can be edited in an IDE such as Microsoft Visual Studio or even notepad.

The project is now ready for development and testing!

## Running the tests

The tests have been created so that it will not use the database that is used for production. Instead it uses a H2 database. This is a database that is created in memory, therefore it will not affect the production database. The settings for this database is located in **application-test.properties**. Just like in the production properties, the server port can be changed if you would like to. You can also interact with the H2 database by going to **localhost:8080/h2-console**.

JUnit is used to run the integration and the unit tests. Selenium was used to run the user acceptance tests for the web page. The coverage of the whole **src/main/java** is **98.4%**.

### Unit Tests 

These unit tests are designed to test the methods inside each of the service classes. The methods inside these classes interreact with the repo classes by either creating, reading, updating or deleting records. It is vital that these methods are fully tested since they will be handling the input and output for the database. Below is an example of a service test for the CarService class that tests the create function:

```java
@Test
void testCreate() {
	//GIVEN
	Car testCar = new Car("BMW", "320cd", 2005, "Silver", "Manual", "Diesel", 210, 120000L);
	Car testSavedCar = new Car(1, "BMW", "320cd", 2005, "Silver", "Manual", "Diesel", 210, 120000L, null);
		
	//WHEN
	Mockito.when(this.repo.save(testCar)).thenReturn(testSavedCar);
		
	//THEN
	assertThat(this.service.createCar(testCar)).isEqualTo(this.mapper.mapToDTO(testSavedCar));
		
	Mockito.verify(this.repo, Mockito.times(1)).save(testCar);
}
```

### Integration Tests

The integration tests check the whole integration of the classes. Specifically, it tests the controller, service, mapper and repo classes. This test works by sending a object as a JSON to the controller and expects a JSON response back. The JSON response is then checked with a object that is created already which is converted as a JSON. If these match, the test passed. For the integration test, a schema and SQL data file are used to prepopulate the test web environment. 

```java
@Test
void testCreate() throws Exception{
	Car testCar = new Car("BMW", "320cd", 2005, "Silver", "Manual", "Diesel", 210, 120000L);
	String testCarAsJSON = this.mapper.writeValueAsString(testCar);

	Car testSavedCar = new Car(5, "BMW", "320cd", 2005, "Silver", "Manual", "Diesel", 210, 120000L);
	String testSavedCarAsJSON = this.mapper.writeValueAsString(testSavedCar);
		
	this.mvc.perform( post("/cars/create").content(testCarAsJSON).contentType(MediaType.APPLICATION_JSON)).
	andExpect(status().isOk()).andExpect(content().json(testSavedCarAsJSON));
}
```

### User Acceptance Tests

These tests use Selenium to test the frontend of the webpage. It uses a chromedriver which is found under **src/test/resources/drivers/chrome** to start a chrome browser and directs to the webpage. It will then run a series of commands that will find elements on the webpage and interact with them until your expected result equals the result it retrieves from the webpage. For example, the test below will test the ability to add a car to the system. This is done by selecting the navigation drop down element and then clicking on each form field in the drop down and entering the set data. After all the fields have been entered, it waits for the page to reload and then checks to see if it can retrieve a piece of text from the new element that will be created when the form is submitted. If it doesn't find the element or if the text element is incorrect it will fail the test. It will only pass if the exact text is gotten from the element.

```
@Test
public void createCar() throws InterruptedException {
    driver.get(URL);

    driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

    WebElement targ = driver.findElement(By.xpath("//*[@id=\"navbarDropdownAddCar\"]"));
    targ.click();

    targ = driver.findElement(By.xpath("//*[@id=\"addMake\"]"));
    targ.click();
    targ.sendKeys("BMW");

    targ = driver.findElement(By.xpath("//*[@id=\"addModel\"]"));
    targ.click();
    targ.sendKeys("135i");

    targ = driver.findElement(By.xpath("//*[@id=\"addYear\"]"));
    targ.click();
    targ.sendKeys("2010");

    targ = driver.findElement(By.xpath("//*[@id=\"addColour\"]"));
    targ.click();
    targ.sendKeys("Alpine White");

    targ = driver.findElement(By.xpath("//*[@id=\"addTrans\"]"));
    targ = driver.findElement(By.xpath("//*[@id=\"addTrans\"]/option[2]"));
    targ.click();

    targ = driver.findElement(By.xpath("//*[@id=\"addFuel\"]"));
    targ = driver.findElement(By.xpath("//*[@id=\"addFuel\"]/option[1]"));
    targ.click();

    targ = driver.findElement(By.xpath("//*[@id=\"addBhp\"]"));
    targ.click();
    targ.sendKeys("306");

    targ = driver.findElement(By.xpath("//*[@id=\"addBoughtMileage\"]"));
    targ.click();
    targ.sendKeys("108500");

    targ = driver.findElement(By.xpath("//*[@id=\"newCar\"]/div[9]/button"));
    targ.click();

    WebDriverWait wait = new WebDriverWait(driver, 10);
    wait.until(ExpectedConditions.stalenessOf(targ));

    targ = driver.findElement(By.xpath("//*[@id=\"output\"]/div[5]/div/div[1]/h4"));
    String cardTitle = targ.getText();

    assertEquals("2010 BMW 135i", cardTitle);
}
```

To run all the tests simply right click the project in the Project Explorer window in Eclipse and there will be an option to run the coverage as a JUnit test:

![Imgur](https://i.imgur.com/IrgJ1mB.png)

### SonarQube

SonarQube is a static analysis tool which scans your whole project to help you refactor your code, searches for vulnerabilities and detects and code smells. This is a great tool to use to make sure the quality of the code is up to standard. It also makes your whole project code more efficient. SonarQube also displays the coverage of your project and shows any missed lines when testing. The instructions below will show you how to install SonarQube and how to use it for this project:

1. Make sure all the following dependencies are inside the **pom.xml** file.

![](https://i.imgur.com/9doUKSL.png)

![](https://i.imgur.com/24rIZW0.png)

2. Navigate to the [SonarQube](https://docs.sonarqube.org/latest/setup/get-started-2-minutes/) website and select **download** under **From the zip file**. From there select and download the **Community Edition**.

![](https://i.imgur.com/uSd586J.png)

3. Unzip the zip file and copy and paste in your **C:\\** drive for easy access.

![](https://i.imgur.com/W0witwB.png)

4. Open a new command window enter the following instruction to start SonarQube.

![](https://i.imgur.com/lXUqQHc.png)

5. If SonarQube is configured successfully, the command window should look like this and wont allow you to enter any more commands. If your SonarQube did not start, you might have to change the port number in the sonar properties file. The default port is set to 9000.

![](https://i.imgur.com/zSPmiqG.png)

6. Open up your web browser and navigate to **localhost:9000**. A login page will be displayed like the one below. The default username and password is **admin** for both. It will then ask you to change your password to something more secure.

![](https://i.imgur.com/H5RuE6f.png)

7. You will then be taken to the SonarQube dashboard. The dashboard will be empty since there are no projects currently sent to SonarQube.

[](https://i.imgur.com/SZhVJHz.png)

![](https://i.imgur.com/23EEbzQ.png)

8. To send your HWA project to SonarQube for analysis, simply open a command window/git window inside your project folder and enter the following command:

   `mvn sonar:sonar -Dsonar.host.url=http://localhost:9000 -Dsonar.login=admin -Dsonar.password=admin`

   This will build the application and send the results to SonarQube.

   ![](https://i.imgur.com/desygmP.png)

Thats it! SonarQube is now successfully setup!

### Deployment

To deploy this program once its been developed and tested:

1. Make sure all the tests pass otherwise the build will fail.
2. Make sure the application has been run once before to create the tables for the database.  This is done by setting `spring.jpa.hibernate.ddl-auto=create` inside **application-prod.properties**. 
3. Make sure to set back to `spring.jpa.hibernate.ddl-auto=validate` after the first initial run.
4. Navigate inside to your project folder.

5. Either open a command window or git bash window inside to your folder or cd in to your folder.

6. Then run this command: 

```
mvn clean
```

This will clean the target folder and delete it.

![Imgur](https://i.imgur.com/acK9lId.png)

5. Next run this command: 

   ```
   mvn package
   ```

   This will create a jar file in a new target folder which is executable.
   
   ![Imgur](https://i.imgur.com/fcWIOKv.png)

6. To run the jar file, in the command window cd in to the target folder and execute the following command:

   ```
   java -jar HWA-CarTracker-0.0.1-SNAPSHOT.jar
   ```
   
   ![Imgur](https://i.imgur.com/ItXJGBS.png)

   The program is now ready to use!

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Supporting Documentation

All supporting documentation can be found in the "Documentation" folder. This folder includes the following:

1. Jira Folder - Screenshots from Jira
2. SonarQube - Screenshots from SonarQube

3. Risk assessment.pdf

4. ERD Initial.png

5. UML Diagram.png

6. HWA Project.pptx

## Authors

* **Asshwin Mugundharajah** - [ashkl](https://github.com/ashkl)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

* All the QAC Trainers!