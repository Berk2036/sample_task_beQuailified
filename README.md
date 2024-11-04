# sample_task_beQualified
## Overview

This project is a test automation framework designed to validate the functionality of the [SauceDemo](https://www.saucedemo.com/) website. It primarily focuses on testing the shopping functionality using Selenium WebDriver, Java, JUnit, and Cucumber.

## Features Tested

- **Shop Page Functionality**:
    - Verification of product details (title, description, price, and image) consistency before and after a page refresh.
    - Ensuring correct product information is displayed on the product detail page.
    - Adding products to the cart and verifying cart contents.
    - Ensuring product details remain consistent in the cart.

## Tools and Technologies

- **Java**: Programming language used for writing test scripts.
- **Selenium WebDriver**: For browser automation and interacting with web elements.
- **JUnit**: Framework for writing and running unit tests.
- **Cucumber**: For behavior-driven development (BDD), allowing tests to be written in Gherkin syntax.
- **Maven**: Build and dependency management tool.

## Project Structure

    src/
    ├── main/
    │   └── java/
    │       └── 
    └── test/
        └── java/
        │   └── beQualified/
        │       ├── pages/       # Page Object Models
        │       ├── runners      # Cukesrunner
        │       ├── steps/       # Step Definitions for Cucumber
        │       └── utilities/   # Utility classes
        └── resources/
                └── features/    # Cucumber Feature Files


### Key Components

- **Page Object Models (POM)**: Encapsulates web elements and interactions for each page, enhancing code readability and maintainability.
- **Step Definitions**: Maps Gherkin steps in the feature files to Java methods.
- **Utility Classes**: Provides reusable methods for common actions like waiting for elements, capturing texts, and handling browser interactions.

## Prerequisites

- Java Development Kit (JDK) 17+
- Maven 3+
- Chrome Browser
- ChromeDriver compatible with the installed Chrome version

## How to Run the Tests

1. Clone the repository.
2. Navigate to the project directory.
3. Ensure all dependencies are installed by running:
     ```bash
   mvn clean install
4. To execute the tests, run:
 
    ```bash
    mvn test

## Writing Tests
### Adding New Features

1. Create a new feature file in src/test/resources/features/.
2. Define the scenarios in Gherkin syntax.
3. Implement the corresponding step definitions in src/test/java/beQualified/steps/.

### Reporting

Cucumber generates test reports in target/cucumber-reports. You can also integrate with reporting tools like Allure for enhanced test reports.

###  Future Enhancements

- Integration with a CI/CD pipeline for automated test execution.
- Adding more test scenarios for edge cases and additional functionalities.
- Cross-browser testing support.