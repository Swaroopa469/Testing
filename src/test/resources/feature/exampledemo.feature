Feature: check the login adactin functionality

@tag
Scenario Outline: Login Adactin
Given User is in adactin page
When User enter "<UserName>" and "<Password>" and click login button
Then Message displayed Login Successfully
Examples:
|UserName|Password|
|ooga2456|4578@#|
|Nilathiru|Selenium@123|