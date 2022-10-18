package org.example.javaversion;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.NumberFormat;
import java.text.NumberFormat.Style;
import java.util.Locale;

public class Java12 {

  public static void main(String[] args) throws IOException {

    String test = "java";
    System.out.println(test.indent(4));
    System.out.println(test.indent(-10));

    System.out.println("-------------------------------");

    String result = "foo".transform(input -> input + " bar");
    System.out.println(result);

    System.out.println("-------------------------------");

    Path filePath1 = Files.createTempFile("file1", ".txt");
    Path filePath2 = Files.createTempFile("file2", ".txt");
    Files.writeString(filePath1, "Java 12");
    Files.writeString(filePath2, "Java 12");
    // all match return -1L, else return different word
    long mismatch = Files.mismatch(filePath1, filePath2);
    System.out.println(mismatch);

    System.out.println("-------------------------------");

    // NumberFormat getCompactNumberInstance()
    NumberFormat fmt = NumberFormat.getCompactNumberInstance(Locale.US, Style.SHORT);
    System.out.println(fmt.format(1000));

    System.out.println("-------------------------------");

    String test1 = "test";
    switch (test1) {
      case "t", "te" -> System.out.println("NO");
      case "test" -> System.out.println("OK");
    }

    System.out.println("-------------------------------");

    // before
    Object obj = "i am string";
    if (obj instanceof String) {
      String str = (String) obj;
      System.out.println(str);
    }

    // java 12
    Object obj1 = "i am string";
    if (obj1 instanceof String str) {
      System.out.println(str);
    }

    System.out.println("-------------------------------");

    String json = "{\n" +
        "   \"name\":\"vincent\",\n" +
        "   \"age\":18\n" +
        "}\n";

    String java12NewJson = """
            {
              "name":"vincent",
              "age":18
            }
        """;

    System.out.println(json);
    System.out.println(java12NewJson);
  }
}
