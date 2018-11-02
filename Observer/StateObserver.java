package Observer;

import java.util.*;

import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.persistence.ApplicationState;
import model.persistence.ShapeReconfig;


public class StateObserver implements Observer {

    Observable observable;

    ShapeReconfig shapeReconfig;

    //List<ShapeType> typeList;

public StateObserver(Observable observable) {

    this.observable = observable;
    observable.addObserver(this);

    //typeList = Arrays.asList(ShapeType.values());

}

public void update(Observable obs, Object arg) {

    System.out.println(arg.toString());

    shapeReconfig = new ShapeReconfig();

    if (arg == "ShapeChange") {
        shapeReconfig.UpdateShapeType();

    }

    if (arg == "PriColorChange") {
        shapeReconfig.UpdatePrimraryShapeColor();

    }

    if (arg == "SecColorChange") {
        shapeReconfig.UpdateSecondartShapeColor();

    }

    if (arg == "ShadeChange") {
        shapeReconfig.UpdateShadingType();

    }



}



}
