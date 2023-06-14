package Entity;

import Base.Entity.BaseEntity;
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

    @ManyToOne
    Team guest;

    @ManyToOne
    Team host;

    int guestsGoals;

    int hostsGoals;


}
