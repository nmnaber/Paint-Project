package model.persistence;

import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.StartAndEndPointMode;
import model.dialogs.DialogProvider;
import model.interfaces.IApplicationState;
import model.interfaces.IDialogProvider;
import view.interfaces.IUiModule;
import Observer.StateObservable;
import Observer.StateObserver;
import model.persistence.SelectedShapeList;
import main.Shape;
import java.util.ArrayList;
import model.CopyMode;

public class ApplicationState implements IApplicationState{
    private final IUiModule uiModule;
    private final IDialogProvider dialogProvider;

    private ShapeType activeShapeType;
    private ShapeColor activePrimaryColor;
    private ShapeColor activeSecondaryColor;
    private ShapeShadingType activeShapeShadingType;
    private StartAndEndPointMode activeStartAndEndPointMode;

    private StateObservable theState;

    private StateObserver theObs;

    private String ShapeChange;
    private String PriColorChange;
    private String SecColorChange;
    private String ShadeChange;

    private SelectedShapeList selectedShapeList;
    private ArrayList<Shape> selectedShapeArray;


    public ApplicationState(IUiModule uiModule) {
        this.uiModule = uiModule;
        this.dialogProvider = new DialogProvider(this);
        setDefaults();

        //ApplicationState currentState = new ApplicationState(uiModule);

        theState = new StateObservable();

        selectedShapeList = SelectedShapeList.getSelectedShapeList();

        selectedShapeArray = selectedShapeList.getArray();


            Observers();


        ShapeChange = "ShapeChange";
        PriColorChange = "PriColorChange";
        SecColorChange = "SecColorChange";
        ShadeChange = "ShadeChange";

    }

    public void Observers() {

        theObs = new StateObserver(theState);

        theState.addObserver(theObs);

    }

    @Override
    public void setActiveShape() {
        activeShapeType = uiModule.getDialogResponse(dialogProvider.getChooseShapeDialog());
        theState.uiStateChange(ShapeChange);

    }

    @Override
    public void setActivePrimaryColor() {
        activePrimaryColor = uiModule.getDialogResponse(dialogProvider.getChoosePrimaryColorDialog());
        theState.uiStateChange(PriColorChange);
    }

    @Override
    public void setActiveSecondaryColor() {
        activeSecondaryColor = uiModule.getDialogResponse(dialogProvider.getChooseSecondaryColorDialog());
        theState.uiStateChange(SecColorChange);

    }

    @Override
    public void setActiveShadingType() {
        activeShapeShadingType = uiModule.getDialogResponse(dialogProvider.getChooseShadingTypeDialog());
        theState.uiStateChange(ShadeChange);

    }

    @Override
    public void setActiveStartAndEndPointMode() {
        activeStartAndEndPointMode = uiModule.getDialogResponse(dialogProvider.getChooseStartAndEndPointModeDialog());
    }

    @Override
    public ShapeType getActiveShapeType() {
        return activeShapeType;
    }

    @Override
    public ShapeColor getActivePrimaryColor() {
        return activePrimaryColor;
    }

    @Override
    public ShapeColor getActiveSecondaryColor() {
        return activeSecondaryColor;
    }

    @Override
    public ShapeShadingType getActiveShapeShadingType() {
        return activeShapeShadingType;
    }

    @Override
    public StartAndEndPointMode getActiveStartAndEndPointMode() {
        return activeStartAndEndPointMode;
    }


    private void setDefaults() {
        activeShapeType = ShapeType.ELLIPSE;
        activePrimaryColor = ShapeColor.BLUE;
        activeSecondaryColor = ShapeColor.GREEN;
        activeShapeShadingType = ShapeShadingType.FILLED_IN;
        activeStartAndEndPointMode = StartAndEndPointMode.DRAW;
    }
}
