package jmccance.mcpi.model;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * Unit tests for the PiFinder. Limited testability, since the Monte Carlo
 * approach does not have nice features like monotonic convergence.
 *
 * @author jmccance
 * @since 8/20/13
 */
public class TestPiFinder {

  /**
   * Because of how the Monte Carlo approach works, we can expect the first
   * approximation to be either 0.0 (if the first point lands outside the
   * circle) or 4.0 (if it lands inside the circle).
   *
   * <p>Note that this is a very "white box" test, and is susceptible to changes
   * in the implementation.</p>
   */
  @Test
  public void initialEstimateShouldBeFourOrZero() {
    final double piApprox = new PiFinder().getApprox();

    assertTrue(piApprox == 0.0 || piApprox == 4.0,
        "Initial approximation should either be 0.0 or 4.0; got: " + piApprox);
  }

  /**
   * A simple sanity test to check that the finder actually converges to a
   * reasonable approximation of pi. Experimentation has shown that trying to
   * test for a more accurate convergence results in the unit test taking
   * too long to run.
   */
  @Test
  public void shouldApproximatePiToTwoDecimals() {
    final PiFinder finder = new PiFinder();

    for (int i = 0; i < 10e4; ++i) {
      finder.refine();
    }

    final double est = finder.getApprox();
    assertTrue(Math.abs(Math.PI - finder.getApprox()) < 10e-2,
        "Expected pi to two decimals; got: " + est);
  }
}
