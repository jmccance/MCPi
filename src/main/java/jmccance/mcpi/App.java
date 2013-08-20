package jmccance.mcpi;

import jmccance.mcpi.model.PiFinder;

/**
 * Hello world!
 *
 */
public class App {

  public static void main(String... args) {
    final PiFinder finder = new PiFinder();

    int i = 1;
    while (Math.log10(i) < 9) {
      final double error = Math.abs(Math.PI - finder.getApprox());
      System.out.printf("%9d\t%1.8f\t%1.8f\n", i, finder.getApprox(), error);
      finder.refine();
      ++i;
    }
  }

}
