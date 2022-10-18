package org.example.javaversion;

public class Java14 {

  public static void main(String[] args) {

    // return and yield different, yield is end to switch, return is end to method or loop
    String str = switch ("test"){
      case "te" -> {
        System.out.println("te");
        yield "te ok";
      }
      case "test" ->{
        System.out.println("test");
        yield "test ok";
      }
      default -> {
        System.out.println("default");
        yield "default";
      }
    };

    System.out.println(str);

    System.out.println("-------------------------------");

    // \ mean end line, line breaks are not introduced
    // \s mean one space
    String test = """
        i am test with \
        java 14\stest
        """;
    System.out.println(test);

    System.out.println("-------------------------------");

    Java14Record java14Record = new Java14Record("vincent", "aaabbcc");

    System.out.println(java14Record.name());
    System.out.println(java14Record.address());
    System.out.println(Java14Record.UNKNOW_ADDRESS);
  }
  public record Java14Record(String name, String address){

    public static String UNKNOW_ADDRESS = "unknown";
  }

  // record mean this
  final class JavaFinal{

    public static String UNKNOW_ADDRESS = "unknown";

    private final String name;
    private final String address;

    JavaFinal(String name, String address) {
      this.name = name;
      this.address = address;
    }

    // Override hashCode()、equals()、toString()

    // standard getters
  }
}
