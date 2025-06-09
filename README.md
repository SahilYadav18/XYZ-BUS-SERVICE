# XYZ-BUS-SERVICE
A console based application made for ticket booking of buses.


# 🚍 Bus Management System (Java + MySQL)

This is a simple **Java console application** for managing a bus booking system. It provides two main portals:

Operator Portal – for managing bus details (CRUD operations).
* **Passenger Portal** – for booking, cancelling, and viewing tickets.

### 📌 Features

#### 👨‍💼 Operator Portal

* View bus details
* Add a new bus
* Delete a bus
* Update:

  * Journey Date
  * Capacity
  * Available seats
  * Starting Point
  * Ending Point

#### 🧑‍💼 Passenger Portal

* Book a ticket
* Cancel a ticket
* View bus details

---

## 🛠️ Technologies Used

* **Java**
* **MySQL**
* **JDBC API**

---

## 📋 Database Schema

### Table: `BUSES`

| Column        | Type              |
| ------------- | ----------------- |
| BUSNO         | INT (Primary Key) |
| JRNYDATE      | DATE              |
| CAPACITY      | INT               |
| AVAILABLE     | INT               |
| SPOINT        | VARCHAR(50)       |
| ENDING\_POINT | VARCHAR(50)       |

### Table: `PASSENGER`

| Column           | Type              |
| ---------------- | ----------------- |
| PASSID           | INT (Primary Key) |
| NAME             | VARCHAR(100)      |
| DATE\_BOOKED     | DATE              |
| AMOUNT           | INT               |
| BUSNO            | INT (Foreign Key) |
| STARTINGPOINT    | VARCHAR(50)       |
| DESTINATIONPOINT | VARCHAR(50)       |

---

## 🔧 Setup Instructions

### ✅ Prerequisites

* Java 8 or higher
* MySQL installed and running
* MySQL JDBC Driver (e.g., `mysql-connector-java`)
* IDE like IntelliJ IDEA / Eclipse or just use command line

### 📂 Steps

1. **Clone the repository**

   ```bash
   git clone https://github.com/your-username/bus-management-system.git
   cd bus-management-system
   ```

2. **Setup MySQL**

   * Create the database:

     ```sql
     CREATE DATABASE xyzbusez;
     USE xyzbusez;
     ```
   * Create the `BUSES` and `PASSENGER` tables using the schema above.

3. **Configure DB Credentials**

   * In the `Main.java` file, update the following constants:

     ```java
     public static final String URL = "jdbc:mysql://localhost:3306/xyzbusez";
     public static final String username = "your_mysql_username";
     public static final String password = "your_mysql_password";
     ```

4. **Compile and Run the Project**

   ```bash
   javac Main.java
   java Main
   ```

---

## 📸 Screenshots

> You can add CLI screenshots here to show how it works.

---

## 📄 License

This project is open-source and available under the [MIT License](LICENSE).

---

## 🤝 Contribution

Pull requests and suggestions are welcome! Feel free to fork the repository and make changes.

---

Let me know if you'd like me to include sample SQL for table creation too.
