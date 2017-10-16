package com.researchfarm_seffendi.repositories;

import com.researchfarm_seffendi.config.DB.DBContract;
import com.researchfarm_seffendi.factories.parent.Parent;
import com.researchfarm_seffendi.repositories.repositoryParent.implementation.RepositoryParentImpl;
import junit.framework.Assert;

import java.util.Set;

/**
 * Created by Suzanne Effendi on 2017/09/05.
 */
public class testDB extends AndroidTestCase {

    RepositoryParentImpl Repository;

    public void testDb() throws Exception{

        //Create and Initialize db
        Repository = new RepositoryParentImpl(this.getContext());
        }
    //Create and Insert an entity
    Parent insertEntity = new Parent.Builder()
            .child("elephant", "walk", "plants")
            .create();
    Parent insertData = Repository.saveChild(insertEntity);

    long id = insertData.getChildId();
        System.out.println("ID: " + id);
        insertData.print();
        Assert.assertNotNull(insertData);

    Parent insertEntity2 = new Parent.Builder()
            .child("lion", "walk", "carnivore")
            .create();
    Parent insertData2 = Repository.saveChild(insertEntity2);
    long id2 = insertData2.getChildId();
        System.out.println("ID: " + id2);
        insertData2.print();
        Assert.assertNotNull(insertData2);

    //Find an entity and save its result
    Parent foundEntity = Repository.findChild(id);
        Assert.assertNotNull(foundEntity);

    //Select all data from table
    Set<Parent> parentList = Repository.findAll();
        Assert.assertTrue(parentList.size() > 0);

    //Update an entity
    Parent updateEntity = new Parent.Builder()
            .clone(foundEntity)
            .modifyChild("lion")
            .create();
        com.researchfarm_seffendi.repositories.Repository.modifyChild(updateEntity);

    Parent entity = Repository.findAll(id);
        entity.print();
        Assert.assertTrue("unleaded".equalsIgnoreCase(entity.getSpeciesType()) );

    //Delete an entity
        com.researchfarm_seffendi.repositories.Repository.deleteChild(updateEntity);
    Parent deleteEntity = Repository.findChild(id);
        Assert.assertNull(deleteEntity);

    //Delete table
    int rowsDeleted = Repository.deleteChild();
        Assert.assertTrue(rowsDeleted > 0);
}

    @Override
    public void breakDown() throws Exception {
        // Delete database after every execution to avoid errors while testing
        this.getContext().deleteDatabase(DBContract.DATABASE_NAME);
        super.breakDown();
    }
}
