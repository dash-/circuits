package io.github.dash.circuits;

import java.util.HashMap;

public class EndpointComponent extends Component {
	///
	// Constructors
	///
	
	public EndpointComponent(int outputCount) {
		super(outputCount, outputCount);
	}
	
	
	///
	// Processing
	///
	
	protected HashMap process(HashMap inputValues) {
		return inputValues;
	}
}
