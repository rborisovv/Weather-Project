package bg.softuni.weatherproject.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class Role extends BaseEntity {
    @Enumerated(EnumType.STRING)
    @NonNull
    private bg.softuni.weatherproject.enums.Role role;
}