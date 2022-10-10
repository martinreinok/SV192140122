package gradeAdministration;

public class Student {
    String name;
    int studentNumber;
    double credits;

    Student(String n, int studentNumber) {
        this.name = n;
        this.studentNumber = studentNumber;
        this.credits = 0;
    }

    void addCredits(double n) {
        this.credits += n;
    }

    public void setCredits(double credits) {
        this.credits = credits;
    }

    public String getName() {
        return this.name;
    }

    void setName(String n) {
        this.name = n;
    }

    public String toString() {
        return "("+this.studentNumber+", "+this.name+", "+this.credits+")";
    }
}
