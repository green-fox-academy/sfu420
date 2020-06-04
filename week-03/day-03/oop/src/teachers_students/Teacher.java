package teachers_students;

public class Teacher {
  public void teach(Student student) {
    student.learn();
  }

  public void answer() {
    System.out.println("Teacher is answering a question...");
  }
}
