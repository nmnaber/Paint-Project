package commands;

import model.persistence.ApplicationState;
import view.interfaces.IGuiWindow;
import main.ShapeSelected;

public class SelectShape {

    private ShapeSelected theShapeSelected;

    public SelectShape(int StartPointX, int StartPointY, int EndPointX, int EndPointY, ApplicationState appState, IGuiWindow guiWindow) {

        theShapeSelected = new ShapeSelected(StartPointX, StartPointY, EndPointX, EndPointY, appState, guiWindow);



    }


}
