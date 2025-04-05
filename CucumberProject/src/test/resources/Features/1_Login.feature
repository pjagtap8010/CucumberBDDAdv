
Feature: login

Scenario: test login functionality

Given user has valid data
When user enter the url "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
And user enter the email_id "Admin" and password "admin123"
And user clicks on login button 
Then verify that user is able enter in dashboard page 
