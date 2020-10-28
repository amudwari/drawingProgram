import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class RotateButton extends JButton implements ActionListener {

    private final UndoManager undoManager;  
    private MouseHandler mouseHandler;
    private RotateCommand rotateCommand;
    private JPanel drawingPanel;
    protected View view;
    
    public RotateButton(UndoManager undoManager,View jFrame, JPanel drawingPanel) {
        super("Rotate");
        this.undoManager = undoManager;
        this.drawingPanel = drawingPanel;
        view = jFrame;
        addActionListener(this);
        mouseHandler = new MouseHandler();
    }
    
    public void actionPerformed(ActionEvent e) {
        view.setCursor(new Cursor(Cursor.HAND_CURSOR));
        drawingPanel.addMouseListener(mouseHandler);

    }
    
    private class MouseHandler extends MouseAdapter {
        
        private int pointCount = 0;
        
        public void mouseClicked(MouseEvent event) {
            if (++pointCount == 1) {
                rotateCommand = new RotateCommand();
                rotateCommand.setPoint1(View.mapPoint(event.getPoint()));
                undoManager.beginCommand(rotateCommand);
            } else if (pointCount == 2) {
                drawingPanel.removeMouseListener(this);
                pointCount = 0;
                view.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                undoManager.endCommand(rotateCommand);
            }
        }
    }

}
