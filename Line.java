import java.awt.*;
public class Line extends Item {
  private Point point1;
  private Point point2;
  public Line(Point point1, Point point2) {
    this.point1 = point1;
    this.point2 = point2;
  }
  public Line(Point point1) {
    this.point1 = point1;
  }
  public Line() {
  }
  public boolean includes(Point point) {
    return ((distance(point, point1 ) < 10.0) || (distance(point, point2)< 10.0));
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
  public Point getPoint1() {
    return point1;
  }
  public Point getPoint2() {
    return point2;
  }
  public String toString() {
    return "Line  from " + point1 + " to " + point2;
  }

  public void move(Point first, Point second) {
       
      int x = point2.x - point1.x;
      int y = point2.y - point1.y;

      point1.x = second.x;
      point1.y = second.y;

      point2.x = second.x+x;
      point2.y =second.y +y;
  }

  public  void rotate(Point r){
    if(distance(r, point1 ) < 10.0)
    {
      int a = point2.x -point1.x;
      int b = point2.y -point1.y;

      int x =-b;
      int y = a;
      
      point2.x = x+point1.x;
      point2.y =y+point1.y;
    }
    else
    {
      int a = point1.x -point2.x;
      int b = point1.y -point2.y;

      int x =-b;
      int y = a;
      
      point1.x = x+point2.x;
      point1.y =y+point2.y;
    }
    System.out.println("We are on rotate line");


  }

  public boolean containsPoint(int x, int y){
    return true;
  }
}

