# gitHubOpenIssuesTracker
A Spring MVC application to display the open issues for the entered public repo

Technologies used :

* Spring 3.2.13.RELEASE
* JDK 1.8
* Boostrap 3
* Maven 3 
* Github api's for issue related queries
* Heroku for deploying the application

Approach:

Spring MVC framework with maven is used.
  
  1) The input URL is obtained and validated for the expected 
  
  2) An API call is made to check whether the repo is accessible 
  
  3) On Success another API call is made to get the issues 
  
  4) This list of issues is sorted into time slots using lambda expression and displayed to user
  
  https://young-basin-39065.herokuapp.com/   ---  Link for the live application 
  
  Improvements that can be made with more time :
  
  1) UI Polishing 
  
  2) Database usage so as to reduce the no of calls made and decrease the probability of rate limit error,like a user login feature where the valid urls entered by user are stored avoiding multiple URL validation calls

