package Entity;

import Base.Entity.BaseEntity;
import jakarta.persistence.Column;
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

    @Column(nullable = false)
    Double price;

    @Column(nullable = false)
    Year year;


    @ManyToOne
    @Column(nullable = false)
    Team team;

    @ManyToOne
    @Column(nullable = false)
    Person person;
}
