package com.researchfarm_seffendi.domain.species;

/**
 * Created by Suzanne Effendi on 2017/08/07.
 */
public interface SpeciesType {
    public abstract String geneFamilyType();

    public abstract String getFood();
    public abstract void setFood(String food);

    public abstract String getSleep();
    public abstract void setSleep(String sleep);

    public abstract String toString();
}
