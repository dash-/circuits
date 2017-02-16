///
// Import boilerplate
///

import java.nio.file.Paths;
@groovy.transform.SourceURI def sourceURI
def __DIR__ = Paths.get(sourceURI.getPath()).getParent();

public getClass(__DIR__, relativePath) {
	return new GroovyClassLoader(
		getClass().getClassLoader()
	).parseClass(new File(
		__DIR__.resolve(relativePath).toString()
	));
}


///
// Test setup
///

def Component = getClass(__DIR__, "../Component.groovy");

def component = Component.newInstance(8, 1);
def childComponent = Component.newInstance(1, 1);

component.setOutput(0, 0, childComponent);

component.receiveInputs([1, 1, 1, 1, 1, 1, 1, 1]);


///
// Tests
///

assert component.getComponentType().getInputCount() == 8;
assert component.getComponentType().getOutputCount() == 1;


///
// Success boilerplate
///

println 'Tests successful.';
