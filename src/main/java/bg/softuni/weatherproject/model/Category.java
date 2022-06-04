package bg.softuni.weatherproject.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "categories")
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class Category extends BaseEntity {
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    @NonNull
    private bg.softuni.weatherproject.enums.Category name;

    @Column(nullable = false)
    @NonNull
    private String description;
}