package io.github.dash.circuits.components.binary;

import java.util.HashMap;
import java.util.BitSet;

final public class BC02 extends BinaryComponent {
	protected HashMap getMappings() {
		HashMap mappings = new HashMap();
		
		mappings.put(this.hashOf(0), false);
		mappings.put(this.hashOf(1), false);
		mappings.put(this.hashOf(2), true);
		mappings.put(this.hashOf(3), false);
		
		return mappings;
	}
}
