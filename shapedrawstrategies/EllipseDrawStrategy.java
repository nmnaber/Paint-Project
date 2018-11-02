package shapedrawstrategies;

import main.Shape;
import model.ColorConverter;
import model.ShapeColor;
import model.ShapeShadingType;
import model.persistence.ApplicationState;
import view.gui.GuiWindow;
import view.interfaces.IGuiWindow;

import java.awt.*;

public class EllipseDrawStrategy {

    private int StartPointX; private int StartPointY;
    private int EndPointX; private int EndPointY;
    private int Width; private int Height;

    private ShapeColor primrarycolorofShape;
    private ShapeColor secondarycolorofShape;
    private ShapeShadingType shadingType;

    private IGuiWindow guiWindow;

    private ApplicationState appState;


    public EllipseDrawStrategy(Shape shapetoDraw) {

        //this.shapetoDraw = shapetoDraw;

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

    }

    public void drawShape () {

        Graphics graphics2d = ((GuiWindow) guiWindow).getGraphics();

        Graphics2D gfx2d = (Graphics2D) graphics2d;

        ColorConverter Converter1 = new ColorConverter(primrarycolorofShape);
        ColorConverter Converter2 = new ColorConverter(secondarycolorofShape);

        if (shadingType == ShapeShadingType.FILLED_IN) {
            gfx2d.setColor(Converter1.AWTCOLORS());
            gfx2d.fillOval(Math.min(StartPointX, EndPointX), Math.min(StartPointY,EndPointY), Math.abs(StartPointX-EndPointX), Math.abs(StartPointY-EndPointY));
        }

        else if (shadingType == ShapeShadingType.OUTLINE) {
            gfx2d.setColor(Converter1.AWTCOLORS());
            gfx2d.setStroke(new BasicStroke(5));
            gfx2d.drawOval(Math.min(StartPointX, EndPointX), Math.min(StartPointY,EndPointY), Math.abs(StartPointX-EndPointX), Math.abs(StartPointY-EndPointY));
            gfx2d.setColor(Color.WHITE);
            gfx2d.fillOval(Math.min(StartPointX, EndPointX), Math.min(StartPointY,EndPointY), Math.abs(StartPointX-EndPointX), Math.abs(StartPointY-EndPointY));
        }

        else if (shadingType == ShapeShadingType.OUTLINE_AND_FILLED_IN) {

            gfx2d.setColor(Converter1.AWTCOLORS());
            gfx2d.fillOval(Math.min(StartPointX, EndPointX), Math.min(StartPointY,EndPointY), Math.abs(StartPointX-EndPointX), Math.abs(StartPointY-EndPointY));

            gfx2d.setColor(Converter2.AWTCOLORS());
            gfx2d.setStroke(new BasicStroke(5));
            gfx2d.drawOval(Math.min(StartPointX, EndPointX), Math.min(StartPointY,EndPointY), Math.abs(StartPointX-EndPointX), Math.abs(StartPointY-EndPointY));
        }
    }
}
