import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class QuadrilateralButton  extends JButton implements ActionListener {
  protected JPanel drawingPanel;
  protected View view;
  private MouseHandler mouseHandler;
  private QuadrilateralCommand quadrilateralCommand;
  private UndoManager undoManager;
  public QuadrilateralButton(UndoManager undoManager, View jFrame, JPanel jPanel) {
    super("Quadrilateral");
    this.undoManager = undoManager;
    addActionListener(this);
    view = jFrame;
    drawingPanel = jPanel;
    mouseHandler = new MouseHandler();
  }
  public void actionPerformed(ActionEvent event) {
    view.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
    // Change cursor when button is clicked
    drawingPanel.addMouseListener(mouseHandler);
  // Start listening for mouseclicks on the drawing panel
  }
  private class MouseHandler extends MouseAdapter {
    private int pointCount = 0;
    public void mouseClicked(MouseEvent event) {
    if (++pointCount == 1) {
      quadrilateralCommand = new QuadrilateralCommand(View.mapPoint(event.getPoint()));
        undoManager.beginCommand(quadrilateralCommand);
    } else if (pointCount == 2) {
       
      quadrilateralCommand.setQuadrilateralPoint1(View.mapPoint(event.getPoint()));
        
      }
      else if (pointCount == 3) {
       
        quadrilateralCommand.setQuadrilateralPoint2(View.mapPoint(event.getPoint()));
          
        }
      else if (pointCount ==4){
            pointCount = 0;
            quadrilateralCommand.setQuadrilateralPoint2(View.mapPoint(event.getPoint()));
            drawingPanel.removeMouseListener(this);
            view.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            undoManager.endCommand(triangleCommand);
           

      }
    }
  }
}