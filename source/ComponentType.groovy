
class ComponentType {
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

	public getInputCount() {
		return this.inputCount;
	}

	public getOutputCount() {
		return this.outputCount;
	}
}
