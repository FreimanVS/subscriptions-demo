package com.freimanvs.subscriptions.controllers.v1.impls;

import com.freimanvs.subscriptions.controllers.v1.CommonController;
import com.freimanvs.subscriptions.dto.Subscription;
import com.freimanvs.subscriptions.dto.User;
import com.freimanvs.subscriptions.services.impls.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:8085")
public class UserController implements CommonController<User> {

    private final UserService userService;

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@Valid @RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User getById(@PathVariable Long id) {
        return userService.getById(id);
    }


    @PutMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User update(@PathVariable Long id,
                           @Valid @RequestBody User user) {
        return userService.update(id, user);
    }

    @DeleteMapping("/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }

    @GetMapping("/users/{id}/subscriptions")
    @ResponseStatus(HttpStatus.OK)
    public List<Subscription> getUserSubscriptions(@PathVariable Long id) {
        return userService.getUserSubscriptions(id);
    }

    @PostMapping("/users/{id}/subscriptions/{sub_id}")
    @ResponseStatus(HttpStatus.CREATED)
    public User saveUserSubscription(@PathVariable Long id,
                                     @PathVariable Long sub_id) {
        return userService.saveUserSubscription(id, sub_id);
    }

    @DeleteMapping("/users/{id}/subscriptions/{sub_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUserSubscription(@PathVariable Long id,
                                       @PathVariable Long sub_id) {
        userService.deleteUserSubscription(id, sub_id);
    }
}
