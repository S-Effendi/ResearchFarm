package com.researchfarm_seffendi.factories.child;

/**
 * Created by Suzanne Effendi on 2017/08/13.
 */
public interface ChildBuilderService {
    public void generateSpecies(String geneFamilyType);
    public void generateMovement(String movementType);
    public void generateSustenance(String sustenanceType);
    public void modifySpecies(String geneFamilyType);
    public Child getChild();
}
