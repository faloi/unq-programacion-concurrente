package edu.unq.pconc.practica3;

import edu.unq.pconc.utils.Runner;

import java.util.concurrent.Semaphore;

import static edu.unq.pconc.utils.Utils.print;

public class Ejercicio7b {
  public static void main(String[] args) {
    Semaphore semA = new Semaphore(1);
    Semaphore semB = new Semaphore(0);

    new Runner(
      () -> {
        semA.acquireUninterruptibly();
        print("A");
        semB.release();
      },

      () -> {
        semB.acquireUninterruptibly();
        print("B");
        semA.release();
      }
    ).start();
  }

}
