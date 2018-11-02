package main;

import model.ShapeColor;
import model.ShapeShadingType;
import model.persistence.ApplicationState;
import model.persistence.SelectedShapeList;
import model.persistence.ShapeList;
import view.interfaces.IGuiWindow;

import java.util.ArrayList;

import javafx.geometry.BoundingBox;

public class ShapeSelected {

    //passed in click data

    private int StartPointX;
    private int StartPointY;
    private int EndPointX;
    private int EndPointY;

    //data pulled from shape

    private int startX;
    private int endX;
    private int startY;
    private int endY;

    private ShapeColor primrarycolorofShape;
    private ShapeColor secondarycolorofShape;
    private ShapeShadingType shadingType;

    private IGuiWindow guiWindow;

    private ApplicationState appState;

    private Shape selectedShape;

    private ShapeList shapeList;

    private ArrayList<Shape> totalShapeArray;

    private ArrayList<Shape> selectedShapeArray;

    private SelectedShapeList selectedShapeList;

    private Boolean foundaShape;

    private BoundingBox boundingBox;

    public ShapeSelected(int StartPointX, int StartPointY, int EndPointX, int EndPointY, ApplicationState appState, IGuiWindow guiWindow) {

    this.StartPointX = StartPointX;
    this.EndPointX = EndPointX;
    this.StartPointY = StartPointY;
    this.EndPointY = EndPointY;

    ShapeList shapeList = ShapeList.getShapeList();

    SelectedShapeList selectedShapeList = SelectedShapeList.getSelectedShapeList();

    selectedShapeArray = selectedShapeList.getArray();

    totalShapeArray = shapeList.getArray();

    foundaShape = false;

    for (Shape currentShape : totalShapeArray) {

        startX = currentShape.getStartPointX();
        endX = currentShape.getEndPointX();
        startY = currentShape.getStartPointY();
        endY = currentShape.getEndPointY();

        if (StartPointX != EndPointX || StartPointY != EndPointY) {

        boundingBox = new BoundingBox(Math.min(StartPointX, EndPointX), Math.min(StartPointY,EndPointY), Math.abs(StartPointX-EndPointX), Math.abs(StartPointY-EndPointY));

            double doubleStartX = Double.valueOf(StartPointX);
            double doubleStartY = Double.valueOf(StartPointY);
            double doubleEndX = Double.valueOf(EndPointX);
            double doubleEndY = Double.valueOf(EndPointY);


        if (boundingBox.contains(Math.min(doubleStartX, doubleEndX), Math.min(doubleStartY,doubleEndY), Math.abs(doubleStartX-doubleEndX), Math.abs(doubleStartY-doubleEndY))
                && selectedShapeArray.contains(currentShape) != true)

            selectedShapeList.add(currentShape);

            foundaShape = true;

            int x = selectedShapeArray.size();

            System.out.printf("Length of selected list %d", x );
        }

        if (StartPointX >= startX && EndPointX <= endX && StartPointY >= startY && EndPointY <= endY && selectedShapeArray.contains(currentShape) != true) {

            selectedShapeList.add(currentShape);

            foundaShape = true;

            int x = selectedShapeArray.size();

            System.out.printf("Length of selected list %d", x );
        }

    }
        if ( foundaShape == false ) { //deselect all shapes

            selectedShapeArray.clear();
            int x = selectedShapeArray.size();

            System.out.printf("Length of selected list %d", x );
        }

    }


}
