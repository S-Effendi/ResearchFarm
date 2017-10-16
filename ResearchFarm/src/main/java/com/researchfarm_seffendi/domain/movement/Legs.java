package com.researchfarm_seffendi.domain.movement;

/**
 * Created by Suzanne Effendi on 2017/08/07.
 */
public class Legs extends MovementHandler {
    @Override
    public String handleCall(String call){
        if(call.equalsIgnoreCase("Legs")){
            return "Used Legs to retrieve Food";
        }else{
            return handler.handleCall(call);
        }
    }
}
