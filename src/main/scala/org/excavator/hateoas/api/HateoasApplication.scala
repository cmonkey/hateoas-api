package org.excavator.hateoas.api

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class HateoasApplication {

}

object HateoasApplication{

  def main(args: Array[String]): Unit = {
    SpringApplication.run(classOf[HateoasApplication], args:_*)
  }
}
