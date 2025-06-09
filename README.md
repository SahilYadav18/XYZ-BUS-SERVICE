# XYZ-BUS-SERVICE
A console based application made for ticket booking of buses.



# 🚌 XYZ Bus Service Management System

This is a simple **Java-based Bus Management System** that allows **operators** to manage buses and **customers** to book or cancel tickets using a MySQL backend. It provides two portals:

* **Operator Portal** – Add, update, delete, or view buses.
* **Customer Portal** – Book tickets, cancel tickets, view bus details.

## 📁 Features

### Operator Portal:

* View bus details
* Add a new bus
* Delete a bus
* Update journey date, capacity, availability, starting/ending points

### Customer Portal:

* Book a ticket
* Cancel a ticket
* View available buses

## 💻 Technologies Used

* Java
* JDBC (Java Database Connectivity)
* MySQL

## 🛠️ Prerequisites

* Java JDK 8 or above
* MySQL server installed and running
* MySQL JDBC Driver (`mysql-connector-java`)

## 📦 Database Schema

```sql
CREATE DATABASE xyzbusez;

USE xyzbusez;

CREATE TABLE BUSES (
  BUSNO INT PRIMARY KEY,
  JRNYDATE DATE,
  CAPACITY INT,
  AVAILABLE INT,
  SPOINT VARCHAR(100),
  ENDING_POINT VARCHAR(100)
);

CREATE TABLE PASSENGER (
  PASSID INT PRIMARY KEY,
  NAME VARCHAR(100),
  DATE_BOOKED DATE,
  AMOUNT INT,
  BUSNO INT,
  STARTINGPOINT VARCHAR(100),
  DESTINATIONPOINT VARCHAR(100),
  FOREIGN KEY (BUSNO) REFERENCES BUSES(BUSNO)
);
```

## 🚀 How to Run

### 1. Clone the Repository

```bash
git clone https://github.com/SahilYadav18/XYZ-BUS-SERVICE.git
cd XYZ-BUS-SERVICE
```

### 2. Configure MySQL Credentials

Update your `Main.java` file with correct database credentials:

```java
public static final String URL = "jdbc:mysql://localhost:3306/xyzbusez";
public static final String username = "root";
public static final String password = "Root";
```

### 3. Compile and Run

Make sure you add the MySQL JDBC driver to your classpath.

```bash
javac Main.java
java Main
```

Or use your IDE (Eclipse, IntelliJ, etc.) to run the `Main` class.

## 🧪 Sample Data

```sql
INSERT INTO BUSES VALUES (101, '2025-06-15', 50, 50, 'Delhi', 'Lucknow');
INSERT INTO BUSES VALUES (102, '2025-06-20', 40, 40, 'Mumbai', 'Pune');
```

## 📄 License

This project is open-source and free to use.

---


