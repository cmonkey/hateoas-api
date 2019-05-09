package org.excavator.hateoas.api.controller

import org.excavator.hateoas.api.entity.{Person, PersonResource}
import org.excavator.hateoas.api.repository.PersonRepository
import org.springframework.hateoas.Resources
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.{DeleteMapping, GetMapping, PathVariable, PostMapping, PutMapping, RequestBody, RequestMapping, RestController}

@RestController
@RequestMapping(value = Array("/people"), produces = Array("application/hal+json"))
class PersonController(val personRepository: PersonRepository) {

  @GetMapping
  def all(): ResponseEntity[Resources[PersonResource]] = {
    // Get all
  }

  @GetMapping("/{id}")
  def get(@PathVariable id: Long): ResponseEntity[PersonResource] = {

  }

  @PostMapping
  def post(@RequestBody person: Person): ResponseEntity[PersonResource] = {

  }

  @PutMapping("/{id}")
  def put(@PathVariable id: Long, @RequestBody person: Person): ResponseEntity[PersonResource] = {

  }

  @DeleteMapping("/{id}")
  def delete(@PathVariable id:Long): ResponseEntity[_] = {

  }
}
