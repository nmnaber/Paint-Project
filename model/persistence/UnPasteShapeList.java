package model.persistence;

import main.Command;
import main.Shape;

import java.util.ArrayList;

public class UnPasteShapeList implements Command {

    //list of shape objects

    private static UnPasteShapeList single_instance = null;

    private ArrayList<Shape> shapeList;

    private ShapeList masterList;

    private ShapeDrawer reDraw;

    private UnPasteShapeList() {

        shapeList = new ArrayList<>();

        masterList = ShapeList.getShapeList();

        reDraw = new ShapeDrawer();

    }

    public static UnPasteShapeList getSelectedShapeList() {

        if (single_instance == null)
            single_instance = new UnPasteShapeList();

        return single_instance;

    }

    public boolean add(Shape shapetoAdd) {

        shapeList.add(shapetoAdd);

        return true;

    }

    public boolean replaceArray(ArrayList<Shape> list) {

        shapeList = list;

        return true;
    }

    public boolean deleteAll () {

        shapeList.clear();

        return true;
    }

    public ArrayList getArray() {

        return shapeList;
    }

    @Override
    public void undo() {
        //repopulate

        for (Shape addback : shapeList) {

            masterList.remove(addback);

        }

        reDraw.DrawShapes();
        
    }

    @Override
    public void redo() {

        for (Shape addback : shapeList) {


            masterList.add(addback);
        }

        reDraw.DrawShapes();

        shapeList.clear();



    }
}
