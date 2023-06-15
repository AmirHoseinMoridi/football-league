package Entity;

import Base.Entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Inheritance
@DiscriminatorColumn(name = "person_type",
        discriminatorType = DiscriminatorType.INTEGER )

public abstract class Person extends BaseEntity {
    public static final String NAME = "name";

    @Column(nullable = false)
    String name;
}
