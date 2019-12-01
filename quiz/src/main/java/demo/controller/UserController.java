package demo.controller;

import demo.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/user")
    public String user(@RequestParam(value = "name", defaultValue = "Tom") String name) {
        int nums = this.userService.getTotalNumbersForName(name);
        return String.format("{name\": %s, \"TotalNumbers\": %d}", name, nums);
    }
}
