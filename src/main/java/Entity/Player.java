package Entity;

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
public class Player extends Person {
    public static final String TEAM = "team";


    @ManyToOne
    Team team;
}
