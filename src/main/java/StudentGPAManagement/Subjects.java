package StudentGPAManagement;

public class Subjects {
    private static int currentId = 100;
    private final int subjectId;
    private final String name;
    private final int curriculum;
    private final String type;

    public Subjects(int id, String name, int curriculum, String type) {
        this.subjectId = (id == 0) ? currentId : id;
        currentId = this.subjectId + 1;
        this.name = name;
        this.curriculum = curriculum;
        this.type = type;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public String getName() {
        return name;
    }

    public int getCurriculum() {
        return curriculum;
    }

    public String saveData() {
        return subjectId + " - " + name + " - " + curriculum + " - " + type;
    }

    @Override
    public String toString() {
        return subjectId + " - Ten mon hoc: " + name + " - So don vi hoc trinh: " + curriculum + " - Loai mon: " + type;
    }
}
