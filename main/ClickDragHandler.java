package main;

import model.interfaces.IApplicationState;
import model.persistence.ApplicationState;
import view.interfaces.IGuiWindow;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.*;


public class ClickDragHandler extends MouseAdapter {

    int StartPointX = 0;
    int StartPointY = 0;
    int EndPointX = 0;
    int EndPointY = 0;
    ApplicationState appState;
    IGuiWindow guiWindow;

    public ClickDragHandler(ApplicationState appState,  IGuiWindow guiWindow) {

        this.appState = appState;
        this.guiWindow = guiWindow;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        StartPointX = e.getX();
        StartPointY = e.getY();


        System.out.printf("Start X and Y: %d %d /  ", StartPointX, StartPointY );

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        EndPointX = e.getX();
        EndPointY = e.getY();
        System.out.printf("End X and Y: %d %d \n", EndPointX, EndPointY );

        //Create new command

        CommandHandler newCommand = new CommandHandler(StartPointX, StartPointY, EndPointX, EndPointY, appState, guiWindow);
    }

    /*
    When the mouse button is clicked, one thing needs to happen: record the starting point.

When the mouse button is released, two things need to happen: Record the ending point
and trigger the creation of a new Shape. You should do this via the Command pattern,
which we will talk about first thing on 7/11.

fix the bug where you can only draw by dragging from top-left to bottom-right
     */
}
