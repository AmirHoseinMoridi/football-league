package Entity;

import Base.Entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Year;

@Getter
@Setter
@ToString
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Contract extends BaseEntity {
    Double price;

    Year year;

    @ManyToOne
    Team team;

    @ManyToOne
    Person person;
}
