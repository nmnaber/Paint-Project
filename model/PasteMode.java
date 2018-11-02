package model;


import main.CommandHistory;
import main.Shape;

import model.persistence.*;
import view.interfaces.IGuiWindow;
import view.interfaces.IUiModule;

import java.util.ArrayList;


public class PasteMode {

    private int StartPointX; private int StartPointY;
    private int EndPointX; private int EndPointY;
    private int Width; private int Height;

    private ShapeColor primrarycolorofShape;
    private ShapeColor secondarycolorofShape;
    private ShapeShadingType shadingType;

    private IGuiWindow guiWindow;

    private ApplicationState appState;

    private ShapeList masterList;

    private CopyShapeList copyList;

    private ArrayList<Shape> shapeArray;

    private ArrayList<Shape> copyArray;

    private ShapeDrawer pasteDraw;

    private UnPasteShapeList unPasteShapeList;


    public PasteMode() {



    }

    public void PasteListDraw() {

        pasteDraw.DrawShapes();


    }

    public void copyShapestoShapeList() {

        masterList = ShapeList.getShapeList();

        copyList = CopyShapeList.getSelectedShapeList();

        shapeArray = masterList.getArray();

        copyArray = copyList.getArray();

        pasteDraw = new ShapeDrawer();

        unPasteShapeList = UnPasteShapeList.getSelectedShapeList();

        for (Shape copyshape : copyArray) {

            StartPointX =  copyshape.getStartPointX();
            StartPointY = copyshape.getStartPointY();
            EndPointX = copyshape.getEndPointX();
            EndPointY = copyshape.getEndPointY();
            guiWindow = copyshape.getGUIwindow();
            primrarycolorofShape = copyshape.getPrimraryShapeColor();
            secondarycolorofShape = copyshape.getSecondaryShapeColor();
            shadingType = copyshape.getShadingType();
            appState = copyshape.getAppState();

            Shape copyofShape = new Shape(StartPointX, StartPointY, EndPointX, EndPointY, appState, guiWindow);

            int startX = copyshape.getStartPointX();
            int endX = copyshape.getEndPointX();

            copyofShape.setStartPointX(startX + 50);
            copyofShape.setEndPointX(endX + 50);

            masterList.add(copyofShape);

            unPasteShapeList.add(copyofShape);

            CommandHistory.add(unPasteShapeList);
        }

        PasteListDraw();

    }
}
