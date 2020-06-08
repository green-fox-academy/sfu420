public class Sponsor extends Person {
  String company;
  int hiredStudents;

  public Sponsor() {
    super();
    this.company = "Google";
    this.hiredStudents = 0;
  }

  public Sponsor(String name, int age, String gender, String company) {
    super(name, age, gender);
    this.company = company;
    this.hiredStudents = 0;
  }

  @Override
  public String introExtender() {
    return ", who represents " + this.company + " and hired " + this.hiredStudents +
        " students so far.";
  }

  public void hire() {
    this.hiredStudents++;
  }

  @Override
  public void getGoal() {
    System.out.println("My goal is: Hire brilliant junior software developers.");
  }
}
