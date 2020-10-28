import java.text.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import javax.swing.*;
import java.util.*;
public class Model {
  private Vector itemList;
  private Vector selectedList;
  //  list of "currently selected" items
  private static UIContext uiContext;
  private static View view;
  public Model() {
    itemList = new Vector();
    selectedList = new Vector();
  }
  public static void setUI(UIContext uiContext) {
    Model.uiContext = uiContext;
    Item.setUIContext(uiContext);
  }
  public static void setView(View view) {
    Model.view = view;
  }
  public void markSelected(Item item) {
// marks an item as selected by moving it to the
// selceted list.
    if (itemList.contains(item)) {
      itemList.remove(item);
      selectedList.add(item);
      view.refresh();
    }
  }
  public void unSelect(Item item) {
    if (selectedList.contains(item)) {
      selectedList.remove(item);
      itemList.add(item);
      view.refresh();
    }
  }

  public void deleteSelectedItems() {
    selectedList.removeAllElements();
    view.refresh();
  }
  public void addItem(Item item) {
    itemList.add(item);
    view.refresh();
  }
  public void removeItem(Item item) {
    itemList.remove(item);
    view.refresh();
  }
  public Enumeration getItems() {
    return itemList.elements();
  }
  public void setChanged() {
    view.refresh();
  }
  public Enumeration getSelectedItems() {
    return selectedList.elements();
  }


  public void moveSelectedItems(Point point1, Point point2) {    
    Enumeration enumeration = itemList.elements();
    while (enumeration.hasMoreElements()) {
        Item item = (Item) (enumeration.nextElement());
        if (item.includes(point1) && point2 != null)
        {
          //int x = point2.x - point1.x;
          //int y = point2.y - point1.y;
          item.move(point1, point2);
        }
        
    }
    
    view.refresh();
}

public void rotateSelectedItem(Point point1){
  Enumeration enumeration = itemList.elements();
    while (enumeration.hasMoreElements()) {
        Item item = (Item) (enumeration.nextElement());
        if (item.includes(point1))
        {
          //int x = point2.x - point1.x;
          //int y = point2.y - point1.y;
          item.rotate(point1);
        }
        
    }
    
    view.refresh();

}
  // other fields, methods and classes
  public void save(String fileName) {
    try {
      FileOutputStream file = new FileOutputStream(fileName);
      ObjectOutputStream output = new ObjectOutputStream(file);
      output.writeObject(itemList);
      output.writeObject(selectedList);
    } catch(IOException ioe) {
      ioe.printStackTrace();
    }
  }

  public void retrieve(String fileName) {
    try {
      FileInputStream file = new FileInputStream(fileName);
      ObjectInputStream input = new ObjectInputStream(file);
      itemList = (Vector) input.readObject();
      selectedList = (Vector) input.readObject();
      Item.setUIContext(uiContext);
      view.refresh();
    } catch(IOException ioe) {
      ioe.printStackTrace();
    } catch(ClassNotFoundException cnfe) {
      cnfe.printStackTrace();
    }
  }
}
