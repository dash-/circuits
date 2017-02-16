package io.github.dash.circuits.components.binary;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.BitSet;

import io.github.dash.circuits.Component;
import io.github.dash.circuits.EndpointComponent;
import io.github.dash.circuits.TerminatorComponent;
import io.github.dash.circuits.components.binary.*;

public class BCTest {

	@Test
	public void test() {
		///
		// Setup
		///
		
		EndpointComponent start = new EndpointComponent(2);
		TerminatorComponent finish = new TerminatorComponent(1);
		Component[] components = { new BC00(), new BC01(), new BC02() };
		long[] input = { 3 };
		
		start.setOutput(0, 0, components[0]);
		start.setOutput(1, 1, components[0]);
		start.setOutput(0, 0, components[1]);
		start.setOutput(1, 1, components[1]);
		
		components[0].setOutput(0, 0, components[2]);
		components[1].setOutput(0, 1, components[2]);

		components[2].setOutput(0, 0, finish);
		
		start.receiveInputs(BitSet.valueOf(input));
		
		
		///
		// Assertions
		///
		
		assertEquals(1234, finish.getResult().hashCode());
	}

}
