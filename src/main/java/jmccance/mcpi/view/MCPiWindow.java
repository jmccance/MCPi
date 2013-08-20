package jmccance.mcpi.view;

import javax.swing.*;

/**
 * Description.
 *
 * @author jmccance
 * @since 8/20/13
 */
public class MCPiWindow extends JFrame {

  public MCPiWindow() {
    final MCPanel content = new MCPanel();
    this.setContentPane(content);
    this.pack();

    this.setTitle("MCPi");
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    // Locate the window in the middle of the screen.
    this.setLocationRelativeTo(null);
    // Resizing is not yet supported due to reasons.
    this.setResizable(false);
  }

}
