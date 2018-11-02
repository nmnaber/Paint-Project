package model.persistence;

import main.Shape;
import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.interfaces.IApplicationState;
import view.interfaces.IGuiWindow;
import view.interfaces.IUiModule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShapeReconfig {

    private SelectedShapeList selectedShapeList;

    private ShapeType typeofShape;

    private ShapeColor primrarycolorofShape;
    private ShapeColor secondarycolorofShape;
    private ShapeShadingType shadingType;

    private IGuiWindow guiWindow;

    private IUiModule uiMod;

    private ApplicationState appState;

    private ArrayList<Shape> selectedShapeArray;

    private ShapeDrawer redrawShapes;

    private Shape infoPull;

    public ShapeReconfig() {

        selectedShapeList = SelectedShapeList.getSelectedShapeList();

        selectedShapeArray = selectedShapeList.getArray();

        if (!selectedShapeArray.isEmpty()) {
            infoPull = selectedShapeArray.get(0);
        }

        if (infoPull != null) {

            appState = infoPull.getAppState();


            typeofShape = appState.getActiveShapeType();
            primrarycolorofShape = appState.getActivePrimaryColor();
            secondarycolorofShape = appState.getActiveSecondaryColor();
            shadingType = appState.getActiveShapeShadingType();
        }
            redrawShapes = new ShapeDrawer();

    }

    public void UpdateShapeType() {


        for (Shape singleShape : selectedShapeArray) {
            singleShape.setShapeType(typeofShape);
        }

        redrawShapes.DrawShapes();

    }

    public void UpdatePrimraryShapeColor() {


        for (Shape singleShape : selectedShapeArray) {
            singleShape.setPrimraryShapeColor(primrarycolorofShape);
        }
        redrawShapes.DrawShapes();

    }

    public void UpdateSecondartShapeColor() {

        for (Shape singleShape : selectedShapeArray) {
            singleShape.setSecondaryShapeColor(secondarycolorofShape);
        }
        redrawShapes.DrawShapes();

    }

    public void UpdateShadingType() {

        for (Shape singleShape : selectedShapeArray) {
            singleShape.setShadingType(shadingType);
        }
        redrawShapes.DrawShapes();

    }
}


