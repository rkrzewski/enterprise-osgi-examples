package pl.caltha.osgi.bndtools.scala.impl

import aQute.bnd.annotation.metatype.Meta

@Meta.OCD
trait GreetingConfig {
	def pattern(): String
}