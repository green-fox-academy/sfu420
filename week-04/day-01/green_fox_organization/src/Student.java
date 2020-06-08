public class Student extends Person {
  private String previousOrganization;
  private int skippedDays;

  public Student() {
    super();
    this.previousOrganization = "The School of Life";
    this.skippedDays = 0;
  }

  public Student(String name, int age, String gender, String previousOrganization) {
    super(name, age, gender);
    this.previousOrganization = previousOrganization;
    this.skippedDays = 0;
  }

  @Override
  public void getGoal() {
    System.out.println("My goal is: Be a junior software developer.");
  }

  @Override
  protected String introExtender() {
    return " from " + this.previousOrganization + ", who skipped " + this.skippedDays +
        " days from the course already.";
  }

  public void skipDays(int numberOfDays) {
    this.skippedDays += numberOfDays;
  }
}
