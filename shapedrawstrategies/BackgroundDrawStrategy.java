package shapedrawstrategies;

import main.Shape;
import model.ColorConverter;
import model.ShapeColor;
import model.ShapeShadingType;
import model.persistence.ApplicationState;
import view.gui.GuiWindow;
import view.interfaces.IGuiWindow;

import java.awt.*;

public class BackgroundDrawStrategy {

    private int StartPointX; private int StartPointY;
    private int EndPointX; private int EndPointY;
    private int Width; private int Height;

    private ShapeColor primrarycolorofShape;
    private ShapeColor secondarycolorofShape;
    private ShapeShadingType shadingType;

    private IGuiWindow guiWindow;

    private ApplicationState appState;


    public BackgroundDrawStrategy(Shape shapetoDraw) {

        StartPointX =  shapetoDraw.getStartPointX();
        StartPointY = shapetoDraw.getStartPointY();
        EndPointX = shapetoDraw.getEndPointX();
        EndPointY = shapetoDraw.getEndPointY();
        Width = (shapetoDraw.getEndPointX()- shapetoDraw.getStartPointX());
        Height = (shapetoDraw.getEndPointY() - shapetoDraw.getStartPointY());
        guiWindow = shapetoDraw.getGUIwindow();
        primrarycolorofShape = shapetoDraw.getPrimraryShapeColor();
        secondarycolorofShape = shapetoDraw.getSecondaryShapeColor();
        shadingType = shapetoDraw.getShadingType();
        appState = shapetoDraw.getAppState();

       // Width = (EndPointX - StartPointX);
       // Height = (EndPointY - StartPointY);


    }

    public void drawShape () {

        Graphics graphics2d = ((GuiWindow) guiWindow).getGraphics();

        Graphics2D gfx2d = (Graphics2D) graphics2d;

        if (shadingType == ShapeShadingType.FILLED_IN) {
            gfx2d.setColor(Color.WHITE);
            gfx2d.fillRect(StartPointX, StartPointY, Width, Height);
        }
    }
}
