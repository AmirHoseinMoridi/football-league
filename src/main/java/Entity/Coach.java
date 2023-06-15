package Entity;

import jakarta.persistence.*;
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
@DiscriminatorValue("1")
public class Coach extends Person {
    public static final String TEAM = "team";

    @ManyToOne
    Team team;
}
