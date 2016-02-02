Feature: Login Feature File
@selenium
Scenario: Login scenario test for Gmail

Given navigate to gmail page
When user logged in using username as “utest1andrei” and password as “Madagascar1”
Then home page should be displayed