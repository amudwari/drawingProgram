import java.io.*;
import java.awt.*;
public abstract class Item implements Serializable {
  protected static UIContext uiContext;
  public static void setUIContext(UIContext uiContext) {
    Item.uiContext = uiContext;
  }
  public abstract boolean includes(Point point);
  protected double distance(Point point1, Point point2) {
    double xDifference = point1.getX() - point2.getX();
    double yDifference = point1.getY() - point2.getY();
    return ((double) (Math.sqrt(xDifference * xDifference + yDifference * yDifference)));
  }

  public abstract void move(Point x, Point y);
  public abstract void rotate(Point x);

  public boolean containsPoint(int x, int y){
    return false;
  }

  public  void render() {
    uiContext.draw(this);
  }
}