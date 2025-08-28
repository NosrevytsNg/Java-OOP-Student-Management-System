public class Student {
    private String firstName;
    private String lastName;
    private String id;
    private String DOB;
    public Student(String sFirstName, String sLastName, String sID, String sDOB){
        firstName = sFirstName;
        lastName = sLastName;
        id = sID;
        DOB = sDOB;
    }
    
    public String getID(){
        return id;
    }
    
    public void setID(String id) {
        this.id = id;
    }
    
    public String getFirstName(){
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName(){
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
        
    public String getDOB(){
        return DOB;
    }
    
    public void setDOB(String DOB) {
        this.DOB = DOB;
    }
    
    public void reportGrade(){
        System.out.println("There is no grade");
    }
    
    @Override
    public boolean equals(Object same){
        if (this == same)
            return true;
        if (same == null)
            return false;
        Student student = (Student) same;
        if (id == student.id){
            System.out.println("There is a duplicate student: " + firstName + " " + lastName);
            return true;
        }
        return false;
    }
    
    public int compareTo(Student other) {
        return this.id.compareTo(other.id);
    }
    
    public String toString (){
        return "Name: " + firstName + " " + lastName + ", DOB: " + DOB + ", ID: " + id;
   }
}
