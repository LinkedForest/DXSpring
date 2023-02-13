package com.dxspring.dxspring.user;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(path= "/api/v1/users")
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping
    public void createUser(@RequestBody User user) {
        userService.createUser(user);
    }

    @GetMapping(path = "{UserId}")
    public User getUser(@PathVariable("UserId") Integer id) {
        return userService.getUser(id);
    }

    @PutMapping(path = "{UserId}")
    public void updateUser(
            @PathVariable("UserId") Integer id,
            @RequestParam(required = false) String firstname,
            @RequestParam(required = false) String lastname,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String password
    ) {
        userService.updateUser(id, firstname, lastname, email, password);
    }

    @DeleteMapping(path = "{UserId}")
    public void deleteUser(@PathVariable("UserId") Integer id) {
        userService.deleteUser(id);
    }
}
