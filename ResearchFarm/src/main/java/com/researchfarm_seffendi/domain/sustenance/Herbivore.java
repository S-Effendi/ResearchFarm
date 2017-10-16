package com.researchfarm_seffendi.domain.sustenance;

/**
 * Created by Suzanne Effendi on 2017/08/07.
 */
public class Herbivore extends SustenanceHandler {
    @Override
    public String handleCall(String call){
        if(call.equalsIgnoreCase("Plant")) {
            return "Species digests plants";
        }else{
            return handler.handleCall(call);
        }
    }
}
