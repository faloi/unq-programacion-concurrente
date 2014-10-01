package edu.unq.pconc.utils;

import java.util.Arrays;
import java.util.stream.Stream;

public class Runner {
  private final Stream<Thread> threads;

  public Runner(Runnable... runnables) {
    threads = Arrays.asList(runnables)
      .stream()
      .map(runnable -> new Thread() {
        public void run() {
          while (true) {
            runnable.run();
          }
        }
      });
  }

  public void start() {
    threads.forEach(Thread::start);
  }
}
