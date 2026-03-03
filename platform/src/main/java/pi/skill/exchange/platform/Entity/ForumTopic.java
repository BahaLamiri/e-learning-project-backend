package pi.skill.exchange.platform.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter @Setter
public class ForumTopic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Long viewCount = 0L;
    private boolean pinned;

    @Enumerated(EnumType.STRING)
    private TopicStatus status;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private ForumCategory category;

    @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL)
    private List<Message> messages;
}