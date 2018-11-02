package main;

import controller.IJPaintController;
import controller.JPaintController;
import model.ShapeColor;
import model.ShapeType;
import model.persistence.ApplicationState;
import model.persistence.BackgroundShapeList;
import view.EventName;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.IUiModule;

import java.awt.*;
import java.awt.event.KeyListener;

public class Main {

    public static void main(String[] args) {
        IGuiWindow guiWindow = new GuiWindow(new PaintCanvas());
        IUiModule uiModule = new Gui(guiWindow);
        ApplicationState appState = new ApplicationState(uiModule);
        IJPaintController controller = new JPaintController(uiModule, appState);
        controller.setup();

        ////

        ((GuiWindow) guiWindow).addMouseListener(new ClickDragHandler(appState, guiWindow));


        Shape backGroundclear = new Shape(3,59,1300,800, appState, guiWindow);

        backGroundclear.setShapeType(ShapeType.RECTANGLE);

        backGroundclear.setPrimraryShapeColor(ShapeColor.WHITE);

        BackgroundShapeList backgroundShapeList = BackgroundShapeList.getSelectedShapeList();

        backgroundShapeList.add(backGroundclear);

    }
}

