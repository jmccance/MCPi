package jmccance.model;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Tests for TestPointProducer. Note that since this class generates random
 * values, there's a limit to how much we're going to be able to test with
 * absolute certainty.
 *
 * @author jmccance
 * @since 8/20/13
 */
public class TestPointProducer {

  @Test
  public void pointProducerShouldProducePointsWithinBounds() {
    final Point lowerLeftPt = new Point(-10.0, -10.0);
    final Point upperRightPt = new Point(10.0, 10.0);
    final PointProducer pp = new PointProducer(lowerLeftPt, upperRightPt);

    for (int i = 0; i < 100; ++i) {
      final Point pt = pp.next();
      assertTrue(
          pt.x >= lowerLeftPt.x && pt.x <= upperRightPt.x
              && pt.y >= lowerLeftPt.y && pt.y <= upperRightPt.y,
          "Generated point should be within bounds.");
    }
  }

}
