package org.excavator.hateoas.api.entity

import java.time.Duration

case class Person(id: Long, firstName: String, secondName:String, dateOfBirth: Duration, profession: String, salary: Int)

