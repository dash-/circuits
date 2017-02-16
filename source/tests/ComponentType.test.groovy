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

def ComponentType = getClass(__DIR__, "../ComponentType.groovy");

def ct = ComponentType.newInstance(8, 1);


///
// Tests
///

assert ct.getInputCount() == 8;
assert ct.getOutputCount() == 1;


///
// Success boilerplate
///

println 'Tests successful.';
