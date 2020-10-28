
import java.awt.Point;

public class RotateCommand extends Command {

    private int pointCount;
    
    private int x = 0, y = 0;
    private Point point1;
    
    public RotateCommand() {
        point1 = new Point(0, 0);
    }
   
    
    public void setPoint1(Point point) {
        point1 = point;
        model.rotateSelectedItem(point1); 

    }
    
    
    public boolean undo() {
      // model.moveSelectedItems(-x, -y);
        return true;
    }

    public boolean redo() {
        execute();
        return true;
    }

    public void execute() {
       // model.moveSelectedItems(point1, point2);
    }

}
