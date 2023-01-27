Feature: Edit info for valid User 
 
Background: 
   Given User is on HRMLogin page "URL"
  
   @EditInfo
   Scenario: Login with valid credentials
      
    When User enters username as "userName" and password as "passWord"
    Then User login sucessfully and new page open
    Then User will click on "personalInfoLink"
    Then User will edit value for "LicenseNumber" with "1313432"
    Then User will save data for person