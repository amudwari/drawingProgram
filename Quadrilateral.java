import java.awt.*;
public class Quadrilateral extends Item {
  private Point point1;
  private Point point2;
  private Point point3;
  private Point point4;

  public Quadrilateral(Point point1 ,Point point2 ,Point point3,Point point4){
      this.point1 = point1;
      this.point2 =point2;
      this.point3 =point3;
      this.point3 =point4;
  }
  public Quadrilateral(Point point1, Point point2) {
    this.point1 = point1;
    this.point2 = point2;
  }
  public Quadrilateral(Point point1) {
    this.point1 = point1;
  }
  public Quadrilateral() {
  }
  public boolean includes(Point point) {
    return ((distance(point, point1 ) < 10.0) || (distance(point, point2)< 10.0)
         ||(distance(point, point3)< 10.0)  || (distance(point, point4)< 10.0));
    
  }
  public void render() {
    uiContext.draw(this);
  }
  public void setPoint1(Point point) {
    point1 = point;
  }
  public void setPoint2(Point point) {
    point2 = point;
  }

  public void setPoint3(Point point){
      point3 = point;
  }
  public void setPoint3(Point point){
    point4 = point;
  }
  public Point getPoint1() {
    return point1;
  }
  public Point getPoint2() {
    return point2;
  }

  public Point getPoint3(){
      return point3;
  }
  public Point getPoint4(){
    return point4;
}
  public String toString() {
    return "Line  from " + point1 + " to " + point2 +"to " +point3;
  }

  @Override
  public void move(Point first, Point second) {

      int x = point2.x - point1.x;
      int y = point2.y - point1.y;

      int a = point3.x -point1.x;
      int b = point3.y-point1.y;

      point1.x = second.x;
      point1.y = second.y;

      point2.x = second.x+x;
      point2.y =second.y +y;

      point3.x =second.x+a;
      point3.y=second.y+b;
   
  }


  public boolean containsPoint(int x, int y){
    return true;
  }
}

