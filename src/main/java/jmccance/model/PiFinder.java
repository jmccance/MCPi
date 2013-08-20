package jmccance.model;

/**
 * Generates an iterative, Monte Carlo approximation of pi.
 *
 * @author jmccance
 * @since 8/20/13
 */
public class PiFinder {

  /** The radius of the unit circle. */
  private static final double R = 0.5;

  private long _squarePtCt = 0;
  private long _circlePtCt = 0;

  private final PointProducer _ptProducer = new PointProducer(
      new Point(-R, -R), new Point(R, R)
  );

  public PiFinder() {
    this.refine();
  }

  public void refine() {
    final Point pt = _ptProducer.next();

    // Every point is in the square, by definition.
    _squarePtCt++;

    if (isInCircle(pt)) {
      _circlePtCt++;
    }
  }

  public double getApprox() {
    return 4.0 * _circlePtCt / _squarePtCt;
  }

  private static boolean isInCircle(final Point pt) {
    return Math.sqrt(pt.x * pt.x + pt.y * pt.y) <= R;
  }

}
