# Test Framework Design

## Framework Type

Page Object Model (POM)

---

## Features

* Config-driven execution using `config.properties`
* Data-driven testing using TestNG DataProvider
* Reusable Page methods (POM design)
* Explicit & Fluent Wait for dynamic elements
* Screenshot capture on failure
* ExtentReports for HTML reporting
* TestNG Listener for reporting & screenshots

---
## Project Structure
```
ShopPractice
│
├── src/main/java
│   ├── com.srm.base
│   │   ├── BasePage.java
│   │   └── BaseTest.java
│   │
│   ├── com.srm.pages
│   │   ├── LoginPage.java
│   │   ├── RegisterPage.java
│   │   ├── DashboardPage.java
│   │   ├── CartPage.java
│   │   ├── CheckoutPage.java
│   │   └── OrdersPage.java
│   │
│   ├── com.srm.utils
│   │   ├── ConfigReader.java
│   │   ├── ExtentManager.java
│   │   ├── ListenerClass.java
│   │   ├── RetryAnalyzer.java
│   │   └── ScreenshotUtil.java
│
├── src/main/resources
│   └── config.properties
│
├── src/test/java
│   └── com.srm.tests
│       ├── LoginTest.java
│       ├── LogoutTest.java
│       ├── RegisterTest.java
│       ├── ProductTest.java
│       ├── CartTest.java
│       ├── CheckoutTest.java
│       └── OrderTest.java
│
├── reports
│   
│
├── screenshots
│   
│
├── testng.xml
├── pom.xml

```

---
## Test Coverage

* Login (valid, invalid, empty)
* Logout
* Product Listing & Validation
* Add to Cart & Cart Count Update
* Delete Product from Cart
* Checkout & Order Placement
* Order History Verification (View Order)
* Form Validations (login & registration)

---

## Tools & Technologies

* Java
* Selenium WebDriver
* TestNG
* Maven
* ExtentReports
