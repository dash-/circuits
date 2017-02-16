package io.github.dash.circuits;

import static org.junit.Assert.*;
import io.github.dash.circuits.ComponentType;

import org.junit.Test;

public class ComponentTypeTest {

	@Test
	public void test() {
		ComponentType componentType = new ComponentType(8, 1);
		assertEquals(8, componentType.inputCount);
		assertEquals(1, componentType.outputCount);
	}

}
