package model;

import commands.CreateShape;
import main.Command;
import main.CommandHistory;
import main.Shape;
import model.persistence.*;
import view.interfaces.IGuiWindow;

import java.util.ArrayList;

public class DeleteMode {

    private int StartPointX; private int StartPointY;
    private int EndPointX; private int EndPointY;

    private ShapeColor primrarycolorofShape;
    private ShapeColor secondarycolorofShape;
    private ShapeShadingType shadingType;

    private IGuiWindow guiWindow;

    private ApplicationState appState;

    private ShapeList masterShapeList;

    private SelectedShapeList selectedShapeList;

    private ArrayList<Shape> selectedArray;

    private ArrayList<Shape> masterArray;

    private ShapeDrawer redrawAfterDel;

    private CreateShape newShape;

    private UnDeleteShapeList unDeleteShapeList;


    public DeleteMode () {

        selectedShapeList = SelectedShapeList.getSelectedShapeList();

        masterShapeList = ShapeList.getShapeList();

        unDeleteShapeList = UnDeleteShapeList.getSelectedShapeList();

        selectedArray = selectedShapeList.getArray();

        masterArray = masterShapeList.getArray();

        redrawAfterDel = new ShapeDrawer();


    }

    public void DeleteSelected () {

       for (Shape deleteme : selectedArray) {

           masterArray.remove(deleteme);

           unDeleteShapeList.add(deleteme);

           CommandHistory.add(unDeleteShapeList);
       }

       masterShapeList.replaceArray(masterArray);

       //add selected Array to undo list




       selectedArray.clear();
       selectedShapeList.replaceArray(selectedArray);

        redrawAfterDel.DrawShapes();

    }


}



