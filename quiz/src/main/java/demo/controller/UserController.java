package demo.controller;

import demo.entity.ResponseEntity;
import demo.entity.User;
import demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * The type User controller.
 */
@RestController
public class UserController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    @Autowired
    private UserService userService;

    /**
     *
     * Returns the user name and number of users for that name.
     * User response entity.
     * @param user the user
     * @return the response entity
     */
    @RequestMapping(value = "/user", method = {RequestMethod.POST},
            consumes = {"application/json"})
    public ResponseEntity user(@RequestBody User user) {

        ResponseEntity responseEntity = new ResponseEntity();
        if(user != null) {
            String name = user.getName();
            responseEntity.setName(name);
            int number = 0;
            if (name != null) {
                number = userService.getTotalNumbersForName(name);
            }
            responseEntity.setNumber(number);
        }
        return responseEntity;
    }

}
