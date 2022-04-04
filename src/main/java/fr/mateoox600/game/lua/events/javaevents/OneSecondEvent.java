package fr.mateoox600.game.lua.events.javaevents;

import com.raylib.java.core.rCore;
import fr.mateoox600.game.lua.events.JavaEvent;

public class OneSecondEvent implements JavaEvent {

    private float acc = 0;
    private float miss = 0;

    @Override
    public String getName() {
        return "1s_event";
    }

    @Override
    public boolean checkExecute() {
        this.acc += rCore.GetFrameTime();
        if(acc >= 1) {
            miss = acc - 1;
            acc = 0;
            return true;
        }
        return false;
    }

    @Override
    public Object[] getArguments() {
        return new Object[] {
                (double) miss
        };
    }

}



