Feature: feature to open Demo App
Scenario: Check Demo App open and successfully

Given User on home page
When User click demo app icon
And User click view menu
And User click Log In menu
And User input username
And User input password
And User click Login button
Then User will login successfully