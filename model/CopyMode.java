package model;

import model.persistence.CopyShapeList;
import model.persistence.SelectedShapeList;
import main.Shape;

import java.util.ArrayList;

public class CopyMode {

    private SelectedShapeList selectedShapeList;

    private ArrayList<Shape> selectedArray;

    private CopyShapeList copyShapeList;

    private ArrayList<Shape> copyArray;


    public CopyMode () {

        selectedShapeList = SelectedShapeList.getSelectedShapeList();

        copyShapeList = CopyShapeList.getSelectedShapeList();

        selectedArray = selectedShapeList.getArray();

        copyArray = copyShapeList.getArray();

    }

    public void SelectedtoCopyArray() {

        copyArray = selectedArray;

        copyShapeList.replaceArray(copyArray);

        //System.out.println("THIS IS COPY MODE WHOA");


    }
}
