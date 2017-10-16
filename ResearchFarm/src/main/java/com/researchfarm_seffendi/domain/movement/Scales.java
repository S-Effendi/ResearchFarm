package com.researchfarm_seffendi.domain.movement;

/**
 * Created by Suzanne Effendi on 2017/08/07.
 */
public class Scales extends MovementHandler {
    @Override
    public String handleCall(String call){
        if(call.equalsIgnoreCase("Scales")){
            return "Used Scales to retrieve Food";
        }else{
            return handler.handleCall(call);
        }
    }
}
