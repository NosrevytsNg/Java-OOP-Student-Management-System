// ICT167 Assignment 2
// Styverson Ng Yu Hao
// 7/30/2024
// File Name: ICT167 Assignment 2
// Purpose: Client program to view and manage Student Data
// Assumptions:
// 1. studentRecords.txt and additionalStudentRecords.csv as to be strictly followed
// 2. "C" for course work students and "R" for research student are the first value for all files
// 3. The index positions are to be followed, any changes will disrupt the reading of data
// 4. Standard Index Position: values[0] = "C" or "R", values[1] = first name, values[2] = last name, values[3] = student ID, values[4] = date of birth
// 5. Preset Sorting Order = Ascending

import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

public class Client{

    public static void main(String[] args) {
        StudentInfo();
        ArrayList<Student> studentData = new ArrayList<>();
        getStudentData(studentData);
        menu(studentData);
        //testInstances();  
    }      
        
    public static void menu(ArrayList<Student> studentData){
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Menu:");
            System.out.println("1. Quit");
            System.out.println("2. Add student records to ArrayList from new CSV file");
            System.out.println("3. Remove student by ID");
            System.out.println("4. Output all student details");
            System.out.println("5. Calculate number of course work students that are above/below average");
            System.out.println("6. Display report grade of student by student ID");
            System.out.println("7. Sort students by ID");
            System.out.println("8. Output sorted list to CSV file");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch(choice){
                // DONE
                case 1:
                    System.out.println("Exiting program");
                    return;
                // DONE
                case 2:
                    addStudent(studentData);
                    break;
                // DONE    
                case 3:
                    removeStudentByID(studentData);
                    break;
                // DONE    
                case 4:
                    outputAllDetails(studentData);
                    break;
                // Testing    
                case 5:
                    courseWorkStudentPerformance(studentData);
                    break;
                // Testing3
                case 6:
                    reportGradeInfoByID(studentData);
                    break;    
                //DONE    
                case 7:
                    sortStudentsByID(studentData);
                    break;
                //DONE
                case 8:
                    printSortedStudents(studentData);
                    break;
                default:
                    System.out.println("Please choose an option from the menu (1 to 8)");      
            }
        }
    }
    
    // COMPLETED
    // File reader for student records and information
    public static void getStudentData(ArrayList<Student> studentData){
        String inFileName = "studentRecords.txt";
        Scanner reader = null;
        try{
            reader = new Scanner(new File(inFileName));
            while (reader.hasNext()){
                String oneLine = reader.nextLine();
                //studentData.add(oneLine);
                String[] values = oneLine.split("\\s+");
                if (values [0].equals("C")){
                    StudentCourse student = new StudentCourse(values[1], values[2], values[3], values[4]);
                    for (int labIndex = 8; labIndex < 20; labIndex++){
                        student.addLabScore(Integer.parseInt(values[labIndex]));
                    }
                    student.setAssignmentScore(Integer.parseInt(values[6]),Integer.parseInt(values[7]));
                    student.setExamScore(Integer.parseInt(values[20])); 
                    student.setUnitID(values[5]);
                    studentData.add(student);
                }
                else if (values [0].equals("R")){
                    StudentResearch student = new StudentResearch(values[1], values[2], values[3], values[4]);
                    student.setScore(Integer.parseInt(values[5]), Integer.parseInt(values[6]));
                    studentData.add(student);
                }
                else{
                    System.out.println("Invalid enrolment type");
                }
            }
        }
        catch(FileNotFoundException err){
            System.out.println(err);
        }
        finally{
            if(reader != null){
                reader.close();
            }
        }
    }

    // COMPLETED
    // Option 2
    public static void addStudent(ArrayList<Student> studentData) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter the CSV file name to add new students: ");
    String fileName = scanner.nextLine();

    Scanner fileReader = null;
    try {
        fileReader = new Scanner(new File(fileName));
        while (fileReader.hasNextLine()) {
            String oneLine = fileReader.nextLine();
            String[] values = oneLine.split(",");

            // Debugging output
            System.out.println("Reading line: " + oneLine);

            if (values[0].equals("C")) {
                StudentCourse student = new StudentCourse(values[1], values[2], values[3], values[4]);
                for (int labIndex = 8; labIndex < 20; labIndex++) {
                    student.addLabScore(Integer.parseInt(values[labIndex]));
                }
                student.setAssignmentScore(Integer.parseInt(values[6]), Integer.parseInt(values[7]));
                student.setExamScore(Integer.parseInt(values[20]));
                student.setUnitID(values[5]);
                studentData.add(student);

                // Show the addition of course work students to the ArrayList
                System.out.println("Added Course Student: " + student);
            } else if (values[0].equals("R")) {
                StudentResearch student = new StudentResearch(values[1], values[2], values[3], values[4]);
                student.setScore(Integer.parseInt(values[5]), Integer.parseInt(values[6]));
                studentData.add(student);

                // Show the addition of research students to the ArrayList
                System.out.println("Added Research Student: " + student);
            } else {
                System.out.println("Invalid enrolment type in the file: " + fileName);
            }
        }
        System.out.println("New student data from " + fileName + " has been added.");
    } catch (FileNotFoundException e) {
        System.out.println("File not found: " + e.getMessage());
    } catch (NumberFormatException e) {
        System.out.println("Error in data format: " + e.getMessage());
    } finally {
        if (fileReader != null) {
            fileReader.close();
        }
    }
}    
    // COMPLETED
    // Option 3
    public static void removeStudentByID(ArrayList<Student> studentData) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the student ID to remove: ");
        String studentID = scanner.nextLine();

        Student studentToRemove = null;
        for (Student selectedStudent : studentData) {
            if (selectedStudent.getID().equals(studentID)) {
                studentToRemove = selectedStudent;
                break;
            }
        }

        if (studentToRemove != null) {
            System.out.println("Student found: " + studentToRemove);
            System.out.print("Are you sure you want to remove this student? (yes/no): ");
            String confirmation = scanner.nextLine().toLowerCase();

            if (confirmation.equals("yes")) {
                studentData.remove(studentToRemove);
                System.out.println("Student has been removed.");
            } else {
                System.out.println("Student removal cancelled.");
            }
        } else {
            System.out.println("Student with ID " + studentID + " not found.");
        }
    }

   
    // COMPLETED
    // Option 4
    public static void outputAllDetails(ArrayList<Student> studentData) {
        for (Student student : studentData) {
            student.reportGrade();
        }
        System.out.println("--------------------------------------------------------------");           
    }
    
    // COMPLETED
    // Option 5
    public static void courseWorkStudentPerformance(ArrayList<Student> studentData) {
        double totalMarks = 0;
        int courseWorkStudentCount = 0;

        // Calculate the total marks and count the number of coursework students
        for (Student student : studentData) {
            String[] values = student.toString().split("\\s+");
            if (values[0].equals("C")) {
                // Assuming StudentCourse class has a method getOverallMark()
                totalMarks += ((StudentCourse) student).getOverallMark();
                courseWorkStudentCount++;
            }
        }

        // Check if there are any coursework students to avoid division by zero
        if (courseWorkStudentCount == 0) {
            System.out.println("No coursework students found.");
            return;
        }

        // Calculate the average mark of coursework students
        double averageMark = totalMarks / courseWorkStudentCount;

        int aboveAverageCount = 0;
        int belowAverageCount = 0;

        // Count the number of students above and below the average mark
        for (Student student : studentData) {
            String[] values = student.toString().split("\\s+");
            if (values[0].equals("C")) {
                double overallMark = ((StudentCourse) student).getOverallMark();
                if (overallMark > averageMark) {
                    aboveAverageCount++;
                } else {
                    belowAverageCount++;
                }
            }
        }

        System.out.println("Average Mark of Coursework Students: " + averageMark);
        System.out.println("Number of students above the average: " + aboveAverageCount);
        System.out.println("Number of students below the average: " + belowAverageCount);
    }
    
    // COMPLETED
    // Option 6
    public static void reportGradeInfoByID(ArrayList<Student> studentData) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the student ID to display information: ");
        String studentID = scanner.nextLine();

        Student selectedStudent = null;
        for (Student student : studentData) {
            if (student.getID().equals(studentID)) {
                selectedStudent = student;
                break;
            }
        }

        if (selectedStudent != null) {
            selectedStudent.reportGrade();
        } else {
            System.out.println("Student with ID " + studentID + " not found.");
        }
    }

    // COMPLETED
    // Option 7
    public static void sortStudentsByID(ArrayList<Student> studentData) {
        for (int studentIndex = 1; studentIndex < studentData.size(); studentIndex++){
            Student current = studentData.get(studentIndex);
            int nextStudent = studentIndex - 1;
        
        
            while(nextStudent >= 0 && studentData.get(nextStudent).getID().compareTo(current.getID()) > 0){
                studentData.set(nextStudent + 1, studentData.get(nextStudent));
                nextStudent = nextStudent - 1;
            }
            studentData.set(nextStudent + 1, current);
        }    
        System.out.println("Students sorted by ID is completed.");
    }
        
      
    // COMPLETED
    // Option 8
    public static void printSortedStudents(ArrayList<Student> studentData){
        String outFileName = "SortedStudentsList.csv";
        PrintWriter writer = null;
        
        try{
            writer = new PrintWriter(outFileName);
            for (Student student : studentData){
                writer.println(student.toString());
            }
            System.out.println("Sorted student data exported to " + outFileName);
        }
        catch(FileNotFoundException err){
            System.out.println(err);
        }
        finally{
            if(writer != null){
                writer.close();
            }
        }
    }
    
    public static void testInstances(){
        Student t1 = new Student("Charles","LeClerc", "1234", "12/34/56");
        System.out.println(t1);
        StudentCourse t2 = new StudentCourse("Max", "Verstappen", "7895","23/05/1987");
        System.out.println(t2);
        StudentResearch t3 = new StudentResearch("Lando", "Norris", "6548", "11/12/13");
        System.out.println(t3);
        UnitCourse t4 = new UnitCourse("C","ICT678","Year 1", 96,34,73);
        System.out.println(t4);
        Research t5 = new Research("R",86,54);
        System.out.println(t5);
    }
    
    public static void StudentInfo(){
        System.out.println("Styverson Ng");
        System.out.println("Kaplan Student Number: CT0372348");
        System.out.println("Murdoch Student Number: 35427675");
        System.out.println("ICT167");
        System.out.println("Siew Cheong Chong");
        System.out.println("ICT167A");
        System.out.println("Wednesday 4:15pm to 6:15pm");
        System.out.println("---------------------------------");
    }
}
            
            
            
