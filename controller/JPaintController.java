package controller;

import main.CommandHistory;
import model.CopyMode;
import model.DeleteMode;
import model.PasteMode;
import model.interfaces.IApplicationState;
import view.EventName;
import view.interfaces.IUiModule;


public class JPaintController implements IJPaintController {
    private final IUiModule uiModule;
    private final IApplicationState applicationState;

    private final CopyMode copy;

    private final PasteMode paste;

    private final DeleteMode delete;

    public JPaintController(IUiModule uiModule, IApplicationState applicationState) {
        this.uiModule = uiModule;
        this.applicationState = applicationState;

        copy = new CopyMode();

        paste = new PasteMode();

        delete = new DeleteMode();


    }

    @Override
    public void setup() {
        setupEvents();
    }

    private void setupEvents() {
        uiModule.addEvent(EventName.CHOOSE_SHAPE, () -> applicationState.setActiveShape());
        uiModule.addEvent(EventName.CHOOSE_PRIMARY_COLOR, () -> applicationState.setActivePrimaryColor());
        uiModule.addEvent(EventName.CHOOSE_SECONDARY_COLOR, () -> applicationState.setActiveSecondaryColor());
        uiModule.addEvent(EventName.CHOOSE_SHADING_TYPE, () -> applicationState.setActiveShadingType());
        uiModule.addEvent(EventName.CHOOSE_START_POINT_ENDPOINT_MODE, () -> applicationState.setActiveStartAndEndPointMode());
        uiModule.addEvent(EventName.COPY, () -> copy.SelectedtoCopyArray());
        uiModule.addEvent(EventName.PASTE, () -> paste.copyShapestoShapeList());
        uiModule.addEvent(EventName.DELETE, () -> delete.DeleteSelected());
        uiModule.addEvent(EventName.UNDO, () -> CommandHistory.undo());
        uiModule.addEvent(EventName.REDO, () -> CommandHistory.redo());

    }
}
