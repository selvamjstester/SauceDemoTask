# SauceDemo
Task For PariPlay

# Summary of Work Done - Interview Task

This repository showcases the work completed for the interview task. It includes the following components and features:

## BaseClass

- Implemented a BaseClass to initialize the WebDriver, set up the browser configuration, and manage driver instances.
- Methods for taking screenshots before and after each scenario.
- Browser teardown and driver cleanup after test execution.

## Page Object Model (POM)

- POM classes created for each page of the application, following the POM design pattern.
- Encapsulated web elements and corresponding actions within respective POM classes.
- Methods to interact with elements and perform actions on pages.

## Page Object Manager (POM)

- POM Manager to handle initialization and management of POM instances.
- Ensures each POM class is instantiated once and accessed through the POM Manager.

## Feature File

- Feature file includes three scenarios covering different application functionalities.
- Utilized Cucumber's DataTable feature within one scenario to handle tabular data input.

## Step Definitions

- Step definitions developed corresponding to scenarios defined in the feature file.
- Interaction with POM classes, calling appropriate methods for each step.

## Helper Package

- Helper package to store utility classes and resources.
- Property file to store browser and URL configurations, allowing easy modification.
- Configuration Reader to read and retrieve values from the property file.
- FileReader Manager to manage the configuration reader and other file-related operations.

## Cucumber Runner Class

- Configured Cucumber runner class using `@CucumberOptions` annotation.
- Specified glue path, features directory, and plugin for generating different reports.
- Integrated Cucumber Extent Report, HTML report, JSON report, and PDF report plugins for comprehensive reporting.

## Dependencies used
- cucumber-junit
- junit
- webdrivermanager
- cucumber-java
- selenium-java
- cucumber-core
- extentreports-cucumber7-adapter

## Reports and Screenshots:
- Successfully executed test scenarios and obtained desired reports, including Cucumber Extent Report.
- Detailed information about test execution, test steps, and outcomes.
- Screenshots captured before and after each scenario for easy identification of failures or errors.

Feel free to explore the repository and the provided code to get a better understanding of the implementation.

If you have any questions or need further information, please don't hesitate to reach out.

Thank you for your attention and consideration.


