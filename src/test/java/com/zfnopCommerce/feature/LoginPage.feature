Feature: Verify login functionality on commerce app
Description: Verify the login in the commerce application
Scenario Outline: User should be able to login on app with correct credentials
Given Open browser "<browsername>"
When user enters the URL
And enter username "<username>" and password "<password>"
And click on login button
And verify title of the page
Then home page should be shown and closed application
Examples:

|browsername|username|password|
|chrome|admin@yourstore.com|admin|
|firefox|admin@yourstore.com|admin|