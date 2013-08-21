package jmccance.mcpi.model;

/**
 * Stores a two-dimensional, real-valued point in space. Immutable.
 *
 * @author jmccance
 * @since 8/20/13
 */
public class Point2D {

  public final double x, y;

  public Point2D(final double x, final double y) {
    this.x = x;
    this.y = y;
  }

  public double distanceFrom(final Point2D point) {
    final double dx = this.x - point.x;
    final double dy = this.y - point.y;

    return Math.abs(Math.sqrt(dx * dx + dy * dy));
  }

}
