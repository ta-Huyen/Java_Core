package StudentGPAManagement;

public class Reports {
    private final Students student;
    private final Subjects subject;
    private final double grade;

    public Reports(Students student, Subjects subject, double grade) {
        this.student = student;
        this.subject = subject;
        this.grade = grade;
    }

    public Students getStudent() {
        return student;
    }

    public Subjects getSubject() {
        return subject;
    }

    public double getGrade() {
        return grade;
    }

    public String saveData() {
        return student.getStudentId() + " - " + subject.getSubjectId() + " - " + grade;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Bang diem cua sinh vien " + student.getName() + ":");
        result.append("\n\t" + subject.getName() + " - Diem: " + grade);

        return result.toString();
    }
}
