package com.researchfarm_seffendi.factories.parent;

import com.s_effendi.factories.child.Child;
import com.s_effendi.factories.child.ChildBuilder;

import java.io.Serializable;

/**
 * Created by Suzanne Effendi on 2017/08/13.
 */
public class Parent implements Serializable{

    private ChildBuilder child;
    private Child currentChild;
    private long childId;

    public void print(){
        currentChild = child.getChild();
        System.out.println(currentChild.toString());
    }

    public String getSpeciesType(){
        currentChild = child.getChild();
        String type = currentChild.getGeneFamilyType();
        return type;
    }

    public String getMovementType(){
        currentChild = child.getChild();
        String mtype = currentChild.getMovement();
        return mtype;
    }

    public String getSustenanceType(){
        currentChild = child.getChild();
        String stype = currentChild.getSustenance();
        return stype;
    }

    public long getChildId() {
        return childId;
    }

    public Parent(Builder builder){
        this.child = builder.child;
        this.childId = builder.childId;
    }

    public static class Builder{
        private ChildBuilder child = new ChildBuilder();
        private long childId;

        public Builder childId(long id){
            this.childId =id;
            return this;
        }

        public Builder child(String speciesType, String movementType, String sustenanceType){
            this.child.generateSpecies(speciesType);
            this.child.generateMovement(movementType);
            this.child.generateSustenance(sustenanceType);
            return this;
        }

        public Builder modifyChild(String geneFamilyType){
            this.child.modifySpecies(geneFamilyType);
            return this;
        }

        public Builder clone(Parent parent){
            this.child = parent.child;
            this.childId = parent.childId;
            return this;
        }

        public Parent create()
        {
            return new Parent(this);
        }
    }
}
