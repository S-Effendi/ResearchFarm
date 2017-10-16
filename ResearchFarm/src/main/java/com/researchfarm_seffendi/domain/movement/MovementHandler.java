package com.researchfarm_seffendi.domain.movement;

/**
 * Created by Suzanne Effendi on 2017/08/13.
 */
public abstract class MovementHandler {
    MovementHandler handler;

    public void setHandler(MovementHandler handler){
        this.handler = handler;
    }

    public abstract String handleCall(String call);
}
