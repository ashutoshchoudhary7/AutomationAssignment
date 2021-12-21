# RideCellAssignment
#Automation Assignment

#We have used below technical stack in this project: 
#Java(1.8)
#Selenium 
#RestAssured 
#TestNG
#Extent reports

#We have kept our test case under src folder "src/test/java" inside package "com.ridecell.automationassignment.tests"

#Objective of test case:
#Navigate to "https://github.com/orgs/django" 
#Click on Repositories tab Capture all the repository name
#Access github repository using API GET call and capture all the repository name
#Verify both the captured repository list from web and API

#Framework Description:

#We have followed POM design pattern for automating the test case workflow
#We can trigger the automation directly using testng.xml
#Once we trigger our testng.xml file the testng hooks present in BaseTest gets executed first
#The before hooks of testng opens the browser and launches the URL next the automation workflow which we mentioned in above test case executes
#Then test case executes as per test objective
#Once execution completes the report gets generated in extent-reports folder







