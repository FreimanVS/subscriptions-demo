package com.freimanvs.subscriptions.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Entity(name = "subscriptions")
@Table(name = "subscriptions")
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

    @ManyToMany(mappedBy = "subscriptions", fetch = FetchType.LAZY)
    @JsonIgnore
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<User> users;
}
