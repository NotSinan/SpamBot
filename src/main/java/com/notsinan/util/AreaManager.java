package com.notsinan.util;

import org.dreambot.api.methods.map.Area;
import org.dreambot.api.utilities.Logger;

public class AreaManager {

    private static final Area lumbridgeArea = new Area(3217, 3222, 3225, 3215);
    private static final Area grandExchangeArea = new Area(3162, 3486, 3167, 3481);
    private static final Area feroxEnclaveArea = new Area(3131, 3631, 3136, 3628);

    public static Area chosenArea(String location) {

        Area scoutArea = null;

        switch (location) {
            case "Lumbridge":
                scoutArea = lumbridgeArea;
                break;
            case "Grand Exchange":
                scoutArea = grandExchangeArea;
                break;
            case "Ferox":
                scoutArea = feroxEnclaveArea;
                break;
            default:
                Logger.log("Invalid location: " + location);
        }

        return scoutArea;

    }
}