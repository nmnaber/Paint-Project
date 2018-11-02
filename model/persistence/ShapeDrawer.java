package model.persistence;
import main.Shape;
import model.ShapeType;
import shapedrawstrategies.BackgroundDrawStrategy;
import shapedrawstrategies.TriangleDrawStrategy;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import shapedrawstrategies.RectangleDrawStrategy;
import shapedrawstrategies.EllipseDrawStrategy;

import java.util.ArrayList;


public class ShapeDrawer {

    private ShapeList shapeList = ShapeList.getShapeList();

    private BackgroundShapeList backgroundShapeList = BackgroundShapeList.getSelectedShapeList();

    private ArrayList<Shape> backgroundArray;

    private ArrayList<Shape> listtoDraw;

    private int StartPointX; private int StartPointY;
    private int EndPointX; private int EndPointY;

    private ApplicationState appState;
    private IGuiWindow guiWindow;

    public ShapeDrawer () {

        listtoDraw = shapeList.getArray();

        backgroundArray = backgroundShapeList.getArray();

        if (!listtoDraw.isEmpty()) {

            Shape infoPull = listtoDraw.get(0);

            this.appState = infoPull.getAppState();
            this.guiWindow = infoPull.getGUIwindow();
        }

    }

    public void DrawShapes() {

        //System.out.println("In DrawShapes in ShapeDrawer");

        BackgroundDrawStrategy backgroundDrawStrategy = new BackgroundDrawStrategy(backgroundArray.get(0));

        backgroundDrawStrategy.drawShape();


        for ( Shape shapetoDraw : listtoDraw ) {

            if (shapetoDraw.getShapeType() == ShapeType.ELLIPSE) {
                System.out.println( "Print me an Ellipse");
                EllipseDrawStrategy ellipseDraw = new EllipseDrawStrategy(shapetoDraw);
                ellipseDraw.drawShape();

            }

            else if (shapetoDraw.getShapeType() == ShapeType.RECTANGLE) {
                System.out.println( "Print me an RECTANGLE");
                RectangleDrawStrategy rectDraw = new RectangleDrawStrategy(shapetoDraw);
                rectDraw.drawShape();

            }

            else if (shapetoDraw.getShapeType() == ShapeType.TRIANGLE) {
                System.out.println( "Print me an TRIANGLE");
                TriangleDrawStrategy triDraw = new TriangleDrawStrategy((shapetoDraw));
                triDraw.drawShape();
            }



        }


    }
}
