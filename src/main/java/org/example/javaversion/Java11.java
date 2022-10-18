package org.example.javaversion;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Java11 {

  public static void main(String[] args) throws IOException, InterruptedException {

    // Http client
    var request = HttpRequest.newBuilder()
        .uri(URI.create("https://www.google.com"))
        .GET()
        .build();
    var client = HttpClient.newHttpClient();

    // sync
    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
    System.out.println(response.body());

    // async
    client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
        .thenApply(HttpResponse::body)
        .thenAccept(System.out::println);

    System.out.println("-------------------------------");

    // new String api
    System.out.println(" ".isBlank());
    // strip white space from the beginning and end of a string
    System.out.println(" Java　".strip());
    // strip white space from the beginning of a string
    System.out.println(" Java ".stripLeading());
    // strip white space from the end of a string
    System.out.println(" Java ".stripTrailing());
    // repeat
    System.out.println("java".repeat(3));
    // returns a stream of lines extracted from this string, separated by line terminators.
    System.out.println("A\nB\nC".lines().count());
    System.out.println("A\nB\nC".lines().collect(Collectors.toList()));

    System.out.println("-------------------------------");

    // Optional isEmpty()
    var op = Optional.empty();
    System.out.println(op.isEmpty());

    System.out.println("-------------------------------");

    // use var in lambda
    Consumer<String> consumer = (var i) -> System.out.println(i);
    Consumer<String> consumer1 = (String i) -> System.out.println(i);
  }
}
