package org.example.javaversion;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Java10 {

  public static void main(String[] args) throws MalformedURLException {

    // var
    var id =0;
    var java9 = new Java9();
    var list = List.of("test1", "test2");
    var map = Map.of("key", "value");
    for (var s : list) {
      System.out.println(s);
    }

    System.out.println("-------------------------------");

    //  unmodifiable List
    List<String> list1 = List.copyOf(list);
    list.stream().collect(Collectors.toUnmodifiableList());
    list.stream().collect(Collectors.toUnmodifiableSet());
    list.stream().toList(); // performance good
  }
}
