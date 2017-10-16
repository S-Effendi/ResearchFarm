package com.researchfarm_seffendi.domain.sustenance;

/**
 * Created by Suzanne Effendi on 2017/08/07.
 */
public abstract class SustenanceHandler {
    SustenanceHandler handler;

    public void setHandler(SustenanceHandler handler){
        this.handler = handler;
    }

    public abstract String handleCall(String call);
}
