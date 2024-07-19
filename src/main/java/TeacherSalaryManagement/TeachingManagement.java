package TeacherSalaryManagement;

public class TeachingManagement {
    private final Teachers teacher;
    private final Subjects[] subjectList;
    private final int[] numberOfClasses;
    private int subjectCount;

    public TeachingManagement(Teachers teacher) {
        this.teacher = teacher;
        this.subjectList = new Subjects[100];
        this.numberOfClasses = new int[100];
        this.subjectCount = 0;
    }

    public int getTotalClasses() {
        int total = 0;
        for (int i=0; i<subjectCount; i++) {
            total += numberOfClasses[i];
        }
        return total;
    }

    public boolean teaching(Subjects subj, int quantity) {
        if ((subjectCount > 200) || (quantity > 3)) return false;
        for (int i = 0; i < subjectCount; i++) {
            if (this.subjectList[i].getSubjectId() == subj.getSubjectId()) {
                if ((this.numberOfClasses[i]+quantity) > 3) {
                    return false;
                } else {
                    this.numberOfClasses[i] += quantity;
                    return true;
                }
            }
        }
        this.subjectList[subjectCount] = subj;
        this.numberOfClasses[subjectCount] = quantity;
        subjectCount += 1;
        return true;
    }

    public double calculateSalaryPerTeacher() {
        double sum = 0;

        for (int i=0; i<subjectCount; i++) {
            sum += this.subjectList[i].calculateSalaryPerSubject()*this.numberOfClasses[i];
        }

        return sum;
    }

    public Teachers getTeacher() {
        return teacher;
    }

    public Subjects[] getSubjectList() {
        return subjectList;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Danh sach cac mon hoc giang vien " + teacher.getName() + " day:");
        for (int i = 0; i < subjectCount; i++) {
            result.append("\n\t" + subjectList[i].getName() + " - " + numberOfClasses[i] + " lop");
        }
        return result.toString();
    }
}
