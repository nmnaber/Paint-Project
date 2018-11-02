package main;

import model.persistence.ApplicationState;
import model.persistence.SelectedShapeList;
import model.persistence.ShapeDrawer;
import view.interfaces.IGuiWindow;

import java.util.ArrayList;

public class ShapeMover {

    private ArrayList<Shape> selectedShapeArray;

    private SelectedShapeList selectedShapeList;

    private int StartPointX;
    private int StartPointY;
    private int EndPointX;
    private int EndPointY;

    private int ShapeStartX;
    private int ShapeStartY;
    private int ShapeEndX;
    private int ShapeEndY;

    private int deltaX;
    private int deltaY;

    ShapeDrawer redrawShapes;

    public ShapeMover(int StartPointX, int StartPointY, int EndPointX, int EndPointY, ApplicationState appState, IGuiWindow guiWindow) {

        SelectedShapeList selectedShapeList = SelectedShapeList.getSelectedShapeList();

        selectedShapeArray = selectedShapeList.getArray();

        this.StartPointX = StartPointX;
        this.EndPointX = EndPointX;
        this.StartPointY = StartPointY;
        this.EndPointY = EndPointY;

        redrawShapes = new ShapeDrawer();

        MoveShapes();

    }

    public void MoveShapes() {

        for (Shape shapetoMove : selectedShapeArray) {

            ShapeStartX = shapetoMove.getStartPointX();
            ShapeStartY = shapetoMove.getStartPointY();
            ShapeEndX = shapetoMove.getEndPointX();
            ShapeEndY = shapetoMove.getEndPointY();

            deltaX = (ShapeEndX-ShapeStartX);
            deltaY = (ShapeEndY-ShapeStartY);

            shapetoMove.setStartPointX( Math.abs(EndPointX) );
            shapetoMove.setStartPointY( Math.abs(EndPointY) ) ;

            shapetoMove.setEndPointX(EndPointX+deltaX);
            shapetoMove.setEndPointY(EndPointY+deltaY);


            //shapetoMove.setStartPointX();
            //shapetoMove.setStartPointY();
        }

        redrawShapes.DrawShapes();

    }


}
