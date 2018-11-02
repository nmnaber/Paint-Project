package shapedrawstrategies;

import main.Shape;
import model.ColorConverter;
import model.ShapeColor;
import model.ShapeShadingType;
import model.persistence.ApplicationState;
import view.gui.GuiWindow;
import view.interfaces.IGuiWindow;

import java.awt.*;
import java.awt.geom.Path2D;


public class TriangleDrawStrategy {

    private int StartPointX; private int StartPointY;
    private int EndPointX; private int EndPointY;
    private int Width; private int Height;

    private int[] Xpoints;
    private int[] Ypoints;

    private ShapeColor primrarycolorofShape;
    private ShapeColor secondarycolorofShape;
    private ShapeShadingType shadingType;

    private IGuiWindow guiWindow;

    private ApplicationState appState;


    public TriangleDrawStrategy(Shape shapetoDraw) {


        StartPointX =  shapetoDraw.getStartPointX();
        StartPointY = shapetoDraw.getStartPointY();

        EndPointX = shapetoDraw.getEndPointX();
        EndPointY = shapetoDraw.getEndPointY();

        Xpoints = new int[]{StartPointX, ( (StartPointX+EndPointX ) /2), EndPointX};
        Ypoints = new int[]{EndPointY, Math.abs(StartPointY), EndPointY};


        Width = (shapetoDraw.getEndPointY() - shapetoDraw.getStartPointY());
        Height = (shapetoDraw.getEndPointX()- shapetoDraw.getStartPointX());
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
            gfx2d.fillPolygon(Xpoints,Ypoints, 3);
            //Path2D.Double triangle = new Path2D.Double();
            //triangle.moveTo(StartPointX, StartPointY);
            //triangle.lineTo(EndPointX, EndPointY);
            //triangle.lineTo( ((StartPointX+StartPointY)/2), ((EndPointY+EndPointX)/2)) ;
            //triangle.closePath();
            //gfx2d.fill(triangle);
        }

        else if (shadingType == ShapeShadingType.OUTLINE) {
            gfx2d.setColor(Converter1.AWTCOLORS());
            gfx2d.setStroke(new BasicStroke(5));
            gfx2d.drawPolygon(Xpoints,Ypoints, 3);
            gfx2d.setColor(Color.WHITE);
            gfx2d.fillPolygon(Xpoints,Ypoints, 3);

        }

        else if (shadingType == ShapeShadingType.OUTLINE_AND_FILLED_IN) {

            gfx2d.setColor(Converter1.AWTCOLORS());
            gfx2d.fillPolygon(Xpoints,Ypoints, 3);

            gfx2d.setColor(Converter2.AWTCOLORS());
            gfx2d.setStroke(new BasicStroke(5));
            gfx2d.drawPolygon(Xpoints,Ypoints, 3);
        }
    }
}
