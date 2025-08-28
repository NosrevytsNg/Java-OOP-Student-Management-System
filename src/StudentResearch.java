public class StudentResearch extends Student {
    private int proposalScore, dissertationScore;
    public StudentResearch(String sFirstName, String sLastName, String sID, String sDOB){
        super(sFirstName, sLastName, sID, sDOB);
        
    }
    
    public String enrolmentType(){
        return "R";
    }
    
    public void setScore(int proposalScore, int dissertationScore ){
        this.proposalScore = proposalScore;
        this.dissertationScore = dissertationScore;
    }
    
    public double getOverallMark(){
        double overallMark = (proposalScore * 0.35) + (dissertationScore *0.65);
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
    public void reportGrade(){
        double overallMark = getOverallMark();
        String grade = getGrade();
        System.out.println(enrolmentType()+ " " + getFirstName() + " " + getLastName() + ", ID: " + getID() +  ", Mark: " + overallMark + ", Grade: " + grade);
    }
    
    @Override
    public String toString() {
        return String.format("R %s %s, ID: %s, Mark: %.2f, Grade: %s", getFirstName(), getLastName(), getID(), getOverallMark(), getGrade());
    }
    
}
