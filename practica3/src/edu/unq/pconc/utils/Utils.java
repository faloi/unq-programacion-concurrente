package edu.unq.pconc.utils;

import java.util.Random;

public class Utils {
  public static void randomSleep() {
    try {
      if (new Random().nextBoolean())
        Thread.sleep(20);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

  public static void print(String value) {
    System.out.print(value);
  }
}
