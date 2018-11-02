package main;

import commands.CreateShape;
import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.persistence.ApplicationState;
import view.interfaces.IGuiWindow;

public class Shape {

    private int StartPointX; private int StartPointY;
    private int EndPointX; private int EndPointY;

    private ApplicationState appState;
    private IGuiWindow guiWindow;

    private ShapeType typeofShape;
    private ShapeColor primrarycolorofShape;
    private ShapeColor secondarycolorofShape;
    private ShapeShadingType shadingType;

    public Shape (int StartX, int StartY, int EndX, int EndY, ApplicationState appState, IGuiWindow guiWindow) {

        StartPointX = StartX;
        StartPointY = StartY;
        EndPointX = EndX;
        EndPointY = EndY;

        typeofShape = appState.getActiveShapeType();

        primrarycolorofShape = appState.getActivePrimaryColor();

        secondarycolorofShape = appState.getActiveSecondaryColor();

        shadingType = appState.getActiveShapeShadingType();

        this.guiWindow = guiWindow;

        this.appState = appState;

    }

    public IGuiWindow getGUIwindow () { return guiWindow;}

    public ApplicationState getAppState () {return appState;}

    public void setStartPointX (int StartX) {
        StartPointX = StartX;
    }

    public void setStartPointY (int StartY) {
        StartPointY = StartY;
    }

    public void setEndPointX (int EndX) {
        EndPointX = EndX;
    }

    public void setEndPointY (int EndY) {
        EndPointY = EndY;
    }

    public void setShapeType (ShapeType tShape) {
        typeofShape = tShape;
    }

    public void setPrimraryShapeColor (ShapeColor pcShape ) {
        primrarycolorofShape = pcShape;
    }

    public void setSecondaryShapeColor (ShapeColor scShape ) {
        secondarycolorofShape = scShape;
    }

    public void setShadingType (ShapeShadingType stShape ) {
        shadingType = stShape;
    }

    public int getStartPointX() { return StartPointX; }

    public int getStartPointY() { return StartPointY; }

    public int getEndPointX() { return EndPointX; }

    public int getEndPointY() { return EndPointY; }

    public ShapeType getShapeType() { return typeofShape; }

    public ShapeColor getPrimraryShapeColor() { return primrarycolorofShape; }

    public ShapeColor getSecondaryShapeColor() { return secondarycolorofShape; }

    public ShapeShadingType getShadingType() { return shadingType; }


}
