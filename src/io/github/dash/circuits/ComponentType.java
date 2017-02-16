package io.github.dash.circuits;

public class ComponentType {
	///
	// Attributes
	///

	protected int inputCount;
	protected int outputCount;


	///
	// Construction
	///

	public ComponentType(int inputCount, int outputCount) {
		this.inputCount = inputCount;
		this.outputCount = outputCount;
	}


	///
	// Accessors
	///

	public int getInputCount() {
		return this.inputCount;
	}

	public int getOutputCount() {
		return this.outputCount;
	}
}
