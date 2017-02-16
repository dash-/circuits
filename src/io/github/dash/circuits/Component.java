package io.github.dash.circuits;

import io.github.dash.circuits.ComponentType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.BitSet;

public class Component {
	///
	// Attributes
	///

	protected ComponentType componentType;
	protected HashMap outputs = new HashMap();
	protected BitSet inputValues = new BitSet();
	protected HashMap receptions = new HashMap();
	

	///
	// Construction
	///

	public Component() {
		this(2, 1);
	}

	public Component(int inputCount, int outputCount) {
		this(new ComponentType(inputCount, outputCount));
	}

	public Component(ComponentType componentType) {
		this.componentType = componentType;
	}


	///
	// Public interface
	///

	public ComponentType getComponentType() {
		return this.componentType;
	}

	public void setOutput(int outputIndex, int inputIndex, Component component) {
		assert outputIndex > -1;
		assert outputIndex < this.componentType.getOutputCount();
		assert inputIndex > -1;
		assert inputIndex < component.getComponentType().getInputCount();

		if(this.outputs.get(outputIndex) == null) {
			this.outputs.put(outputIndex, new ArrayList());
		}

		HashMap receiver = new HashMap(2);
		receiver.put("inputIndex", inputIndex);
		receiver.put("component", component);
		
		((ArrayList) this.outputs.get(outputIndex)).add(receiver);
	}

	public void receiveInput(int inputIndex, boolean value) {
		int inputCount = this.componentType.getInputCount();
		assert inputIndex > -1;
		assert inputIndex < inputCount;
		this.inputValues.set(inputIndex, value);
		
		this.receptions.put(inputIndex, true);

		if(this.receptions.size() == inputCount) {
			BitSet outputValues = this.process(
				this.inputValues.get(0, this.componentType.getInputCount())
			);
			this.inputValues.clear();
			this.receptions.clear();
			this.sendOutput(outputValues);
		}
	}

	public void receiveInputs(BitSet values) {
		BitSet outputValues = this.process(
			values.get(0, this.componentType.getInputCount())
		);
		this.sendOutput(outputValues);
	}


	///
	// Helpers
	///

	protected void sendOutput(BitSet values) {
		for(int outIdx = 0; outIdx < this.outputs.size(); outIdx++) {
			ArrayList receivers = (ArrayList) this.outputs.get(outIdx);
			for(int recIdx = 0; recIdx < receivers.size(); recIdx++) {
				HashMap receiver = (HashMap) receivers.get(recIdx);
				Component component = (Component) receiver.get("component");
				int inputIndex = (int) receiver.get("inputIndex");
				boolean value = values.get(outIdx);
				component.receiveInput(inputIndex, value);
			}
		}
	}


	///
	// Placeholder processing - Should be overrided
	///

	protected BitSet process(BitSet inputValues) {
		int outputCount = this.getComponentType().getOutputCount();
		BitSet outputValues = new BitSet();

		for(int outputIdx = 0; outputIdx < outputCount; outputIdx++) {
			outputValues.set(outputIdx, 0);
		}

		return outputValues;
	}
}
