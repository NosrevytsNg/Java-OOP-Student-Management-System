<h2> 🧑‍🎓 Java OOP Student Management System (Inheritance, Polymorphism, CSV-Handling)</h2>

<p align="center">
  <i>Java-based program (ICT167 Assignment 2, 2024) applying OOP principles 
  (Inheritance, Polymorphism, Dynamic Binding) to manage coursework and research students.  
  Includes CSV data handling, insertion sort, and a menu-driven interface.</i>
</p>



<h3>📌 Overview</h3>

<p>
  A Java-based program applying OOP principles (inheritance, polymorphism, dynamic binding) to manage coursework and research students. 
</p>

<p>
  Features include CSV data import/export, menu-driven interaction, insertion sort by student ID, and automated grade reporting. 
</p>
<p>
  Implements a student record management system where users can add, remove, display, sort, and analyze coursework and research student data stored in an ArrayList. 
</p>
<p>
 The program supports file handling for .txt and .csv datasets, with systematic testing for validation.
</p>
<p>
  This system manages **student records** for both coursework and research enrolments.  
</p>
<p>
  Data is read from `.txt` and `.csv` files, stored in an **ArrayList**, and manipulated using menu-driven options.   
</p>
<p>
  It demonstrates **Object-Oriented Programming** concepts including **inheritance, polymorphism, and dynamic binding**, as well as manual implementation of the **insertion sort algorithm**. 
</p>



<h3>🛠️ Tech Stack</h3>

- **Language:** Java (JDK SE, NetBeans 19)  
- **Paradigm:** Object-Oriented Programming  
- **Concepts:** Inheritance, Polymorphism, Dynamic Binding  
- **Data Structure:** ArrayList of Student objects  
- **File Handling:** `.txt` and `.csv` import/export  

<h3>📂 Files Implemented</h3>

- `Client.java`  
- `Student.java`  
- `StudentCourse.java`  
- `StudentResearch.java`  
- `Unit.java`  
- `UnitCourse.java`  
- `Research.java`  
- `studentRecords.txt` (initial dataset)  
- `additionalStudentRecords.csv` (for new student records)  

<h3>🔑 Key Implementations</h3>

- **Inheritance**  
  - `StudentCourse` & `StudentResearch` extend `Student`  
  - `UnitCourse` & `Research` extend `Unit`  

- **Polymorphism**  
  - Overriding `reportGrade()` in subclasses  

- **Dynamic Binding**  
  - `reportGrade()` called on `Student` reference executes subclass method  

- **Sorting**  
  - **Insertion sort** implemented manually (ascending by student ID)  

- **CSV Handling**  
  - `getStudentData()` reads `.txt`/`.csv` into `ArrayList`  
  - `printSortedStudents()` writes sorted list into `.csv`  

<h3>🧩 Required Classes</h3>

- **Student** (base class) → `StudentCourse`, `StudentResearch`  
- **Unit** (base class) → `UnitCourse`, `Research`  
- **Client** → menu-driven program  

<h3>📜 Menu Operations (8 total)</h3>

```plaintext
Menu:
1. Quit
2. Add students from CSV
3. Remove student by ID
4. Output all student details
5. Coursework performance (above/below average)
6. Report grade by student ID
7. Sort students by ID (insertion sort)
8. Export sorted list to CSV
Enter your choice:
