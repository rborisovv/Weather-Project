package bg.softuni.weatherproject.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class Messages extends BaseEntity {
    @Column(name = "date_time")
    private LocalDateTime dateTime;

    @Column(name = "text_content", columnDefinition = "TEXT")
    private String textContent;

    @ManyToOne
    @NonNull
    private User author;

    @ManyToOne
    @NonNull
    private User recipient;
}