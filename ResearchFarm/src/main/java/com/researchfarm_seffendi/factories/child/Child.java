package com.researchfarm_seffendi.factories.child;

import com.researchfarm_seffendi.domain.movement.*;
import com.researchfarm_seffendi.domain.species.SpeciesType;
import com.researchfarm_seffendi.domain.sustenance.*;

/**
 * Created by Suzanne Effendi on 2017/08/13.
 */
public class Child {
    private SpeciesType species;

    private MovementHandler movement1 = new Fins();
    private MovementHandler movement2 = new Legs();
    private MovementHandler movement3 = new Scales();
    private MovementHandler movement4 = new Wings();
    private MovementHandler movement5 = new NoMovement();
    private String movement;

    private SustenanceHandler sustenance1 = new Carnivore();
    private SustenanceHandler sustenance2 = new Herbivore();
    private SustenanceHandler sustenance3 = new Omnivore();
    private SustenanceHandler sustenance4 = new NoSustenance();
    private String sustenance;

    public void setSpecies(SpeciesType species){
        this.species = species;
    }

    public String getMovement(){
        return movement;
    }

    public String getSustenance(){
        return sustenance;
    }

    public String getGeneFamilyType(){
        String geneFamilyType = species.geneFamilyType();
        return geneFamilyType;
    }

    public void setMovement(String movementType){
        movement1.setHandler(movement2);
        movement2.setHandler(movement3);
        movement3.setHandler(movement4);
        movement4.setHandler(movement5);
            this.movement = movement1.handleCall(movementType);
    }

    public void setSustenance(String sustenanceType){
        sustenance1.setHandler(sustenance2);
        sustenance2.setHandler(sustenance3);
        sustenance3.setHandler(sustenance4);
            this.sustenance = sustenance1.handleCall(sustenanceType);
    }

    public String toString(){
        if(movement.equalsIgnoreCase("no movements")) {
            return "Species able to acquire food... \n" + species.toString() + "\nSpecies genetic Family: " + species.geneFamilyType() + "\nMovement Method: " + movement + "\nSustenance Requirement: " + sustenance;
        }else{
            return "Species able to acquire food... \\n\" + species.toString() + \"\\nSpecies genetic Family: \" + species.geneFamilyType() + \"\\nMovement Method: " + movement + "\nSustenance Requirement: " + sustenance;
        }
    }
}
