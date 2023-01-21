
## Test Vagrant Assignment Test

#Overview

>>Write a working program code that will take the test_results.json file as an input and provide:
- The team "RCB (Royal challengers Bangalore)" has submitted its team for upcoming match. The details of the team are as described in the json at the end of this document.

>> Proper treatment for common error conditions:
- Write a test that validates that the team has only 4 foreign players.
- Write a test that validates that there is at least one wicket keeper.

#Solution: 


[ To Get this project running on an Windows machine, install the following: ]

	- Java jdk 8
	- Maven
	- Json Jar File
	- Eclipse IDE 
	- TestNG
	

[ After installation: ]

	- Go to this repository location -(https://github.com/sathyarajr1991/TestVagrantTestAssignment.git) 
	- Tap on Code, Download ZIP file 
	- launch Eclipse IDE
	- select 'File -> Import... -> Maven(Existing Maven Projects)'
	- select the 'pom.xml' file of this project.'
	- add TestNG to the build path by right click on @Test tag if Maven build is not added testNG jat file


[ Project layout: ]

	- main() method is in class PrintTestResults.java:
	- PrintTestResults.java has methods to print output to console
	- JsonReader.java parses the test_suite.json file
	- test_suite.json file is under /src/main/resources folder
	- the console output is available to view in 'sampleConsoleLog.txt'


[ To execute the test: ]

	- From Eclipse
	    - Under 'Project Explorer', expand TestVagrantAssignments -> 'com.testvagrantassignment.test' package
	    - Right click on the class RCBTeamResults.java and Run as TestNG Test
	    - Right click on testng.xml under Project
	    

