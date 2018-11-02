package model.persistence;

import main.Shape;

import java.util.ArrayList;

public class SelectedShapeList {

    //list of shape objects

    private static SelectedShapeList single_instance = null;

    private ArrayList<Shape> shapeList;

    private SelectedShapeList() {

        shapeList = new ArrayList<>();

    }

    public static SelectedShapeList getSelectedShapeList() {

        if (single_instance == null)
            single_instance = new SelectedShapeList();

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

}
