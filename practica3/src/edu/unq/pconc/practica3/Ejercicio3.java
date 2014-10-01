package edu.unq.pconc.practica3;

import edu.unq.pconc.utils.Runner;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Ejercicio3 {
  public static void main(String[] args) {
    Semaphore semC = new Semaphore(0);
    Semaphore semE = new Semaphore(0);
    Semaphore semR = new Semaphore(0);
    Semaphore semO = new Semaphore(0);

    new Runner(
      () -> {
        semC.acquireUninterruptibly();
        print("C");
        semR.release();
        semE.release();

        randomSleep();

        semE.acquireUninterruptibly();
        print("E");
        semO.release();
      },

      () -> {
        print("A");
        semC.release();

        semR.acquireUninterruptibly();
        print("R");
        semO.release();

        semO.acquireUninterruptibly(2);
        print("O");

        print("\n");
      }
    ).start();
  }

  private static void randomSleep() {
    try {
      if (new Random().nextBoolean())
        Thread.sleep(20);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

  private static void print(String value) {
    System.out.print(value);
  }
}
