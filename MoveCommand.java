
import java.awt.Point;

public class MoveCommand extends Command {

    private int pointCount;
    
    private int x = 0, y = 0;
    private Point point1, point2;
    
    public MoveCommand() {
        point1 = new Point(0, 0);
        point2 = new Point(0, 0);
    }
   
    
    public void setPoint1(Point point) {
        point1 = point;
    }
    
    public void setPoint2(Point point) {
        point2 = point;
       // x = point2.x - point1.x;
       // y = point2.y - point1.y;
       // model.moveSelectedItems(x, y); 
       model.moveSelectedItems(point1, point2); 
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
