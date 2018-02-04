package com.github.postal915.germes.app.model.entity.person;

import com.github.postal915.germes.app.model.entity.base.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Entity that encapsulate user of the application
 */
@Table(name = "ACCOUNT")
@Entity
public class Account extends AbstractEntity {

}
