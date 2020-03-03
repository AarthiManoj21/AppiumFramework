Feature: Login Feature

@Login
Scenario: Login to Ultimatix
Given User launches the Browser with Ultimatix URL
When User enters the User Credentials
Then User validates the launch of Home Page with correct User
Then User logout the Application