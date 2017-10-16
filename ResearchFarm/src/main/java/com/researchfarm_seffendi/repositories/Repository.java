package com.researchfarm_seffendi.repositories;

import java.util.Set;

/**
 * Created by Suzanne Effendi on 2017/08/13.
 */
public interface Repository <ParentEntity, ParentKey> {
    int deleteChild();

    ParentEntity saveChild(ParentEntity child);
    ParentEntity modifyChild(ParentEntity child);
    ParentEntity deleteChild(ParentEntity child);
    ParentEntity findChild(ParentKey dnaStrand);
    Set<ParentEntity> findAll();
}
