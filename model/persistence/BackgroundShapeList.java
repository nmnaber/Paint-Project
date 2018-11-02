package model.persistence;

import main.Shape;

import java.util.ArrayList;

public class BackgroundShapeList {

    //list of shape objects

    private static BackgroundShapeList single_instance = null;

    private ArrayList<Shape> shapeList;

    private BackgroundShapeList() {

        shapeList = new ArrayList<>();

    }

    public static BackgroundShapeList getSelectedShapeList() {

        if (single_instance == null)
            single_instance = new BackgroundShapeList();

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
