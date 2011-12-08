package pl.caltha.osgi.bndtools.impl;

import pl.caltha.osgi.bndtools.api.Greeting;
import aQute.bnd.annotation.component.Component;

@Component
public class GreetingImpl implements Greeting {
	@Override
	public String sayHello(String name) {
		return "Hello " + name + "!";
	}
}
