package io.github.dash.circuits;

import static org.junit.Assert.*;

import org.junit.Test;
import io.github.dash.circuits.Component;

import java.util.HashMap;
import java.util.BitSet;

public class ComponentTest {

	@Test
	public void test() {
		Component component = new Component(8, 1);
		Component childComponent = new Component(1, 1);

		component.setOutput(0, 0, childComponent);

		BitSet inputs = new BitSet(8);
		inputs.set(0, 8);		

		component.receiveInputs(inputs);


		///
		// Tests
		///

		assertEquals(8, component.getComponentType().getInputCount());
		assertEquals(1, component.getComponentType().getOutputCount());
	}

}
