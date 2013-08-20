package jmccance.mcpi.view;

import jmccance.mcpi.model.PiFinder;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Description.
 *
 * @author jmccance
 * @since 8/20/13
 */
public class MCPiWindow extends JFrame {

  private static final double FPS = 120;
  private final VisualizationPanel _visPanel;
  private final PiFinder _piFinder;

  public MCPiWindow(final PiFinder piFinder) {
    _visPanel = new VisualizationPanel(800);
    _piFinder = piFinder;

    this.setContentPane(_visPanel);
    this.pack();

    this.setTitle("MCPi");
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    // Locate the window in the middle of the screen.
    this.setLocationRelativeTo(null);
    // Resizing is not yet supported due to reasons.
    this.setResizable(false);

    final Timer timer = new Timer((int) Math.round(1000 / FPS),
        new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            _visPanel.addPoint(_piFinder.refine());
            _visPanel.setPi(_piFinder.getApprox());
            _visPanel.repaint();
          }
        });
    timer.start();
  }

}
