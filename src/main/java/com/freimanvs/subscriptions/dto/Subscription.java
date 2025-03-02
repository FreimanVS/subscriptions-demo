package com.freimanvs.subscriptions.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.context.annotation.Lazy;

import java.time.LocalDate;
import java.util.List;

@Entity(name = "subscriptions")
@Data
@NoArgsConstructor
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "subscriptions_generator")
    @SequenceGenerator(name = "subscriptions_generator", sequenceName = "subscriptions_seq", allocationSize = 1)
    private Long id;
    @NotBlank
    @Size(min = 3, max = 50)
    private String name;
//    @NotBlank
//    private LocalDate activation_date;
//    @NotBlank
//    private LocalDate expire_date;
    @ManyToMany(mappedBy = "subscriptions", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<@Valid User> users;

    @Override
    public String toString() {
        return "Subscription{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
