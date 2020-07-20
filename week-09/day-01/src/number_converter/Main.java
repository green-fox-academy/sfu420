package number_converter;

public class Main {

  public static void main(String[] args) {

    System.out.println(convertToString(1999.00f));    //TODO: 100, 200, 300... does not work yet
  }

  public static String convertToString(Float number) {
    int hundred = (int) (number / 100);
    int tenth = (int) (number % 100);
    System.out.println(hundred);
    System.out.println(tenth);
    return getHundredsString(hundred) + getTenthString(tenth) + " dollars";
  }

  public static String getHundredsString(int hundred) {
    if (hundred == 0) {
      return "";
    } else if (hundred < 10) {
      return Numbers.values()[hundred - 1].name().toLowerCase() + " hundred and ";
    }
    return Teens.values()[(hundred % 10) - 1].name().toLowerCase() + " hundred and ";
  }

  public static String getTenthString(int tenth) {
    if (tenth % 10 == 0) {
      return Tenth.values()[(tenth / 10) - 1].name().toLowerCase();
    } else if (tenth < 10) {
      return Numbers.values()[(tenth % 10) - 1].name().toLowerCase();
    } else if (tenth < 20) {
      return Teens.values()[(tenth % 10) - 1].name().toLowerCase();
    }
    return Tenth.values()[(tenth / 10) - 1].name().toLowerCase() + " " +
        Numbers.values()[(tenth % 10) - 1].name().toLowerCase();
  }
}
