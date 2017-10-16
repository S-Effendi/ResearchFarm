package com.researchfarm_seffendi.domain.species;

/**
 * Created by Suzanne Effendi on 2017/08/07.
 */
public class Bird implements SpeciesType {

    private String geneFamilyType;
    private String food = "worm";
    private String sleep = "night";

    public void setGeneFamilyType(String geneFamilyType){
        this.geneFamilyType = geneFamilyType;
    }
    public String geneFamilyType() {
        return "Bird";
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
        return "Bird{" +
                "geneFamilyType='" + geneFamilyType + '\'' +
                ", food='" + food + '\'' +
                ", sleep='" + sleep + '\'' +
                '}';
    }
}
