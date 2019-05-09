package org.excavator.hateoas.api.controller

import org.excavator.hateoas.api.resource.Greeting
import org.springframework.http.{HttpEntity, HttpStatus, ResponseEntity}
import org.springframework.web.bind.annotation.{RequestMapping, RequestParam, RestController}
import org.springframework.hateoas.mvc.ControllerLinkBuilder._

@RestController
class GreetingController{

  val template = "Hello, %s!"

  @RequestMapping(Array("/greeting"))
  def greeting(@RequestParam(value = "name", required = false, defaultValue = "World") name: String): HttpEntity[Greeting] = {

    val greeting = Greeting(String.format("template", name))

    greeting.add(linkTo(methodOn(classOf[GreetingController]).greeting(name)).withSelfRel())

    new ResponseEntity(greeting, HttpStatus.OK)

  }

}
