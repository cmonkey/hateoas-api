package org.excavator.hateoas.api.controller

import java.util

import org.excavator.hateoas.api.entity.Person
import org.excavator.hateoas.api.exception.NotFoundException
import org.excavator.hateoas.api.repository.PersonRepository
import org.excavator.hateoas.api.resource.PersonResource
import org.slf4j.LoggerFactory
import org.springframework.hateoas.{Link, Resources}
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.{DeleteMapping, GetMapping, PathVariable, PostMapping, PutMapping, RequestBody, RequestMapping, RestController}
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder
import org.springframework.web.servlet.support.ServletUriComponentsBuilder

@RestController
@RequestMapping(value = Array("/people"), produces = Array("application/hal+json"))
class PersonController(val personRepository: PersonRepository) {

  val logger = LoggerFactory.getLogger(classOf[PersonController])

  @GetMapping
  def all(): ResponseEntity[Resources[PersonResource]] = {
    val collection:java.util.List[PersonResource] = new util.ArrayList[PersonResource]()

      personRepository.findAll()
      .stream().forEach(person => {
        logger.info("person = {}", person)
        collection.add(new PersonResource(person))
      })

    val resources = new Resources[PersonResource](collection)

    val uriString = ServletUriComponentsBuilder.fromCurrentRequest().build().toUriString
    resources.add(new Link(uriString, "self"))
    ResponseEntity.ok(resources)
  }

  @GetMapping(Array("/{id}"))
  def get(@PathVariable id: Long): ResponseEntity[PersonResource] = {

    val optional = personRepository.findById(id)

    var r: ResponseEntity[PersonResource] = null

    if(optional.isPresent){
      r = ResponseEntity.ok(new PersonResource(optional.get()))
    }else{
      new NotFoundException(id)
    }

    r
  }

  @PostMapping
  def post(@RequestBody person: Person): ResponseEntity[PersonResource] = {

    personRepository.save(person)

    val uri = MvcUriComponentsBuilder.fromController(getClass)
      .path("/{id}")
      .buildAndExpand(person.id.asInstanceOf[Object])
      .toUri

    ResponseEntity.created(uri).body(new PersonResource(person))

  }

  @PutMapping(Array("/{id}"))
  def put(@PathVariable id: Long, @RequestBody person: Person): ResponseEntity[PersonResource] = {

    person.copy(id)
    personRepository.save(person)

    val resource = new PersonResource(person)

    val uri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri

    ResponseEntity.created(uri).body(resource)
  }

  @DeleteMapping(Array("/{id}"))
  def delete(@PathVariable id:Long): ResponseEntity[Any] = {

    val optional = personRepository.findById(id)
    var r: ResponseEntity[Any] = null
    if(optional.isPresent){
      personRepository.deleteById(id)
      r = ResponseEntity.noContent().build()
    }else{
      new NotFoundException(id)
    }

    r
  }
}
