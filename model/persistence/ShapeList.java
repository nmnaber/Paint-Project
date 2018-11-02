package model.persistence;
import main.Command;
import main.Shape;
import java.util.ArrayList;

public class ShapeList implements Command {

    //list of shape objects

    private static ShapeList single_instance = null;

    private ArrayList<Shape> shapeList;

    private ShapeList() {

        shapeList = new ArrayList<>();

    }

    public static ShapeList getShapeList() {

        if (single_instance == null)
            single_instance = new ShapeList();

        return single_instance;

    }

    public boolean add(Shape shapetoAdd) {

        shapeList.add(shapetoAdd);

        ShapeDrawer newShape = new ShapeDrawer();

        newShape.DrawShapes();

        return true;

    }

    public boolean replaceArray(ArrayList<Shape> list) {

        shapeList = list;

        return true;
    }

    public ArrayList getArray() {

        return shapeList;
    }

    public void removeLastShape(){

        if (!shapeList.isEmpty()) {

            shapeList.remove(shapeList.size() - 1);
        }

        else {

            System.out.println("No shapes to remove");
        }
    }

    public void remove(Shape shapetoRemove) {

        shapeList.remove(shapetoRemove);
    }

    @Override
    public void undo() {



    }

    @Override
    public void redo() {

    }
}
