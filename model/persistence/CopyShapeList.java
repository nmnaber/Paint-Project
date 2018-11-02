package model.persistence;

import main.Shape;

import java.util.ArrayList;

public class CopyShapeList {

    //list of shape objects

    private static CopyShapeList single_instance = null;

    private ArrayList<Shape> shapeList;

    private CopyShapeList() {

        shapeList = new ArrayList<>();

    }

    public static CopyShapeList getSelectedShapeList() {

        if (single_instance == null)
            single_instance = new CopyShapeList();

        return single_instance;

    }

    public boolean add(Shape shapetoAdd) {

        shapeList.add(shapetoAdd);

        return true;

    }

    public boolean deleteAll () {

        shapeList.clear();

        return true;
    }

    public boolean replaceArray(ArrayList<Shape> list) {

        shapeList = list;

        return true;
    }

    public ArrayList getArray() {

        return shapeList;
    }

}
