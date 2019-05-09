package org.excavator.hateoas.api.resource;

import org.excavator.hateoas.api.controller.PersonController
import org.excavator.hateoas.api.entity.Person
import org.springframework.hateoas.ResourceSupport
import org.springframework.hateoas.mvc.ControllerLinkBuilder._

class PersonResource(person: Person) extends ResourceSupport {
      add(linkTo(classOf[PersonController]).withRel("people"));
      add(linkTo(methodOn(classOf[PersonController]).get(person.id)).withSelfRel());
}
