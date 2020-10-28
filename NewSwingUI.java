import java.awt.Graphics;
public class NewSwingUI implements UIContext {
  private Graphics graphics;
  private static NewSwingUI swingUI;
  private NewSwingUI() {
  }
  public static NewSwingUI getInstance() {
    if (swingUI == null) {
      swingUI = new NewSwingUI();
    }
    return swingUI;
  }
  public  void setGraphics(Graphics graphics) {
    this.graphics = graphics;
  }
  public void draw(Label label) {
    if (label.getStartingPoint() != null) {
      if (label.getText() != null) {
        graphics.drawString(label.getText(), (int) label.getStartingPoint().getX(), (int) label.getStartingPoint().getY());
      }
    }
    int length = graphics.getFontMetrics().stringWidth(label.getText());
    graphics.drawString("_", (int) label.getStartingPoint().getX() + length, (int) label.getStartingPoint().getY());
  }
  public void draw(Line line) {
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    int i4 = 0;
    if (line.getPoint1() != null) {
      i1 = Math.round((float) (line.getPoint1().getX()));
      i2 = Math.round((float) (line.getPoint1().getY()));
      if (line.getPoint2() != null) {
        i3 = Math.round((float) (line.getPoint2().getX()));
        i4 = Math.round((float) (line.getPoint2().getY()));
      } else {
        i3 = i1;
        i4 = i2;
      }
      graphics.drawLine(i1, i2, i3, i4);
    }
  }

  public void draw(Quadrilateral quadrilateral ){
    int i1 =0;
    int i2=0;
    int j1 =0;
    int j2 =0;
    int k1=0;
    int k2 =0;
    int l1=0;
    int l2 =0;
    if (triangle.getPoint1() != null){
      i1 = Math.round((float) (triangle.getPoint1().getX()));
      i2 = Math.round((float) (triangle.getPoint1().getY()));
    }
    if (triangle.getPoint2() != null){
      j1 = Math.round((float) (triangle.getPoint2().getX()));
      j2 = Math.round((float) (triangle.getPoint2().getY()));
    }

    if (triangle.getPoint3() != null){
      k1 = Math.round((float) (triangle.getPoint3().getX()));
      k2 = Math.round((float) (triangle.getPoint3().getY()));

      if (triangle.getPoint4() != null){
        k1 = Math.round((float) (triangle.getPoint3().getX()));
        k2 = Math.round((float) (triangle.getPoint3().getY()));
      graphics.drawLine(i1, i2, j1, j2);
      graphics.drawLine(j1, j2, k1, k2);
      graphics.drawLine(k1, k2, l1, l2);
      graphics.drawLine(l1, l2, i1, i2);
    }

    








  }
  public void draw(Item item) {
    System.out.println( "Cant draw unknown Item \n");
  }
}