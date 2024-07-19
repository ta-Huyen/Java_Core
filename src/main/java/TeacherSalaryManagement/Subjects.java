package TeacherSalaryManagement;

public class Subjects {
    private static int currentId = 100;
    private final int subjectId;
    private final String name;
    private final int numberOfLesson;
    private final int numberOfTheoryLesson;
    private final int lessonPrice;

    public Subjects(String name, int numberOfLesson, int numberOfTheoryLesson, int lessonPrice) {
        this.subjectId = currentId++;
        this.name = name;
        this.numberOfLesson = numberOfLesson;
        this.numberOfTheoryLesson = numberOfTheoryLesson;
        this.lessonPrice = lessonPrice;
    }

    public double calculateSalaryPerSubject() {
        return lessonPrice*numberOfTheoryLesson + (numberOfLesson - numberOfTheoryLesson)*0.7*lessonPrice;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfLesson() {
        return numberOfLesson;
    }

    public int getNumberOfTheoryLesson() {
        return numberOfTheoryLesson;
    }

    public int getLessonPrice() {
        return lessonPrice;
    }

    @Override
    public String toString() {
        return "Ma mon hoc: " + subjectId +
                " - Ten mon hoc: " + name +
                " -Tong so tiet: " + numberOfLesson +
                " - So tiet ly thuyet: " + numberOfTheoryLesson +
                " - Muc kinh phi: " + lessonPrice;
    }
}
