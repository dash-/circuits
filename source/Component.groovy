
class Component {
	private ComponentType = this.getClass('source/ComponentType.groovy');


	///
	// Attributes
	///

	protected componentType;
	protected outputs = [];

	protected inputValues = [];


	///
	// Construction
	///

	public Component() {
	}

	public Component(inputCount, outputCount) {
		this.componentType = ComponentType.newInstance(inputCount, outputCount);
	}

	public Component(componentType) {
		this.componentType = componentType;
	}


	///
	// Public interface
	///

	public getComponentType() {
		return this.componentType;
	}

	public setOutput(int outputIndex, int inputIndex, Component component) {
		assert outputIndex > -1;
		assert outputIndex < this.componentType.getOutputCount();
		assert inputIndex > -1;
		assert inputIndex < component.getComponentType().getInputCount();

		if(! this.outputs[outputIndex]) {
			this.outputs[outputIndex] = [];
		}

		this.outputs[outputIndex].push([
			inputIndex: inputIndex,
			component: component,
		]);
	}

	public receiveInput(int inputIndex, value) {
		int inputCount = this.componentType.getInputCount();
		assert inputIndex > -1;
		assert inputIndex < inputCount;
		this.inputValues[inputIndex] = value;

		if(this.inputValues.size() == inputCount) {
			def outputValues = this.process(this.inputValues);
			this.sendOutput(outputValues);
			this.inputValues = [];
		}
	}

	public receiveInputs(values) {
		int inputCount = this.componentType.getInputCount();
		assert values.size() == inputCount;

		def outputValues = this.process(values);
		this.sendOutput(outputValues);
	}


	///
	// Helpers
	///

	public sendOutput(values) {
		int outputCount = this.componentType.getOutputCount();
		assert values.size() == outputCount;

		this.outputs.eachWithIndex { receivers, index ->
			receivers.each {
				it.component.receiveInput(it.inputIndex, values[index]);
			};
		};
	}


	///
	// "Abstract" methods for overriding
	///

	public process(inputValues) {
		int outputCount = this.getComponentType().getOutputCount();
		def outputValues = [];

		for(def outputIdx = 0; outputIdx < outputCount; outputIdx++) {
			outputValues.push(0);
		}

		return outputValues;
	}


	///
	// Import boilerplate
	///

	private getClass(path) {
		return new GroovyClassLoader(
			getClass().getClassLoader()
		).parseClass(new File(path));
	}
}
