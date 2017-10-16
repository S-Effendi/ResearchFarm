package com.researchfarm_seffendi.domain.sustenance;

/**
 * Created by Suzanne Effendi on 2017/08/07.
 */
public class Carnivore extends SustenanceHandler {
    @Override
    public String handleCall(String call){
        if(call.equalsIgnoreCase("Creature")) {
            return "Species digests other creatures";
        }else{
            return handler.handleCall(call);
        }
    }
}
