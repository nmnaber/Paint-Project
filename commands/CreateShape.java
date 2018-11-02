package commands;

import main.Command;
import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.persistence.ApplicationState;
import main.Shape;
import model.persistence.ShapeList;
import view.interfaces.IGuiWindow;
import main.CommandHistory;
import model.persistence.ShapeDrawer;


public class CreateShape implements Command {

    private Shape newShape;

    private ShapeList masterList;

    private ShapeDrawer shapeDrawer;

    public CreateShape (int StartPointX, int StartPointY, int EndPointX, int EndPointY, ApplicationState appState, IGuiWindow guiWindow) {

        newShape = new Shape(StartPointX, StartPointY, EndPointX, EndPointY, appState, guiWindow);

        ShapeList newList = ShapeList.getShapeList();

        newList.add(newShape);

        masterList = ShapeList.getShapeList();

        shapeDrawer = new ShapeDrawer();

    }

    @Override
    public void undo() {

        masterList.removeLastShape();

        shapeDrawer.DrawShapes();


    }

    @Override
    public void redo() {

        masterList.add(newShape);

        shapeDrawer.DrawShapes();


    }
}