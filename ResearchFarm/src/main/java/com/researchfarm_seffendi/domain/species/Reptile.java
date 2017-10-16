package com.researchfarm_seffendi.domain.species;

/**
 * Created by Suzanne Effendi on 2017/08/07.
 */
public class Reptile implements SpeciesType {
    private String geneFamilyType;
    private String food = "creature or invertebrates";
    private String sleep = "day";

    public void setGeneFamilyType(String geneFamilyType){
        this.geneFamilyType = geneFamilyType;
    }
    public String geneFamilyType() {
        return "Reptile";
    }

    public String getFood(){
        return food;
    }
    public void setFood(String food) {
        this.food = food;
    }

    public String getSleep(){
        return sleep;
    }
    public void setSleep(String sleep) {
        this.sleep = sleep;
    }

    public String toString() {
        return "Reptile{" +
                "geneFamilyType='" + geneFamilyType + '\'' +
                ", food='" + food + '\'' +
                ", sleep='" + sleep + '\'' +
                '}';
    }
}
