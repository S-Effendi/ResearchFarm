package com.researchfarm_seffendi.domain.sustenance;

/**
 * Created by Suzanne Effendi on 2017/08/07.
 */
public class Omnivore extends SustenanceHandler {
    @Override
    public String handleCall(String call){
        if(call.equalsIgnoreCase("Both")){
            return "Species digests both creatures and plants";
        }else{
            return handler.handleCall(call);
        }
    }
}
