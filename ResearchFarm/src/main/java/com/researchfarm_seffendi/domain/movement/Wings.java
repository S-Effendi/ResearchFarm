package com.researchfarm_seffendi.domain.movement;

/**
 * Created by Suzanne Effendi on 2017/08/07.
 */
public class Wings extends MovementHandler {
    @Override
    public String handleCall(String call){
        if(call.equalsIgnoreCase("Wings")){
            return "Used Wings to retrieve food";
        }else{
            return handler.handleCall(call);
        }
    }
}
