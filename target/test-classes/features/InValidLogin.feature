Feature: InValid User Login to Application 
 
Background: 
   Given User is on HRMLogin page "URL"
  
   @InValidCredentials
   Scenario: Login with invalid credentials
      
    When User enters username as "username_invalid" and password as "password_invalid"
    Then User able to see error message "Invalid credentials"
  