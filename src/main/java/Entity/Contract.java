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


    @Column(nullable = false)
    Double price;

    @Column(nullable = false)
    Year year;


    @ManyToOne
    Team team;

    @ManyToOne
    Person person;
}
