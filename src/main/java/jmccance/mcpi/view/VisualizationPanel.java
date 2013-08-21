package jmccance.mcpi.view;

import jmccance.mcpi.model.PiFinder;
import jmccance.mcpi.model.Point2D;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Renders points generated during the Monte Carlo &pi; approximation algorithm.
 *
 * <p>To avoid storing all of the generated points in memory and re-drawing them
 * with each iteration, we instead scribble them onto a buffer. Since we don't
 * really care about occlusion, we can safely splat each new point onto the
 * buffer and just draw the buffer whenever it's needed.</p>
 *
 * @author jmccance
 * @since 8/20/13
 */
public class VisualizationPanel extends JPanel {

  /** Color of points within the circle. */
  private static final Color CIRCLE_COLOR = Color.RED;

  /** Color of points without the circle. */
  private static final Color SQUARE_COLOR = Color.BLUE;

  /** The color of the "error" circle. */
  private static final Color ERROR_COLOR = new Color(
      CIRCLE_COLOR.getRed(),
      CIRCLE_COLOR.getGreen(),
      CIRCLE_COLOR.getBlue(),
      128
  );

  /** The area of the inscribed unit circle. Used to calculate the "error"
   * circle. */
  private static final double CIRCLE_AREA = 2.0 * Math.PI * 0.5 * 0.5;

  private final BufferedImage _buffer;
  private final int _sideLen;

  /** The current approximation of pi. */
  private double _pi = 0.0;

  public VisualizationPanel(final int sideLen) {
    _sideLen = sideLen;
    this.setPreferredSize(new Dimension(_sideLen, _sideLen));

    _buffer = initBuffer(_sideLen);
  }

  @Override
  public void paintComponent(final Graphics g) {
    super.paintComponent(g);

    // Render the points generated thus far.
    g.drawImage(_buffer, 0, 0, null);

    // Render the circle generated by the current estimate of pi.
    final double radius = _sideLen *  Math.sqrt(CIRCLE_AREA / (2.0 * _pi));
    g.setColor(ERROR_COLOR);
    ((Graphics2D) g).setStroke(new BasicStroke(3));
    g.drawOval(
        (int) (_sideLen / 2 - radius),
        (int) (_sideLen / 2 - radius),
        (int) (2 * radius),
        (int) (2 * radius));

    // Render the real circle
    g.setColor(Color.WHITE);
    ((Graphics2D) g).setStroke(new BasicStroke(1));
    g.drawOval(0, 0, _sideLen, _sideLen);

    // Render the current estimate.
    g.drawString(String.format("%1.8f", _pi), _sideLen / 2, _sideLen / 2);
  }

  /**
   * Draws a new point from the MC generator onto the visualizer. The generator
   * is responsible for informing the visualization pattern as to whether or not
   * the point in question is in the unit circle or not. The visualizer, on the
   * other hand, is responsible for converting the model point into a screen
   * point.
   *
   * <p>If the point is in the unit circle, the visualization panel represents
   * that by coloring it differently.</p>
   *
   * @param piPt a point from the model
   */
  public void addPoint(final PiFinder.PiPoint piPt) {
    final Point point = point2DToPoint(piPt);
    final Color ptColor = piPt.isInCircle ? CIRCLE_COLOR : SQUARE_COLOR;

    _buffer.setRGB(point.x, point.y, ptColor.getRGB());
  }

  public void setPi(double pi) {
    _pi = pi;
  }

  private static BufferedImage initBuffer(final int sideLen) {
    final BufferedImage buffer =
        new BufferedImage(sideLen, sideLen, BufferedImage.TYPE_INT_ARGB);

    final Graphics g = buffer.getGraphics();
    g.setColor(Color.BLACK);
    g.fillRect(0, 0, sideLen, sideLen);

    return buffer;
  }

  private Point point2DToPoint(final Point2D point2d) {
    final Point point = new Point();
    point.x = (int) (_sideLen * point2d.x + _sideLen / 2);
    point.y = (int) (_sideLen / 2 - (point2d.y * _sideLen));

    return point;
  }

}
