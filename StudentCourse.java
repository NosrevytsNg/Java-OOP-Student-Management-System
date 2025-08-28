import java.util.ArrayList;
import java.util.Collections;

public class StudentCourse extends Student {
    private String unitID;
    private ArrayList<Integer> labScores;
    private double assignmentScore1, assignmentScore2, examScore;
    public StudentCourse(String sFirstName, String sLastName, String sID, String sDOB) {
        super(sFirstName,sLastName, sID, sDOB);
        this.labScores = new ArrayList<>();   
    }

    public void addLabScore(int score) {
        labScores.add(score);
    }
    
    public void setUnitID(String unitID){
        this.unitID = unitID;
    }
    
    public void setAssignmentScore(double assignmentScore1, double assignmentScore2 ){
        this.assignmentScore1 = assignmentScore1;
        this.assignmentScore2 = assignmentScore2;
    }
     
    public void setExamScore(double examScore){
        this.examScore = examScore;
    }
     
    public String getEnrolmentType(){
        return "C";
    }

    public double calculateTop10LabAverage() {
    Collections.sort(labScores, Collections.reverseOrder());
    int sum = 0;
    for (int labIndex = 0; labIndex < 10; labIndex++) {
        sum += labScores.get(labIndex);
    }
    return sum / 10.0;
}
    
    public double getOverallMark(){
        double top10LabAvg = calculateTop10LabAverage();
        double overallMark = (0.2 * assignmentScore1) + (0.2 * assignmentScore2) + top10LabAvg + (0.4 * examScore);
        return overallMark;    
    }
    
    public String getGrade(){
        double overallMark = getOverallMark();
        String grade;
        if (overallMark >= 80) {
            grade = "HD";
        } else if (overallMark >= 70) {
            grade = "D";
        } else if (overallMark >= 60) {
            grade = "C";
        } else if (overallMark >= 50) {
            grade = "P";
        } else {
            grade = "N";
        }
        return grade;
    }

    @Override
    public void reportGrade() {
        double overallMark = getOverallMark();
        String grade = getGrade();
        System.out.println(getEnrolmentType()+ " " + getFirstName() + " " + getLastName() + ", ID: " + getID() + ", Unit: " + unitID + " " + ", Mark: " + overallMark + ", Grade: " + grade);   
    }
    
    @Override
    public String toString() {
        return String.format("C %s %s, ID: %s, Unit: %s, Mark: %.1f, Grade: %s", getFirstName(), getLastName(), getID(), unitID, getOverallMark(), getGrade());
    }
}

