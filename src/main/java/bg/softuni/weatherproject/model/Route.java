package bg.softuni.weatherproject.model;

import bg.softuni.weatherproject.enums.Level;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "routes")
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class Route extends BaseEntity {
    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "gpx_coordinates", columnDefinition = "LONGTEXT", nullable = false)
    @NonNull
    private String gpxCoordinates;

    @Enumerated(EnumType.STRING)
    private Level level;

    @Column(nullable = false, unique = true)
    @NonNull
    private String name;

    @ManyToOne
    @NonNull
    private User author;

    @Column(name = "video_url")
    private String videoUrl;

    @ManyToMany
    private Set<Category> categories;
}