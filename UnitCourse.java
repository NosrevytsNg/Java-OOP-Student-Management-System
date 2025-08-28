import java.util.ArrayList;
import java.util.Collections;

public class UnitCourse extends Unit {
    private double assignmentScore1, assignmentScore2, examScore;
    private ArrayList<Integer> labScores;
    private String unitID;
    private String unitLevel;
    public UnitCourse(String enrolmentType, String unitID, String unitLevel, double assignmentScore1, double assignmentScore2, double examScore){
        super(enrolmentType);
        this.unitID = unitID;
        this.unitLevel = unitLevel;
        this.assignmentScore1 = assignmentScore1;
        this.assignmentScore2 = assignmentScore2;
        this.examScore = examScore;
    }
    
    public void addLabScore(int score) {
        labScores.add(score);
    }
    
    public double calculateTop10LabAverage() {
        Collections.sort(labScores, Collections.reverseOrder());
        int sum = 0;
        for (int labIndex = 0; labIndex < 10; labIndex++) {
            sum += labScores.get(labIndex);
        }
        return sum / 10;
    }
    
    public String getEnrolmentType(){
        return "C";
    }
    
    // finding top 10 labgrades to be labscore
    // File reader for student records and information
    @Override
    public void reportGrade() {
        double top10LabAvg = calculateTop10LabAverage();
        double overallMark = 0.2 * assignmentScore1 + 0.2 * assignmentScore2 + 0.2 * top10LabAvg + 0.4 * examScore;
        String grade;
        if (overallMark >= 80) {
            grade = "HD";
        } 
        else if (overallMark >= 70) {
            grade = "D";
        } 
        else if (overallMark >= 60) {
            grade = "C";
        } 
        else if (overallMark >= 50) {
            grade = "P";
        } 
        else {
            grade = "N";
        }
        System.out.println(getEnrolmentType() + ", Unit: " + unitID + ", Mark: " + overallMark + ", Grade: " + grade);
    }
}
