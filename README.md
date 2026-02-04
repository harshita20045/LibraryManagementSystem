📚 Library Management System

A simple Java-based Library Management System to handle basic library operations such as managing books and members, and tracking transactions like borrowing and return of items.

This project implements core library functionality using object-oriented Java, focused on understanding fundamental concepts like classes, collections, and basic I/O.

🧠 Overview

A Library Management System (LMS) is software designed to automate and simplify routine tasks in a library — including cataloging books, managing member accounts, and recording borrow/return transactions.

This repository contains a console program built with Java that represents library entities and operations in code.

🗂️ Project Structure
File	Responsibility
Main.java	Program entry point; demo/test logic
Library.java	Core library operations (add/remove/search)
Book.java	Represents a book entity
Magazine.java	Represents a magazine entity
LibraryItem.java	Base class for all library items
Member.java	Stores member details
Transaction.java	Handles borrow/return activity

All source code is pure Java (no frameworks), making this ideal for learning OOP design.

⚙️ Features

This system covers the essentials of an LMS:
📘 Manage library items (books/magazines)
👤 Track library members
🔄 Create and process transactions (issue & return)
🔍 Search items by basic criteria
🛠 Class-based structure to model real-world entities
This aligns with common requirements for library automation solutions, which aim to replace manual processes with efficient software control.

🚀 Getting Started
Requirements
- Make sure you have:
- Java JDK 8 or above
- Any text editor or IDE (like VS Code, IntelliJ, or Eclipse)

Build & Run

Clone the repository
```console
git clone https://github.com/harshita20045/LibraryManagementSystem.git
```


Navigate to project folder
``` 
cd LibraryManagementSystem
```


Compile all .java files
``` 
javac *.java
```


Run the program
```
java Main
```

💡 How It Works

At runtime, the program simulates a library workspace:
A Library object holds collections of LibraryItems and Members.

Transactions (borrow/return) are created via instances of the Transaction class.

Items like Book and Magazine extend from LibraryItem, demonstrating inheritance.
