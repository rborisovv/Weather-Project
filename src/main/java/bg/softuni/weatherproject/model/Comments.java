package bg.softuni.weatherproject.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class Comments extends BaseEntity {
    @Column(nullable = false)
    @NonNull
    private Boolean approved;

    @Column
    private LocalDateTime created;

    @Column(name = "text_content", columnDefinition = "TEXT")
    private String textContent;

    @ManyToOne
    @NonNull
    private User author;

    @ManyToOne
    @NonNull
    private Route route;
}