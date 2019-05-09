package org.excavator.hateoas.api.repository

import java.time.Duration
import java.util

import javax.annotation.PostConstruct
import org.excavator.hateoas.api.entity.Person
import org.springframework.stereotype.Component

@Component
class PersonRepository {
  def deleteById(id: Long) = {
    persons.removeIf(p => p.id == id)
  }

  def save(person: Person) = {
    persons.add(person)
  }

  def findById(id: Long) = {
    persons.stream().filter(person => person.id == id).findFirst()
  }

  val persons = new util.ArrayList[Person]()

  def findAll() = {
    persons
  }

  @PostConstruct
  def init(): Unit = {
    java.util.stream.IntStream.range(0, 1000).forEach(i => {

      val person = new Person(i, "firstName", "secondName", Duration.ofDays(i), "profession", 1)
      persons.add(person)
    })
  }

}
