package test;

import school.School;
import school.Score;
import school.Student;
import school.Subject;
import school.report.GenerateGradeReport;
import utils.Define;

public class TestMain {

  School goodSchool = School.getInstance();
  Subject korean;
  Subject math;
  Subject science;

  GenerateGradeReport gradeReport = new GenerateGradeReport();

  public static void main(String[] args) {

      TestMain test = new TestMain();

      test.createSubject();
      test.createStudent();

      String report = test.gradeReport.getReport();
    System.out.println(report);

  }

  private void createStudent() {

    Student student1 = new Student(211213, "김석진", korean);
    Student student2 = new Student(212330, "민윤기", math);
    Student student3 = new Student(201518, "정호석", korean);
    Student student4 = new Student(201518, "김남준", korean);
    Student student5 = new Student(201290, "박지민", math);

    goodSchool.addStudent(student1);
    goodSchool.addStudent(student2);
    goodSchool.addStudent(student3);
    goodSchool.addStudent(student4);
    goodSchool.addStudent(student5);

    korean.register(student1);
    korean.register(student2);
    korean.register(student3);
    korean.register(student4);
    korean.register(student5);

    math.register(student1);
    math.register(student2);
    math.register(student3);
    math.register(student4);
    math.register(student5);

    science.register(student1);
    science.register(student3);
    science.register(student5);

    addScoreForStudent(student1, korean, 95);
    addScoreForStudent(student1, math, 56);
    addScoreForStudent(student1, science, 95);

    addScoreForStudent(student2, korean, 95);
    addScoreForStudent(student2, math, 95);

    addScoreForStudent(student3, korean, 100);
    addScoreForStudent(student3, math, 88);
    addScoreForStudent(student3, science, 85);

    addScoreForStudent(student4, korean, 89);
    addScoreForStudent(student4, math, 95);

    addScoreForStudent(student5, korean, 85);
    addScoreForStudent(student5, math, 56);
    addScoreForStudent(student5, science, 55);
  }

  private void createSubject() {

    korean = new Subject(Define.KOREAN, "국어");
    math = new Subject(Define.MATH, "수학");
    science = new Subject(Define.SCIENCE, "과학");

    goodSchool.addSubject(korean);
    goodSchool.addSubject(math);
    goodSchool.addSubject(science);
  }

  private void addScoreForStudent(Student student, Subject subject, int point) {

    Score score = new Score(student.getStudentId(),subject,point);

    student.addSubjectScore(score);
  }
}
