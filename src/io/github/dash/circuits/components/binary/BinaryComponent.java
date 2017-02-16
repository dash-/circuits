package io.github.dash.circuits.components.binary;

import io.github.dash.circuits.Component;
import java.util.HashMap;
import java.util.BitSet;

public class BinaryComponent extends Component {
	///
	// Constructors
	///
	
	public BinaryComponent() {
		super(2, 1);
	}
	
	
	///
	// Processing
	///

	protected BitSet process(BitSet inputValues) {
		HashMap mappings = this.getMappings();
		BitSet outputValues = new BitSet();
		outputValues.set(0, (boolean) mappings.get(inputValues));
		return outputValues;
	}

	protected HashMap getMappings() {
		return new HashMap();
	}
	
	
	///
	// Helpers
	///
	
	protected int hashOf(long n) {
		long[] longList = {n};
		return BitSet.valueOf(longList).hashCode();
	}
}
