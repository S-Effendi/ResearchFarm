package com.researchfarm_seffendi.domain.species;

/**
 * Created by Suzanne Effendi on 2017/08/07.
 */
public class Fish implements SpeciesType {
    private String geneFamilyType;
    private String food = "fish";
    private String sleep = "night";

    public void setGeneFamilyType(String geneFamilyType){
        this.geneFamilyType = geneFamilyType;
    }
    public String geneFamilyType() {
        return "Fish";
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
        return "Fish{" +
                "geneFamilyType='" + geneFamilyType + '\'' +
                ", food='" + food + '\'' +
                ", sleep='" + sleep + '\'' +
                '}';
    }
}
