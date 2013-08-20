package jmccance.mcpi;

import jmccance.mcpi.model.PiFinder;

/**
 * Hello world!
 *
 */
public class App {

  private static final String MODE_PROP = "mode";
  private static final String CONSOLE_MODE_STR = "console";
  private static final String SWING_MODE_STR = "swing";
  private static final String DEFAULT_MODE_STR = SWING_MODE_STR;

  private static enum AppMode {
    CONSOLE,
    SWING
  }

  public static void main(String... args) {
    switch (getAppMode()) {
      case CONSOLE:
        consoleApp();
        break;

      case SWING:
      default:
        swingApp();
    }
  }

  private static void consoleApp() {
    final PiFinder finder = new PiFinder();

    int i = 1;
    while (Math.log10(i) < 9) {
      final double error = Math.abs(Math.PI - finder.getApprox());
      System.out.printf("%9d\t%1.8f\t%1.8f\n", i, finder.getApprox(), error);
      finder.refine();
      ++i;
    }
  }

  private static void swingApp() {

  }

  private static AppMode getAppMode() {
    switch (System.getProperty(MODE_PROP, DEFAULT_MODE_STR)) {
      case CONSOLE_MODE_STR:
        return AppMode.CONSOLE;

      case SWING_MODE_STR:
      default:
        return AppMode.SWING;
    }
  }

}
