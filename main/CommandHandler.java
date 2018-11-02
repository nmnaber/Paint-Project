package main;

import commands.MoveShape;
import model.StartAndEndPointMode;
import model.interfaces.IApplicationState;
import model.persistence.ApplicationState;
import model.persistence.ShapeDrawer;
import model.persistence.ShapeList;
import view.gui.GuiWindow;
import view.interfaces.IGuiWindow;
import view.interfaces.IUiModule;
import commands.CreateShape;
import commands.SelectShape;


public class CommandHandler {

    private CreateShape newShape;

    private SelectShape newSelectedShape;

    private MoveShape newMoveShape;

    CommandHandler (int StartPointX, int StartPointY, int EndPointX, int EndPointY, ApplicationState appState, IGuiWindow guiWindow) {

        System.out.printf("I'm in the CommandHandler \n");

        StartAndEndPointMode currentState = appState.getActiveStartAndEndPointMode();

        String stringState = currentState.toString();

        switch (stringState) {

            case "DRAW" : System.out.println(stringState);

                          newShape = new CreateShape(StartPointX, StartPointY, EndPointX, EndPointY, appState, guiWindow);

                          CommandHistory.add(newShape);

                          break;

            case "SELECT" : System.out.println(stringState);

                            newSelectedShape = new SelectShape (StartPointX, StartPointY, EndPointX, EndPointY, appState, guiWindow);

                            //CommandHistory.add(newSelectedShape);

                            break;

            case "MOVE" :  System.out.println(stringState);

                            newMoveShape = new MoveShape (StartPointX, StartPointY, EndPointX, EndPointY, appState, guiWindow);

                            //CommandHistory.add(newMoveShape);

                            break;
        }



    }

}
