# 🧪 Selenium Automation Framework — Let's Shop E-Commerce

![CI](https://github.com/laurawebsa/selenium_framework_design/actions/workflows/ci.yml/badge.svg)
![Java](https://img.shields.io/badge/Java-21-orange?logo=openjdk)
![Selenium](https://img.shields.io/badge/Selenium-4.41-green?logo=selenium)
![TestNG](https://img.shields.io/badge/TestNG-7.12-red)
![Cucumber](https://img.shields.io/badge/Cucumber-BDD-brightgreen?logo=cucumber)
![Maven](https://img.shields.io/badge/Maven-Build-blue?logo=apachemaven)

A production-ready UI test automation framework for the **[Let's Shop](https://rahulshettyacademy.com/client)** e-commerce web application. Built with **Java**, **Selenium 4**, **TestNG**, and **Cucumber (BDD)**, following industry best practices including the **Page Object Model (POM)**, data-driven testing, and full CI/CD integration via **GitHub Actions**.

---

## 🛒 Application Under Test

**Let's Shop** — [rahulshettyacademy.com/client](https://rahulshettyacademy.com/client)

A full-featured e-commerce web app covering:

| Module | Tested Flows |
|---|---|
| Authentication | Login, logout, invalid credentials, error messages |
| Product Catalog | Product listing, search, filtering |
| Shopping Cart | Add to cart, update quantities, remove items |
| Checkout | End-to-end purchase flow, order confirmation |
| Error Validation | Boundary cases, empty fields, invalid inputs |

---

## 🏗️ Framework Architecture

```
selenium_framework_design/
│
├── src/
│   ├── main/java/org/example/
│   │   ├── pages/           # Page Object Model — one class per page
│   │   ├── components/      # Reusable UI components
│   │   └── utils/           # Driver factory, config reader, helpers
│   │
│   └── test/java/org/example/
│       ├── tests/           # TestNG test classes
│       ├── stepDefinitions/ # Cucumber step definitions
│       └── runners/         # TestNG Cucumber runners
│
├── testSuites/              # TestNG XML suite files
│   ├── testng.xml           # Full regression suite
│   ├── Purchase.xml         # Purchase flow suite
│   ├── ErrorValidationTests.xml
│   └── (CucumberTests runner)
│
├── features/                # Cucumber .feature files (Gherkin)
├── reports/                 # ExtentReports HTML output
├── src/test/resources/      # Test data (JSON), config files
│
└── .github/
    └── workflows/
        └── ci.yml           # GitHub Actions CI/CD pipeline
```

---

## ⚙️ Tech Stack

| Layer | Technology |
|---|---|
| Language | Java 21 |
| Browser Automation | Selenium WebDriver 4.41 |
| Test Framework | TestNG 7.12 |
| BDD | Cucumber 7.34 (Gherkin) |
| Build Tool | Maven |
| Design Pattern | Page Object Model (POM) |
| Driver Management | WebDriverManager 6.3 |
| Test Data | Jackson (JSON) |
| Reporting | ExtentReports 5 |
| CI/CD | GitHub Actions |

---

## ✅ Test Suites

| Maven Profile | Description |
|---|---|
| `Regression` | Full regression suite — all test cases |
| `Purchase` | End-to-end purchase flow: login → add to cart → checkout → confirm |
| `ErrorValidation` | Negative testing — invalid inputs, error message validation |
| `CucumberTests` | BDD scenarios written in Gherkin for business-readable coverage |

---

## 🚀 How to Run

### Prerequisites
- Java 21+
- Maven 3.8+
- Google Chrome (latest)

### Clone the repository
```bash
git clone https://github.com/laurawebsa/selenium_framework_design.git
cd selenium_framework_design
```

### Run a specific suite
```bash
# Full regression
mvn test -PRegression

# Purchase flow
mvn test -PPurchase

# Error validation
mvn test -PErrorValidation

# BDD / Cucumber tests
mvn test -PCucumberTests
```

### Run headless (no browser window)
```bash
mvn test -PRegression -Dheadless=true
```

---

## 📊 Test Reports

After execution, an **ExtentReports** HTML report is generated in `/reports`.

```
reports/ExtentReport.html
```

Reports include: test status per case, execution time, screenshots on failure, and environment info.

---

## 🔄 CI/CD Pipeline

Tests run automatically on every push and pull request to `master` via **GitHub Actions**.

Pipeline steps:
1. Set up Java 21
2. Install Chrome in headless mode
3. Run the Regression suite via Maven
4. Upload ExtentReports HTML as a downloadable artifact
5. Publish TestNG results summary in the GitHub Actions UI

---

## 📐 Design Patterns & Best Practices

- **Page Object Model (POM)** — UI interactions encapsulated in page classes, keeping tests clean and maintainable
- **BDD with Cucumber** — business-readable scenarios in Gherkin, bridging technical and non-technical stakeholders
- **Data-driven testing** — test data managed via JSON files using Jackson, decoupled from test logic
- **WebDriverManager** — automatic browser driver management, no manual setup required
- **Multi-suite architecture** — separate XML suites for different test scopes and execution strategies

---

## 👩‍💻 Author

**Laura** — QA Automation Engineer | SDET  
[GitHub](https://github.com/laurawebsa)
