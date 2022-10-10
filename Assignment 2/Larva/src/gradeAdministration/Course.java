package gradeAdministration;

import java.util.ArrayList;
import java.util.HashMap;

public class Course {
    String courseCode;
    String name;
    double credit;
    ArrayList<Student> enrolledStudents;
    HashMap<Student, Integer> grades;
    int academicYear;
    String startingBlock; // Quartile in which the course is given
    String lecturer;

    Course(String code, String name, double credit, int academicYear, String startingBlock, String lecturer) {
        this.courseCode = code;
        this.name = name;
        this.credit = credit;
        this.enrolledStudents = new ArrayList<>();
        this.grades = new HashMap<>();
        this.academicYear = academicYear;
        this.startingBlock = startingBlock;
        this.lecturer = lecturer;
    }

    public void addGrade(Student s, int g) {
        this.grades.put(s, g);
    }
    public boolean studentPassedCourse(Student s) {
        return isEnrolled(s) && gotPassingGrade(s);
    }

    private boolean gotPassingGrade(Student s) {
        return grades.get(s) >= 6;
    }

    private boolean isEnrolled(Student s) {
        return enrolledStudents.contains(s);
    }

    public void enrollStudent(Student s) {
        if (!enrolledStudents.contains(s)) {
            enrolledStudents.add(s);
        }
    }

    public String getCourseCode() {
        return this.courseCode;
    }

    public String getName() {
        return this.name;
    }

    public double getCredit() {
        return this.credit;
    }

    public ArrayList<Student> getEnrolledStudents() {
        return this.enrolledStudents;
    }

    public HashMap<Student, Integer> getGrades() {
        return this.grades;
    }

    public int getAcademicYear() {
        return this.academicYear;
    }

    public String getStartingBlock() {
        return this.startingBlock;
    }

    public String getLecturer() {
        return this.lecturer;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public void setAcademicYear(int academicYear) {
        this.academicYear = academicYear;
    }

    public void setStartingBlock(String startingBlock) {
        this.startingBlock = startingBlock;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }

    public String toString() {
        return  "Course code: "+this.courseCode+"\n" +
                "Course name: "+this.name+"\n"+
                "Lecturer: "+this.lecturer+"\n" +
                "Academic year, starting block: "+this.academicYear+", "+this.startingBlock+"\n" +
                "Credits earned by taking this course: "+this.credit+"\n" +
                "Enrolled students: "+this.enrolledStudents.toString()+"\n" +
                "Grades: "+this.grades.toString()+"\n";
    }


}
