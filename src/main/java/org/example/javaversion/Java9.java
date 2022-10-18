package org.example.javaversion;

import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Stream;

public class Java9 implements Java9Interface {

  public static void main(String[] args) {

    // List.of(), Set.of(), Map.of()
    List<String> list = List.of("test1", "test2", "test3");
    System.out.println(list);
    Set<String> set = Set.of("test1", "test2");
    System.out.println(set);
    Map<String, Integer> map = Map.of("test1", 1, "test2", 2);
    System.out.println(map);

    System.out.println("-------------------------------");

    // allow create null stream
    Stream<String> stringStream = Stream.ofNullable("java");
    System.out.println(stringStream.count());
    Stream<String> nullStream = Stream.ofNullable(null);
    System.out.println(nullStream.count());

    System.out.println("-------------------------------");

    // takeWhile()
    List<Integer> integerList = List.of(11, 22, 33, 44, 55, 66);
    integerList.stream().takeWhile(i -> i < 50).forEach(System.out::println);

    System.out.println("-------------------------------");

    // dropWhile()
    List<Integer> integerList2 = List.of(11, 22, 33, 44, 55, 66);
    integerList2.stream().dropWhile(x -> x < 50).forEach(System.out::println);

    System.out.println("-------------------------------");

    // original iterate()
    Stream.iterate(1, i -> i + 1).limit(5).forEach(System.out::println);
    // new iterate()
    Stream.iterate(1, i -> i <= 5, i -> i + 1).forEach(System.out::println);

    System.out.println("-------------------------------");

    // ifPresentOrElse() empty use first, notEmpty use second
    Optional<Object> objectOptional = Optional.empty();
    objectOptional.ifPresentOrElse(System.out::println, () -> System.out.println("Empty!!!"));

    // or() empty use this supplier
    Optional<Object> objectOptional1 = Optional.empty();
    objectOptional1.or(() -> Optional.of("java")).ifPresent(System.out::println);

    System.out.println("-------------------------------");

    // get jvm process
    ProcessHandle currentProcess = ProcessHandle.current();
    System.out.println(currentProcess.pid());
    System.out.println(currentProcess.info());

    System.out.println("-------------------------------");

    // Java 9 can use effectively-final
    try (final Scanner scanner = new Scanner(System.in);
        PrintWriter writer = new PrintWriter(Writer.nullWriter())) {
      // omitted
    }
  }

  @Override
  public void needOverride() {
    // Private methods do not need to be overridden
  }
}
