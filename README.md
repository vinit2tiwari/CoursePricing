# CoursePricing
This repo is used to calculate price for a course management system.

Assumptions/ Know limitations:
1. All the prices stored in database is in INR.
2. Currently only 2 locations are supported US,INDIA.
3. If no location is provided INDIA will be default.
4. For currency conversions only currencies available at https://api.exchangeratesapi.io are supported.


Steps to run the app :
1. In application.properties update <DATABASE_NAME>,<USER_NAME>,<PASSWORD>.
2. mvn clean install
3. mvn spring-boot:run
4. Once server has started successfully onboard data using sql file present at /src/main/resources/static/sourceData.sql.

Deployment:
1. Once the app is up and running swagger endpoint can be accessed at http://localhost:8080/swagger-ui.html

