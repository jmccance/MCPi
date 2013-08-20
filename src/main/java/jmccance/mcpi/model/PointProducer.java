package jmccance.mcpi.model;

import java.security.SecureRandom;

/**
 * PointerProducer generates a stream of floating-point points within a
 * rectangular bound.
 *
 * @author jmccance
 * @since 8/20/13
 */
public class PointProducer {
  // We may want to turn this into an interface or abstract class and allow
  // injection of the random number generator.

  // We may also want to implement Iterator or Iterable, since that's basically
  // what this is and that might allow some nice tricks.

  private final Point _lowerLeftPt;
  private final Point _upperRightPt;

  private final SecureRandom _gen = new SecureRandom();

  /**
   * Initialize a new PointProducer that will produce points within the
   * rectangle described by the lower-left point and the upper-right point.
   *
   * @param lowerLeftPt the lower-left bound
   * @param upperRightPt the upper-right bound
   */
  public PointProducer(final Point lowerLeftPt, final Point upperRightPt) {
    _lowerLeftPt = lowerLeftPt;
    _upperRightPt = upperRightPt;
  }

  /**
   * @return a random
   */
  public Point next() {
    return new Point(this.getRandomXCoord(), this.getRandomYCoord());
  }

  private double getRandomXCoord() {
    return this.getDoubleInBounds(_lowerLeftPt.x, _upperRightPt.x);
  }

  private double getRandomYCoord() {
    return this.getDoubleInBounds(_lowerLeftPt.y, _upperRightPt.y);
  }

  private double getDoubleInBounds(final double min, final double max) {
    return _gen.nextDouble() * (max - min) + min;
  }
}
