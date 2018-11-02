package model;

import java.awt.*;

public class ColorConverter {

    private final ShapeColor colortoConvert;

    private Color finalreturn = Color.BLACK;

    public ColorConverter (ShapeColor colortoConvert) {

     this.colortoConvert = colortoConvert;

    }

    public Color AWTCOLORS () {

        switch (colortoConvert.toString()) {

            case "BLACK" : finalreturn =  Color.black; break;

            case "BLUE" : finalreturn = Color.blue; break;

            case "CYAN" :  finalreturn = Color.cyan; break;

            case "DARK_GRAY" :  finalreturn = Color.darkGray; break;

            case "GRAY" :  finalreturn = Color.gray ; break;

            case "GREEN" :  finalreturn = Color.green; break;

            case "LIGHT_GRAY" :  finalreturn = Color.lightGray; break;

            case "MAGENTA" :  finalreturn = Color.magenta; break;

            case "ORANGE" :  finalreturn = Color.orange; break;

            case "PINK" :  finalreturn = Color.pink; break;

            case "RED" :  finalreturn = Color.red; break;

            case "WHITE" :  finalreturn = Color.white; break;

            case "YELLOW" :  finalreturn = Color.yellow; break;


        }

        return finalreturn;
    }

}



