package com.researchfarm_seffendi.domain.species;

/**
 * Created by Suzanne Effendi on 2017/08/07.
 */
public class Mammal implements SpeciesType {
    private String geneFamilyType;
    private String food = "creatures or plants";
    private String sleep = "day";

    public void setGeneFamilyType(String geneFamilyType){
        this.geneFamilyType = geneFamilyType;
    }
    public String geneFamilyType() {
        return "Mammal";
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

    @Override
    public String toString() {
        return "Mammal{" +
                "geneFamilyType='" + geneFamilyType + '\'' +
                ", food='" + food + '\'' +
                ", sleep='" + sleep + '\'' +
                '}';
    }
}
