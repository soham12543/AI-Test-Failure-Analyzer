# 🤖 AI Test Failure Analyzer

An AI-powered Selenium Automation Framework built using **Java, Selenium WebDriver, TestNG, Extent Reports, and Google Gemini API**. The framework automatically captures test failures, takes screenshots, and uses AI to analyze the root cause, suggest fixes, and generate a detailed failure report.

---

## 🚀 Features

- ✅ Selenium WebDriver Automation
- ✅ Page Object Model (POM)
- ✅ TestNG Framework
- ✅ Extent Reports
- ✅ Automatic Screenshot Capture on Test Failure
- ✅ AI-Powered Test Failure Analysis using Google Gemini
- ✅ Root Cause Detection
- ✅ Suggested Fixes
- ✅ Severity & Priority Prediction
- ✅ Maven Project Structure

---

## 🛠 Tech Stack

- Java 17
- Selenium WebDriver
- TestNG
- Maven
- Extent Reports
- Google Gemini API
- Eclipse IDE
- Git & GitHub

---

## 📂 Project Structure

```
AI-Test-Failure-Analyzer
│
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── ai
│   │   │   ├── pages
│   │   │   ├── reports
│   │   │   ├── utility
│   │   │   └── listeners
│   │   │
│   │   └── resources
│   │       └── config.properties.example
│   │
│   └── test
│       └── java
│           └── tests
│
├── Reports
├── Screenshots
├── pom.xml
├── README.md
└── .gitignore
```

---

# ⚙️ Setup Instructions

## 1. Clone the Repository

```bash
git clone https://github.com/soham12543/AI-Test-Failure-Analyzer.git
```

---

## 2. Import the Project

Import the project as a **Maven Project** in Eclipse or IntelliJ IDEA.

Wait for Maven to download all dependencies.

---

## 3. Get a Google Gemini API Key

Visit:

https://aistudio.google.com/app/apikey

Create your free API key.

---

## 4. Create the Configuration File

Inside

```
src/main/resources
```

create a new file named

```
config.properties
```

Copy the following content:

```properties
gemini.api.key=YOUR_GEMINI_API_KEY
```

Replace

```
YOUR_GEMINI_API_KEY
```

with your own Gemini API key.

> **Note:** The `config.properties` file is intentionally ignored by Git to protect your API key.

---

## 5. Run the Tests

Execute any TestNG test.

On failure the framework automatically:

- Captures Screenshot
- Collects Exception Details
- Captures Current URL
- Captures Page Title
- Sends failure details to Google Gemini
- Generates AI-based Root Cause Analysis
- Creates an Extent Report

---

# 🤖 AI Failure Analysis

When a test fails, Gemini analyzes the failure and provides:

- Root Cause
- Confidence Level
- Bug Title
- Description
- Steps to Reproduce
- Expected Result
- Actual Result
- Suggested Fix
- Issue Type
- Severity
- Priority
- Prevention Tips

Example:

```
ROOT CAUSE
Login verification failed because the application remained on the login page.

CONFIDENCE
96%

BUG TITLE
Products page not displayed after login

SUGGESTED FIX

• Verify login credentials
• Add explicit wait
• Validate successful navigation before assertions
```

---

# 📊 Reports

The framework automatically generates:

- Extent HTML Reports
- Screenshot on Failure
- AI Generated Failure Analysis

---

# 📸 Screenshots

Whenever a test fails, a screenshot is automatically captured and attached to the Extent Report.

---

# 🔒 Security

This repository **does not include any API keys**.

The file

```
config.properties
```

is ignored using `.gitignore`.

Only

```
config.properties.example
```

is committed to GitHub.

Create your own `config.properties` locally before running the framework.

---

# 🎯 Future Enhancements

- GitHub Actions Integration
- Jenkins CI/CD
- Docker Support
- Cross Browser Execution
- Parallel Execution
- AI Screenshot Analysis
- AI Locator Healing
- Slack & Email Notifications

---

# 👨‍💻 Author

**Soham Chakraborty**

QA Automation Engineer

LinkedIn:
https://www.linkedin.com/in/soham-chakraborty-a5207620b/

GitHub:
https://github.com/soham12543

---

## ⭐ If you found this project useful, don't forget to Star the repository!
