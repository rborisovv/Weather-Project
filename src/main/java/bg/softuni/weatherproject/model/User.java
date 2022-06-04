package bg.softuni.weatherproject.model;


import bg.softuni.weatherproject.enums.Level;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    @NonNull
    private String username;

    @Column(nullable = false)
    @NonNull
    private String password;

    @Column(name = "full_name")
    @NonNull
    private String fullName;

    @Column
    private Integer age;

    @Column(unique = true)
    private String email;

    @ManyToMany(fetch = FetchType.EAGER)
    @NonNull
    private Set<Role> roles;

    @Enumerated(EnumType.STRING)
    @NonNull
    private Level level;
}