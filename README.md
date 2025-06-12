# 🚔 Police Management System (Java + MySQL)

A console-based application built using **Java** and **MySQL** that allows a police station to manage FIRs, civil complaints, and staff records. This project follows the **DAO (Data Access Object)** design pattern for clean and modular database interactions.

---

## 📁 Features

* Register, view, and delete **FIRs**
* Register, view, and update **complaint status**
* Add, view, and remove **staff members**
* Input validation (e.g., CNIC format)
* Uses **MySQL JDBC** for persistent storage
* Modular structure with **DAO pattern**

---

## 🛠️ Technologies Used

* Java (17+)
* MySQL
* JDBC (MySQL Connector/J)
* VS Code or any Java IDE
* Ubuntu/Linux (but works on Windows/Mac with minor changes)

---

## 🗃️ Database Setup

### 1. Create the database:

```sql
CREATE DATABASE IF NOT EXISTS police_station;
USE police_station;
```

### 2. Create tables:

```sql
CREATE TABLE firs (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100),
  cnic VARCHAR(20),
  date VARCHAR(20),
  time VARCHAR(20),
  location VARCHAR(100),
  description TEXT
);

CREATE TABLE complains (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100),
  cnic VARCHAR(20),
  description TEXT,
  is_solved BOOLEAN DEFAULT FALSE
);

CREATE TABLE staff (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100),
  gender VARCHAR(10),
  role VARCHAR(50)
);
```

### 3. Update credentials in `DBConnection.java`:

```java
private static final String USER = "your_mysql_username";
private static final String PASSWORD = "your_mysql_password";
```

---

## ▶️ Running the Project

### 1. Compile:

```bash
javac -cp "lib/*" -d bin src/*.java
```

### 2. Run:

```bash
java -cp "bin:lib/*" Main
```

> ⚠️ On **Windows**, replace `:` with `;` in the classpath.

---

## 🧠 Project Structure

```
src/
├── Main.java
├── DBConnection.java
├── PoliceStation.java
├── Fir.java
├── FirDAO.java
├── Complain.java
├── ComplainDAO.java
├── Staff.java
└── StaffDAO.java

lib/
└── mysql-connector-java-<version>.jar

bin/
└── (compiled .class files)
```

---

## 📌 Notes

* Ensure MySQL server is running on port `3306`
* Make sure the JDBC driver `.jar` is in the `lib/` folder
* All input/output happens via console

---

## 📣 Credits

Developed as a final project for the **DBMS course**, by `Jawad Nasir`.

---

## ✅ Future Improvements

* Add login system (admin/staff authentication)
* Export reports (PDF, CSV)
* GUI version using JavaFX or Swing
* Logging & error handling enhancements

---

## 🤝 Contributions

Contributions are welcome! If you'd like to improve this project — whether it's bug fixes, new features, or performance optimizations — feel free to fork the repo and submit a pull request.

> Make sure to follow Java naming conventions and keep the project modular.

Your suggestions and contributions will help make this system more robust and feature-rich for future users!
