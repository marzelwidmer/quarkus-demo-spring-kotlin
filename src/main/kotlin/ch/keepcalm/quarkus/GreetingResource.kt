package ch.keepcalm.quarkus

import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/greeting")
class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    fun hello() = "hello...."
}




@RestController
@RequestMapping(value = ["/foo"])
class HelloResource {

    @GetMapping
    fun hello() = " Bar... !"

}




@RestController
@RequestMapping("/hello")
class GreetingController(private val greetingService: GreetingService) {

    @GetMapping("/{name}")
    fun hello(@PathVariable(name = "name") name: String): Greeting {
        return Greeting(greetingService.greet(name))
    }
}


class Greeting(val message: String)


@Service
class GreetingService{
    fun greet(input: String): String {
        return "HELLO " + input.toUpperCase() + "!...."
    }
}
