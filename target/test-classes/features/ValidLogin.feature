Feature: Valid User Login to Application 
 
Background: 
   Given User is on HRMLogin page "URL"
  
   @ValidCredentials
   Scenario: Login with valid credentials
      
    When User enters username as "userName" and password as "passWord"
    Then User login sucessfully and new page open