package pl.caltha.osgi.bndtools.m2e.impl;

import pl.caltha.osgi.bndtools.m2e.api.Greeting;
import aQute.bnd.annotation.component.Component;

@Component
public class GreetingImpl implements Greeting {	
	public String sayHello(String name) {
		return "Hello " + name + "!";
	}
}
