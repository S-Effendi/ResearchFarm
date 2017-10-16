package com.researchfarm_seffendi.domain.sustenance;

/**
 * Created by Suzanne Effendi on 2017/08/07.
 */
public class NoSustenance extends SustenanceHandler {
    @Override
    public String handleCall(String call){
        if(call.equalsIgnoreCase("No food")){
            return "Inadequate food to sustain specimen";
        }else{
            return handler.handleCall(call);
        }
    }
}
