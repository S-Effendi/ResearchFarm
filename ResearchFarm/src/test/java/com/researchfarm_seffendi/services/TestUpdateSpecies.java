package com.researchfarm_seffendi.services;

import android.content.Intent;

/**
 * Created by S.Effendi on 2017/09/07.
 */
public class TestUpdateSpecies extends AndroidTestCase
    {
        @Override
        public void setUp() throws Exception {
            super.setUp();
            Intent intent = new Intent(this.getContext(), UpdateVehicleService.class);
            intent.putExtra("speciesType", "reptile");
            this.getContext().startService(intent);
        }
}
