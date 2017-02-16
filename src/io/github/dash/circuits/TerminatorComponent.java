package io.github.dash.circuits;

import java.util.BitSet;

public class TerminatorComponent extends EndpointComponent {
	///
	// Attributes
	///
	
	protected BitSet result;
	
	///
	// Constructors
	///
	
	public TerminatorComponent(int inputCount) {
		super(inputCount);
	}
	
	
	///
	// Accessors
	///
	
	public BitSet getResult() {
		return this.result.get(0, this.componentType.getInputCount());
	}
	
	
	///
	// Overrides
	///
	
	protected void sendOutput(BitSet values) {
		this.result = values;
		
		super.sendOutput(values);
	}
}
