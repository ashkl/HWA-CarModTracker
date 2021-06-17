package com.qa.hwa.domain;

import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

public class ModificationTest {

	@Test
	public void testEquals() {
		Car car1 = new Car();
		car1.setMake("BMW");
		
		Car car2 = new Car();
		car2.setMake("VW");
		
		EqualsVerifier.simple().forClass(Modification.class)
		.withRedefinedSuperclass()
		.withPrefabValues(Car.class, car1, car2).suppress(Warning.ALL_FIELDS_SHOULD_BE_USED).verify();
	}
}
