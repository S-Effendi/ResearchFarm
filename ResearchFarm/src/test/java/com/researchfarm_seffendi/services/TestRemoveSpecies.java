package com.researchfarm_seffendi.services;

import android.content.Intent;

/**
 * Created by S.Effendi on 2017/09/07.
 */
public class TestRemoveSpecies AndroidTestCase
{
    @Override
    public void setUp() throws Exception {
        super.setUp();
        Intent intent = new Intent(this.getContext(), RemoveVehicleService.class);
        intent.putExtra("speciesType", "Fish");
        intent.putExtra("movementType", "swim");
        this.getContext().startService(intent);
    }
}
