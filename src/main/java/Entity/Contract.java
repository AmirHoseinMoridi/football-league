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
    public static final String PRICE = "price";
    public static final String YEAR = "year";
    public static final String TEAM = "team";
    public static final String PERSON = "person";

    Double price;

    Year year;

    @ManyToOne
    Team team;

    @ManyToOne
    Person person;
}
