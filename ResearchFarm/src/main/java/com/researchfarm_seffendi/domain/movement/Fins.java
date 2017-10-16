package com.researchfarm_seffendi.domain.movement;

/**
 * Created by Suzanne Effendi on 2017/08/13.
 */
public class Fins extends MovementHandler {
    @Override
    public String handleCall(String call) {
        if (call.equalsIgnoreCase("Fins")) {
            return "Used Fins to retrieve food";
        } else {
            return handler.handleCall(call);
        }
    }
}