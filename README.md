# Spell Checker Readme
This is a spell checking application that uses the JLanguageTool library to detect and correct spelling errors in text. The application is built with a Spring Boot back-end and a React front-end.

## Prerequisites
- Java 8 or later
- Node.js
- npm
- Maven

## Getting Started
To get started, clone the repository to your local machine using the following command:
```
git clone https://github.com/Bepso/SpellChecker.git
```

## Back-end
Navigate to the backend directory and build the project using Maven by running the following command:

```
mvn clean install
```
Start the back-end server by running the following command:
```
mvn spring-boot:run
```
## Front-end
Navigate to the frontend directory and install the dependencies using npm by running the following command:
```
npm install
```
Start the front-end development server by running the following command:
```
npm run start
```

This will start the front-end server on port 3000. You can access the application by navigating to http://localhost:3000 in your web browser.

## Usage
Enter a piece of text in the input field, and the application will detect any spelling errors. Click on the highlighted suggestions to correct any mistake.

## Tests

### Backend Tests:

Navigate to the backend folder of your project.
Run the following command in the terminal:
```
mvn test
```
This command will run all the tests for your backend code.

### Frontend Tests:

Navigate to the frontend folder of your project.
Run the following command in the terminal:
```
npm run test
```
This command will run all the tests for your frontend code.

Note: Make sure you have all the necessary dependencies installed for both the backend and frontend before running the tests.

## Acknowledgments
- JLanguageTool (https://languagetool.org/)
- Axios (https://github.com/axios/axios)
- Spring Boot (https://spring.io/projects/spring-boot)
- React (https://reactjs.org/)

