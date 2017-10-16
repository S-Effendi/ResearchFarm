package com.researchfarm_seffendi.domain.species;

/**
 * Created by Suzanne Effendi on 2017/08/07.
 */
public class SpeciesFactory {
    private static SpeciesFactory speciesFactory = null;

    public SpeciesFactory() {
    }

    public static SpeciesFactory getSFactoryInstance() {
        if (speciesFactory == null) {
            return new SpeciesFactory();
        }
        return speciesFactory;
    }

    public SpeciesType getSpeciesType(String geneFamilyType) {
        if (geneFamilyType.equalsIgnoreCase("Bird")) {
            return new Bird();
        } else if (geneFamilyType.equalsIgnoreCase("Fish")) {
            return new Fish();
        } else if (geneFamilyType.equalsIgnoreCase("Invertebrate")) {
            return new Invertebrates();
        } else if (geneFamilyType.equalsIgnoreCase("Mammal")) {
            return new Mammal();
        } else {
            return new Reptile();
        }
    }
}
