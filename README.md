
# Selenium Parabank Automation

This project is an automated test suite for the [Parabank](https://parabank.parasoft.com) demo banking application. It leverages Selenium WebDriver for UI automation, TestNG for test management, RestAssured for API testing, and Allure for reporting.

## Features

- Automated registration, login, and account management tests
- Bill payment and loan request scenarios
- API integration for account and balance management
- Data generation using JavaFaker
- Allure reporting for test results

## Project Structure

```
SELELIUM_PARABANK
│── .allure/                 # Allure configuration files for reporting  
│── allure-results/           # Generated test execution results for Allure  
│── src/                      # Main source folder  
│   ├── main/java/testcase/   # Page classes and test base files  
│   │   ├── baseAPI.java          # Base setup for API tests  
│   │   ├── baseE2Epage.java      # Base setup for End-to-End UI tests  
│   │   ├── basepage.java         # Common reusable page base class  
│   │   ├── loanbasepage.java     # Loan module page objects  
│   │   ├── paybillbasepage.java  # Pay Bill module page objects  
│   │
│   ├── pom/                  # Page Object Model (POM) classes  
│   │   ├── accountServices.java  # Account services page object  
│   │   ├── apiPOM.java            # API layer page object  
│   │   ├── homepage.java          # Homepage page object  
│   │
│   ├── utils/                # Utility classes  
│   │   ├── config.java           # Configuration and setup utilities  
│
│   ├── test/java/testcase/   # Test classes for different modules  
│   │   ├── accounts/             # Account-related test cases  
│   │   │   ├── accountRegistration.java  
│   │   │   ├── accountRegistrationTest.java  
│   │   │
│   │   ├── services/             # Services-related test cases  
│   │   │   ├── loan.java  
│   │   │   ├── loanTest.java  
│   │   │   ├── loginTest.java  
│   │   │   ├── openAccTest.java  
│   │   │   ├── payBillTest.java  
│
│── notes.txt                # Additional notes/documentation  
│── pom.xml                  # Maven dependencies and project build config  
│── testng.xml               # TestNG suite configuration  
│── README.md                # Project documentation  
```

## Prerequisites

- Java 21+
- Maven (`mvn`)
- Chrome browser

## Setup

1. Clone the repository.
2. Install dependencies:
   ```sh
   mvn clean install
   ```

## Running Tests

To run all tests:
```sh
mvn test
```

To run a specific test class (example: registration tests):
```sh
mvn -Dtest="testcase.accounts.accountRegistrationTest" test
```

To run with a specific TestNG suite:
```sh
mvn test -DsuiteXmlFile=testng.xml
```

## Generating Allure Report

After running tests:
```sh
allure serve allure-results
```

## Notes

- Test data is generated dynamically using JavaFaker.
- WebDriver is managed via WebDriverManager.
- API endpoints are tested using RestAssured.
- See [src/notes.txt](src/notes.txt) for quick command references.