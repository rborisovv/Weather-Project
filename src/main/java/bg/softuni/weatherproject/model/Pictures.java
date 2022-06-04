package bg.softuni.weatherproject.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pictures")
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class Pictures extends BaseEntity {
    @Column(nullable = false)
    @NonNull
    private String title;

    @Column(nullable = false, unique = true, columnDefinition = "TEXT")
    @NonNull
    private String url;

    @ManyToOne
    @NonNull
    private User author;

    @ManyToOne
    @NonNull
    private Route route;
}