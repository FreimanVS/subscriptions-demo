package com.freimanvs.subscriptions.controllers.v1.impls;

import com.freimanvs.subscriptions.controllers.v1.CommonController;
import com.freimanvs.subscriptions.dto.Subscription;
import com.freimanvs.subscriptions.services.impls.SubscriptionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:8085")
public class SubscriptionController implements CommonController<Subscription> {

    private final SubscriptionService subscriptionService;

    @PostMapping("/subscriptions")
    @ResponseStatus(HttpStatus.CREATED)
    public Subscription save(@Valid @RequestBody Subscription subscription) {
        return subscriptionService.save(subscription);
    }

    @GetMapping("/subscriptions/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Subscription getById(@PathVariable Long id) {
        return subscriptionService.getById(id);
    }


    @PutMapping("/subscriptions/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Subscription update(@PathVariable Long id,
                           @Valid @RequestBody Subscription subscription) {
        return subscriptionService.update(id, subscription);
    }

    @DeleteMapping("/subscriptions/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        subscriptionService.delete(id);
    }

    @GetMapping("/subscriptions/top")
    @ResponseStatus(HttpStatus.OK)
    public List<Subscription> getTopThree() {
        return subscriptionService.getTopThree();
    }
}
