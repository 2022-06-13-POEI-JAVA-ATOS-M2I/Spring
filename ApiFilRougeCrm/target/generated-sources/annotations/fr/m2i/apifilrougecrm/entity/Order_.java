package fr.m2i.apifilrougecrm.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Order.class)
public abstract class Order_ {

	public static volatile SingularAttribute<Order, Float> unitPrice;
	public static volatile SingularAttribute<Order, Integer> nbDays;
	public static volatile SingularAttribute<Order, String> typePresta;
	public static volatile SingularAttribute<Order, Long> id;
	public static volatile SingularAttribute<Order, String> designation;
	public static volatile SingularAttribute<Order, Integer> state;
	public static volatile SingularAttribute<Order, Customer> customer;

	public static final String UNIT_PRICE = "unitPrice";
	public static final String NB_DAYS = "nbDays";
	public static final String TYPE_PRESTA = "typePresta";
	public static final String ID = "id";
	public static final String DESIGNATION = "designation";
	public static final String STATE = "state";
	public static final String CUSTOMER = "customer";

}

