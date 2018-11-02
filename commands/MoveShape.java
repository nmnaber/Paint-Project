package commands;

import main.Command;
import main.ShapeSelected;
import model.persistence.ApplicationState;
import view.interfaces.IGuiWindow;
import main.ShapeMover;

public class MoveShape {

    private ShapeMover theShapestoMove;

    public MoveShape(int StartPointX, int StartPointY, int EndPointX, int EndPointY, ApplicationState appState, IGuiWindow guiWindow) {

        theShapestoMove = new ShapeMover(StartPointX, StartPointY, EndPointX, EndPointY, appState, guiWindow);

    }


}
