package edu.unq.pconc.practica3;

import edu.unq.pconc.utils.Runner;

import java.util.concurrent.Semaphore;

import static edu.unq.pconc.utils.Utils.print;
import static edu.unq.pconc.utils.Utils.randomSleep;

public class Ejercicio2 {
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

}
