package com.researchfarm_seffendi.domain.movement;

/**
 * Created by Suzanne Effendi on 2017/08/07.
 */
public class NoMovement extends MovementHandler {
    @Override
    public String handleCall(String call){
        if(call.equalsIgnoreCase("No movement")) {
            return "No movement";
        }else{
            return handler.handleCall(call);
        }
    }
}
