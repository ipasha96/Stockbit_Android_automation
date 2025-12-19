Feature: feature to open Demo App
Scenario: Check User login has been locked out

Given User on home page
When User click demo app icon
And User click view menu
And User click Log In menu
And User input blocked username
And User input password
And User click Login button
Then User login is locked