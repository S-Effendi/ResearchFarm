package com.researchfarm_seffendi.services;

import android.content.Intent;

/**
 * Created by S.Effendi on 2017/09/07.
 */
public class TestInsertSpecies extends AndroidTestCase{

        @Override
        public void setUp() throws Exception {
            super.setUp();
            Intent intent = new Intent(this.getContext(), InsertVehicleService.class);
            intent.putExtra("speciesType", "Mammal");
            intent.putExtra("movementType", "walk");
            this.getContext().startService(intent);
        }

    }
