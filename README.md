# 💰 Console Budget Planner (Java)

A simple Java-based **Console Budget Planner** that helps users manage their income, expenses, monthly budgets, and savings. The project demonstrates Object-Oriented Programming (OOP) concepts through a practical financial management application.

## 🚀 Features

- **User Management** – Store user details, email, currency, and profiles.
- **Income Tracking** – Record multiple sources of income.
- **Expense Management** – Track fixed and variable expenses.
- **Category Management** – Organize expenses into categories such as Rent, Food, Travel, and Bills.
- **Monthly Budget Limits** – Set spending limits for different categories.
- **Budget Monitoring** – Check remaining budgets and spending status.
- **Transaction History** – Maintain income and expense records.
- **Monthly Reports** – Generate monthly financial statements.
- **Spending Analysis** – Identify the top three spending categories.
- **Savings Calculation** – Calculate total income, expenses, and savings.

## 🛠️ Technologies Used

- Java
- Object-Oriented Programming (OOP)
- Java Collections Framework
- Java Time API

## 📂 Project Structure

```text
Budget-Planner/
│
├── User.java
├── Category.java
├── FixedCategory.java
├── VariableCategory.java
├── Transaction.java
├── FixedExpense.java
├── VariableExpense.java
├── BudgetService.java
├── BudgetAppMain.java
│
└── README.md
```

## 🧠 OOP Concepts Implemented

This project demonstrates the following Java concepts:

1. **Encapsulation** – Private variables with public getter and setter methods.
2. **Inheritance** – FixedCategory and VariableCategory extend Category.
3. **Inheritance** – FixedExpense and VariableExpense extend Transaction.
4. **Polymorphism** – Method overriding and runtime polymorphism.
5. **Method Overloading** – Multiple addExpense() methods with different parameters.
6. **Abstraction** – Organizing application functionality into separate classes.

## ⚙️ How to Run

### Prerequisites

- Java JDK 8 or above.
- VS Code, IntelliJ IDEA, Eclipse, or any Java-supported IDE.

### Step 1: Clone the Repository

```bash
git clone https://github.com/your-username/Budget-Planner.git
```

### Step 2: Open the Project Folder

```bash
cd Budget-Planner
```

### Step 3: Compile the Java Files

```bash
javac *.java
```

### Step 4: Run the Application

```bash
java BudgetAppMain
```

## 📊 Sample Output

```text
===== CONSOLE BUDGET PLANNER =====

User: 101 - Arun (arun@mail.com)

CATEGORY-WISE BUDGET

Rent           Spent:  9000.00
Food           Spent:  3700.00
Travel         Spent:  1800.00
Bills          Spent:  1500.00

OVERALL SUMMARY (INR)

Income : 35000.00
Expense: 16000.00
Savings: 19000.00

Transactions: 7

Budget Planner Completed Successfully!
```

## 🎯 Project Objective

The main objective of this project is to apply Java OOP concepts to develop a practical application for managing personal finances. It demonstrates how classes, objects, inheritance, polymorphism, and collections can work together in a real-world application.

## 🔮 Future Enhancements

- Interactive menu-driven interface.
- Database integration using MySQL.
- User login and authentication.
- Graphical User Interface (GUI).
- Export financial reports to PDF or Excel.
- Expense visualization using charts.

## 👨‍💻 Author

**Your Name**

Java | Object-Oriented Programming | Software Development

---

⭐ If you find this project useful, consider giving the repository a star!
