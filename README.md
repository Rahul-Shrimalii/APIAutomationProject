# Rest Assured API Automation Framework – Login & Signup

This project is a REST API automation framework designed to test **Login** and **Sign Up** functionality using **Java**, **Rest Assured**, **TestNG**, and **Extent Reports**. It is modular, extensible, and built with real-world authentication use cases in mind.

---

## ✅ Technologies Used

- Java 17+
- Rest Assured
- TestNG
- Maven
- Jackson (for JSON binding)
- Extent Reports (for advanced HTML reporting)

---

## 📁 Project Structure

<pre> ```com.api
├── base/
│ ├── BaseService.java # Base class for shared Rest Assured configurations
│ └── AuthService.java # Handles Login and SignUp API logic
│
├── models/
│ ├── request/
│ │ ├── LoginRequest.java # POJO for Login API request
│ │ └── SignUpRequest.java # POJO for Sign Up API request (Builder Pattern)
│ └── response/
│ └── LoginResponse.java # POJO for Login API response
│
├── test/
│ ├── LoginAPITest.java # TestNG test class for Login API
│ └── SignUpAPITest.java # TestNG test class for Sign Up API
│
└── utility/
└── ExtentReportManager.java # Singleton utility to manage ExtentReports``` </pre>


---

## 🚀 Features

- POJO-based request & response handling
- Builder pattern for building `SignUpRequest` objects
- Separate test cases for:
    - Valid login
    - Valid sign-up
    - Duplicate user sign-up
- HTML Reporting via Extent Reports

---

## 🔍 API Test Scenarios

### ✅ Login API
- Send a login request using valid credentials
- Deserialize the response into a `LoginResponse` POJO
- Validate token, email, and user ID
- Log detailed info in Extent Reports

### ✅ Sign Up API
- **New User SignUp:** Validate 200/201 status for unique users
- **Duplicate SignUp:** Validate error (409/400) for existing users

---
### Payloads
🔐 LoginRequest
<pre> <code> { "username": "Rahul Shrimali", "password": "Rahul$1234" } </code> </pre>
📝 SignUpRequest
<pre> <code> { "username": "Rahul_New", "password": "Test@123", "email": "rahul.new@example.com", "firstName": "Rahul", "lastName": "Shrimali", "mobileNumber": "9876543210" } </code> </pre>
## 📊 Test Reports

After test execution, an HTML report is generated using **Extent Reports**.

**Path:** `test-output/ExtentReport.html`

The report includes:
- Step-by-step test execution logs
- API request & response details
- Pass/Fail status
- Assertions and error messages

## 🚀 How to Run the Tests

### Prerequisites
- Java 17 or higher
- Maven
- IDE (IntelliJ / Eclipse) or terminal

### Steps
1. Open the project in your IDE or terminal.

2. Run tests using Maven:
   ```bash
   mvn test

3. View the test report
Open the file test-output/ExtentReport.html in your browser.


---


## 👨‍💻 Author

**Rahul Shrimali**  
rshrimali268@gmail.com

