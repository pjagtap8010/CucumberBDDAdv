Feature: DashBoard 

Scenario Outline: dash-1

Given user enter the url "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
And user enter the email_id "Admin" and password "admin123"
And user clicks on login button 
When user scroll down to the page 
And user click on HoaA person
Then user should reflect to new page 
And user enter the "<name>"
And navigate back to home page 

Examples:
 |name |
 |p    |