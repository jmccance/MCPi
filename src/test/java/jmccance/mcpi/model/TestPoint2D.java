package jmccance.mcpi.model;

import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

/**
 * Unit tests for Point2D.
 *
 * @author jmccance
 * @since 8/21/13
 */
public class TestPoint2D {

  @Test
  public void distanceFromSelfShouldBeZero() {
    final Point2D a = new Point2D(5, 5);

    assertThat(a.distanceFrom(a), is(equalTo(0.0)));
  }

  @Test
  public void distanceFromSamePointShouldBeZero() {
    final Point2D a = new Point2D(0, 0);
    final Point2D b = new Point2D(0, 0);

    assertThat(a.distanceFrom(b), is(equalTo(0.0)));
  }

  @Test
  public void distanceFromAToBShouldEqualDistanceFromBToA() {
    final Point2D a = new Point2D(3.0, 5.0);
    final Point2D b = new Point2D(-7.0, 9.0);

    assertThat(a.distanceFrom(b), is(equalTo(b.distanceFrom(a))));
  }

}
