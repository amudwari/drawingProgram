import java.awt.*;
import java.text.*;
public class QuadrilateralCommand extends Command {
  private Quadrilateral  quadrilateral;
  private int pointCount;
  public QuadrilateralCommand() {
   //this(null, null,null);
   quadrilateral = new Quadrilateral();
    //pointCount = 0;
  }
  public QuadrilateralCommand(Point point) {
    //this(point, null,null);
    quadrilateral = new Quadrilateral(point);

    pointCount = 1;
  }
  public QuadrilateralCommand(Point point1, Point point2,Point point3, Point point4) {
    //this(point1,point2,point3);
    quadrilateral= new Quadrilateral(point1,point2,point3, point4);
    
    pointCount = 4;

    
  }

  public void setQuadrilateralP(Point point){
    quadrilateral.setPoint1(point);
  }
  public void setQuadrilateralPoint1(Point point) {
    if (++pointCount == 1) {
      quadrilateral.setPoint1(point);
    } else if (pointCount == 2) {
      quadrilateral.setPoint2(point);
    }
  }

  public void setQuadrilateralPoint2(Point point){
    quadrilateral.setPoint3(point);
  }
  public void setQuadrilateralPoint3(Point point){
    quadrilateral.setPoint4(point);
  }
  public void execute() {
    model.addItem(quadrilateral);
  }
  public boolean undo() {
    model.removeItem(quadrilateral);
    return true;
  }
  public boolean redo() {
    execute();
    return true;
  }
  public boolean end() {
    if (quadrilateral.getPoint1() == null) {
      undo();
      return false;
    }
    if (quadrilateral.getPoint2() == null) {
      quadrilateral.setPoint2(quadrilateral.getPoint1());
    }
    return true;
  }
}
