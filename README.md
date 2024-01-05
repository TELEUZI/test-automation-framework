
# **GitHub Test Automation Framework**

This repository houses a specialized test automation framework crafted for the rigorous testing of GitHub. Leveraging the power of Selenium WebDriver, JUnit, and Allure, this framework provides a robust and scalable solution tailored to ensure the reliability and functionality of GitHub-related features.

**Key Features:**

- **GitHub Interaction:** Seamlessly integrates Selenium WebDriver to automate interactions with GitHub's web interface, allowing for comprehensive testing of GitHub-specific functionalities.

- **JUnit 5:** Harnesses the capabilities of JUnit 5 for organizing and executing test cases, ensuring a standardized and efficient testing process.

- **Allure Reporting:** Incorporates Allure to generate visually appealing and insightful reports, facilitating in-depth analysis of test results with a focus on GitHub-related scenarios.

- **Webdriver Manager:** Streamlines the management of web drivers for browsers, simplifying configuration and ensuring compatibility with GitHub's web platform.

- **AspectJ for Logging:** Enhances logging capabilities through AspectJ, providing detailed insights into the execution of GitHub test scenarios.

**GitHub Dependencies:**

- Selenium WebDriver (Version 3.141.59)
- JUnit Jupiter (Version 5.7.0)
- Allure JUnit 5 (Version 2.13.7)
- WebDriverManager (Version 5.3.0)

**Build and Execution:**

The project utilizes Maven, featuring plugins for Surefire, Allure, and the Maven Compiler. Refer to the comprehensive configuration settings in the Maven POM file (pom.xml).

**Usage:**

1. Clone the repository.
2. Update test credentials in the `config.properties` file.
3. Execute tests using Maven commands, e.g., `mvn clean test`.
4. Generate Allure reports with `mvn allure:report`.
