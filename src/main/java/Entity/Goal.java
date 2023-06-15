package Entity;

import Base.Entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@ToString
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Goal extends BaseEntity {
    public static final String PLAYER = "player";
    public static final String MATCH = "match";

    @ManyToOne
    @Column(nullable = false)
    Player player;

    @ManyToOne
    @Column(nullable = false)
    Match match;

}
