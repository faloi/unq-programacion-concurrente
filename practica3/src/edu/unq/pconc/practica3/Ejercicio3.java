package edu.unq.pconc.practica3;

import edu.unq.pconc.utils.Runner;

import java.util.concurrent.Semaphore;

import static edu.unq.pconc.utils.Utils.print;

public class Ejercicio3 {
  public static void main(String[] args) {
    Semaphore semR = new Semaphore(1);
    Semaphore semI = new Semaphore(0);
    Semaphore semO = new Semaphore(0);
    Semaphore semOk1 = new Semaphore(0);
    Semaphore semOk2 = new Semaphore(0);

    new Runner(
      () -> {
        semR.acquireUninterruptibly();
        print("R ");
        semI.release();

        semOk1.acquireUninterruptibly();
        print("OK ");
        semOk2.release();
      },

      () -> {
        semI.acquireUninterruptibly();
        print("I ");
        semO.release();

        semOk2.acquireUninterruptibly();
        print("OK ");
        print("\n");
        semR.release();
      },

      () -> {
        semO.acquireUninterruptibly();
        print("O ");

        print("OK ");
        semOk1.release();
      }
    ).start();
  }

}
