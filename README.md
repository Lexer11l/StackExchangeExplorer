# StackExchangeExplorer

<b>Desription</b> <br>
Java web application with a form that allows a user to enter a search string, queries Stack Exchange to find questions with titles containing that string, and display the results.

<b>Requirements</b> <br>
Display the results in a tabular format showing at least the date of the question, its title and who posted it.
If the question has been answered, use a visual style to differentiate it from unanswered questions.
The displayed item should have a means to navigate to the original question on Stack Exchange.

<b>Stackoverflow API</b> <br>
http://api.stackexchange.com/docs/search#order=desc&sort=activity&intitle=java&filter=default&site=stackoverflow&run=true

<b>Used technologies:</b>
* Java 1.8
* Spring 4
* Maven
* log4j
* JUnit 4
* PowerMockito
* Tomcat 9 (The app was tested with it)

<b>What was implemented</b> <br>
Web application contains of 2 web forms - <b>searchPage</b> with 7 input fields for request parameters:
* Intitle (Text for search)
* Page
* Page Size
* Sorting field
* Sorting order
* Date from which we should find
* Date to which we should find


And <b>queryResults</b> with table that displays search results with following columns:
* Topic title (with link to it)
* Topic author (with link to him)
* Topic creation date
* Topic tags
* Marking as gray color if topic was not been answered yet

In addition there were added logging in file and console and implemented unit tests for main functional

<b>Potential improvements</b><br>
Due to lack of time some features were not implemented or were implemented not in perfect way. For example:
* First of all, forms have very simple design. We can make it more beatuiful, colorful using CSS and more interactive using JavaScript.
* Coverage of unit test is still small. We can improve it with writing additional tests.
* We can separate service that interacts with StackExcange via API into microservice that uses SOAP. Thus we'll be able to change code there independently and get access there from different services event from smartphone apps.
* Now we have restriction with 100 topic max per request. But if user wants we can implement getting more topics per one user query by making several request to remote API.
* Also we can add pagination to improve navigation experience at query results page.

<b>How to install</b>
* Clone code from git
* Build using Maven: mvn clean package
* Deploy on preferable Application Server
