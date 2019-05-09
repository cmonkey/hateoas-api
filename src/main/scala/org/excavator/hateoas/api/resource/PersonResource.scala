package org.excavator.hateoas.api.resource;

import lombok.Getter;
import org.excavator.hateoas.api.controller.PersonController;
import org.excavator.hateoas.api.entity.Person;
import org.springframework.hateoas.ResourceSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Getter
public class PersonResource extends ResourceSupport {

    private Person person;

    public PersonResource(Person person) {
        this.person = person;
        long id = person.id();

        add(linkTo(PersonController.class).withRel("people"));
        add(linkTo(methodOn(PersonController.class).get(id)).withSelfRel());
    }
}
