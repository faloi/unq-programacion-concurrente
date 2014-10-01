package edu.unq.pconc;

public class Main {
  public static void main(String[] args) {
    new Runner(
      () -> {
        print("C");
        print("E");
      },

      () -> {
        print("A");
        print("R");
        print("O");
      }
    ).start();
  }

  private static void print(String value) {
    System.out.print(value);
  }
}
