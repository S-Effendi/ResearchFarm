package com.researchfarm_seffendi.services;

import android.content.Intent;
import com.s_effendi.factories.child.ChildBuilderService;

/**
 * Created by S.Effendi on 2017/09/07.
 */
public class TestSpeciesCreate extends AndroidTestCase
{
    @Override
    public void setUp() throws Exception {
        super.setUp();

        Intent intent = new Intent(this.getContext(), ChildBuilderService.class);
        this.getContext().startService(intent);
    }
}
