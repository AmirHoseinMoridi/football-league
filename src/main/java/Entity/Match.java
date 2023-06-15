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
public class Match extends BaseEntity {
    public static final String GUEST = "guest";
    public static final String HOST = "host";
    public static final String GUESTS_GOALS = "guestsGoals";
    public static final String HOSTS_GOALS = "hostsGoals";

    @ManyToOne
    @Column(nullable = false)
    Team guest;

    @ManyToOne
    @Column(nullable = false)
    Team host;

    @Column(nullable = false)
    int guestsGoals;

    @Column(nullable = false)
    int hostsGoals;


}
