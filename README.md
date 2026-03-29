# 🧪Grid_Upload_Download - Automation

Automated UI testing project for https://rahulshettyacademy.com/upload-download-test/index.html practice
using **Selenium WebDriver**, **Java**, and **TestNG**, applying **Page Object Model (POM)** **APACHE POI**
and good automation practices.

This project is part of my QA Automation portfolio.

---

## 🛠️ Tech Stack

- Java 21
- Selenium WebDriver
- TestNG
- Maven
- IntelliJ IDEA
- Git & GitHub
----
## Automated Flow
1. Download Excel file from the application
2. Wait until the download is completed
3. Open and modify the Excel file (update Apple price)
4. Save changes locally
5. Upload the modified file
6. Validate the result in the UI
----
## ▶️ Execution

**Run all tests**:

Use TestNG suite: _testng.xml_

Run only Excel test:
groups = _changePrice_

## 📂 Project Structure

```bash
src
└── main
    └── java
        ├── abstractComponents
        │   └── AbsractComponets.java
        ├── pageObject
        │   └── PageGrid.java
    test
    └── java
           └── testExecution
            └── GridTest.java
```