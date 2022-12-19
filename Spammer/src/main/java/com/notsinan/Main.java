package com.notsinan;

import org.dreambot.api.methods.input.Keyboard;
import org.dreambot.api.methods.interactive.Players;
import org.dreambot.api.methods.map.Area;
import org.dreambot.api.methods.walking.impl.Walking;
import org.dreambot.api.script.AbstractScript;
import org.dreambot.api.utilities.Sleep;

import java.util.ArrayList;

public class Main extends AbstractScript {

    Area scoutArea;
    int wpm;
    ArrayList<String> lines = new ArrayList<>();
    int delay;


    public void onStart() {

        wpm = 300;
        Keyboard.setWordsPerMinute(wpm);
        delay = 2;

        lines.add("Milkster");
        lines.add("Penkster");
        lines.add("Henkster");

    }

    @Override
    public int onLoop() {
        if (scoutArea == null) {
            scoutArea = AreaManager.chosenArea("Lumbridge");
        }
        if (!scoutArea.contains(Players.getLocal())) {
            if (Walking.shouldWalk(4)) {
                Walking.walk(scoutArea.getRandomTile());
            }
        } else {

            for (String line: lines) {
                Keyboard.type(line, true, true);
                Sleep.sleep(delay);
            }

        }
        return 400;
    }
}
