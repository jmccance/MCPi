package jmccance.mcpi.model;

/**
 * Generates an iterative, Monte Carlo approximation of pi.
 *
 * @author jmccance
 * @since 8/20/13
 */
public class PiFinder {

  /** The radius of the unit circle. */
  private static final double R = 0.5;

  private static final Point2D ORIGIN = new Point2D(0, 0);

  public static class PiPoint extends Point2D {
    public final boolean isInCircle;

    public PiPoint(final double x, final double y, final boolean isInCircle) {
      super(x, y);
      this.isInCircle = isInCircle;
    }
  }

  private long _squarePtCt = 0;
  private long _circlePtCt = 0;

  private final PointProducer _ptProducer = new PointProducer(
      new Point2D(-R, -R), new Point2D(R, R)
  );

  public PiFinder() {
    this.refine();
  }

  public PiPoint refine() {
    final Point2D pt = _ptProducer.next();

    // Every point is in the square, by definition.
    _squarePtCt++;

    final PiPoint piPt = new PiPoint(pt.x, pt.y, isInCircle(pt));
    if (piPt.isInCircle) _circlePtCt++;

    return piPt;
  }

  public double getApprox() {
    return 4.0 * _circlePtCt / _squarePtCt;
  }

  private static boolean isInCircle(final Point2D pt) {
    return pt.distanceFrom(ORIGIN) <= R;
  }

}
