import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class MoveButton extends JButton implements ActionListener {

    private final UndoManager undoManager;  
    private MouseHandler mouseHandler;
    private MoveCommand moveCommand;
    private JPanel drawingPanel;
    protected View view;
    
    public MoveButton(UndoManager undoManager,View jFrame, JPanel drawingPanel) {
        super("Move");
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
                moveCommand = new MoveCommand();
                moveCommand.setPoint1(View.mapPoint(event.getPoint()));
                undoManager.beginCommand(moveCommand);
            } else if (pointCount == 2) {
                moveCommand.setPoint2(View.mapPoint(event.getPoint()));                
                drawingPanel.removeMouseListener(this);
                pointCount = 0;
                view.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

                undoManager.endCommand(moveCommand);
            }
        }
    }

}
