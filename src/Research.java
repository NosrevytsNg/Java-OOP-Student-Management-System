public class Research extends Unit{
    private double proposalScore;
    private double dissertationScore;
    public Research(String enrolmentType, double proposalScore, double dissertationScore){
        super(enrolmentType);
        this.proposalScore = proposalScore;
        this.dissertationScore = dissertationScore;
    }
    
    public double getScore(){
        return proposalScore * 0.35 + dissertationScore * 0.65;
    }
    
    @Override
    public void reportGrade(){
        double overallMark = getScore();
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
        System.out.println(getEnrolmentType() + ", Mark: " + overallMark + ", Grade: " + grade);
    } 
}
