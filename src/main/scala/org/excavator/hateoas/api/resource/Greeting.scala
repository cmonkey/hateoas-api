package org.excavator.hateoas.api.resource

import org.springframework.hateoas.ResourceSupport

case class Greeting(content: String) extends ResourceSupport
