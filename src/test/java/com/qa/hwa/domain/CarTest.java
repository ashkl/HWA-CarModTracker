package com.qa.hwa.domain;

import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

public class CarTest {

	@Test
	public void testEquals() {
		Modification mod1 = new Modification(2, "Exhaust", "Catback Exhaust", "15/11/2018", 40000L, 370.00, null);
		
		Modification mod2 = new Modification(3, "Splitter", "TRC Front Splitter", "26/01/2020", 60000L, 370.00, null);
		
		EqualsVerifier.simple().forClass(Car.class)
		.withRedefinedSuperclass()
		.withPrefabValues(Modification.class, mod1, mod2)
		.suppress(Warning.ALL_FIELDS_SHOULD_BE_USED).verify();
	}
}
