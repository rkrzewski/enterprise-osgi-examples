package pl.caltha.osgi.bndtools.impl;

import junit.framework.TestCase;
import pl.caltha.osgi.bndtools.api.Greeting;

public class GreetingImplTest extends TestCase {
	public void testGreeting() {
		Greeting greeting = new GreetingImpl();
		assertEquals("Hello world!", greeting.sayHello("world"));
	}
}
