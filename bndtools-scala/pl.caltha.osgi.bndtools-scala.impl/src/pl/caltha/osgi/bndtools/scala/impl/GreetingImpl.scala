package pl.caltha.osgi.bndtools.scala.impl

import pl.caltha.osgi.bntools.scala.api.Greeting
import aQute.bnd.annotation.component.Component
import aQute.bnd.annotation.component.Activate
import aQute.bnd.annotation.metatype.Configurable

@Component(designate = classOf[GreetingConfig])
class GreetingImpl extends Greeting {

  var config: GreetingConfig = null

  @Activate
  def activate(properties: java.util.Map[_, _]) = {
    config = Configurable.createConfigurable(classOf[GreetingConfig], properties)
  }

  def sayHello(name: String): String = {
    if (config != null) {
      config.pattern().format(name);
    } else {
      "Greeting not configured, sorry!"
    }
  }

}