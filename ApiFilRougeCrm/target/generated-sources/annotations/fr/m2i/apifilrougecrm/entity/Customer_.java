package fr.m2i.apifilrougecrm.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Customer.class)
public abstract class Customer_ {

	public static volatile SingularAttribute<Customer, String> firstName;
	public static volatile SingularAttribute<Customer, String> lastName;
	public static volatile SingularAttribute<Customer, String> zipCode;
	public static volatile SingularAttribute<Customer, String> country;
	public static volatile SingularAttribute<Customer, String> address;
	public static volatile SingularAttribute<Customer, String> phone;
	public static volatile SingularAttribute<Customer, String> city;
	public static volatile SingularAttribute<Customer, String> companyName;
	public static volatile SingularAttribute<Customer, Long> id;
	public static volatile SingularAttribute<Customer, Integer> state;
	public static volatile SingularAttribute<Customer, String> email;

	public static final String FIRST_NAME = "firstName";
	public static final String LAST_NAME = "lastName";
	public static final String ZIP_CODE = "zipCode";
	public static final String COUNTRY = "country";
	public static final String ADDRESS = "address";
	public static final String PHONE = "phone";
	public static final String CITY = "city";
	public static final String COMPANY_NAME = "companyName";
	public static final String ID = "id";
	public static final String STATE = "state";
	public static final String EMAIL = "email";

}

