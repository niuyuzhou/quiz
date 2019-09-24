package demo.controller;

import demo.entity.Greeting;
import demo.entity.User;
import demo.entity.UserRequest;
import demo.entity.UserSearchResult;
import demo.exception.NoUserFoundException;
import demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private UserService userService;

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }

    @RequestMapping(path = "/name",method = {RequestMethod.POST })
    public UserSearchResult retrieveByName(@RequestBody UserRequest user) {
        String name = user.getName();
        int totalNumber = userService.getTotalNumbersForName(name);
        if (totalNumber >0) {
            UserSearchResult result = new UserSearchResult();
            result.setName(name);
            result.setTotalNumbers(totalNumber);
            return result;
        } else {
            // TODO if 0 result is fine, just remove this code.
            throw new NoUserFoundException();
        }
    }
}
