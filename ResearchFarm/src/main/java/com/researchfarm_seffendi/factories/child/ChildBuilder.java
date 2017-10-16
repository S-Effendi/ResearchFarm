package com.researchfarm_seffendi.factories.child;

import com.researchfarm_seffendi.domain.species.SpeciesFactory;
import com.researchfarm_seffendi.domain.species.SpeciesType;

/**
 * Created by Suzanne Effendi on 2017/08/13.
 */
public class ChildBuilder implements ChildBuilderService {
    private Child child;
    private SpeciesFactory species;
    private SpeciesType speciesType;

    public ChildBuilder(){
        child = new Child();
        species = SpeciesFactory.getSFactoryInstance();
    }
    public void generateSpecies(String geneFamilyType){
        speciesType = species.getSpeciesType(geneFamilyType);
        child.setSpecies(speciesType);
    }

    public void modifySpecies(String geneFamilyType){
        speciesType = species.getSpeciesType(geneFamilyType);
        child.setSpecies(speciesType);
    }

    public void generateMovement(String movementType){
        child.setMovement(movementType);
    }

    public void generateSustenance(String sustenanceType){
        child.setSustenance(sustenanceType);
    }

    public Child getChild(){
        return child;
    }
}
