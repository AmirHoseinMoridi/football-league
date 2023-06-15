package Entity;

import Base.Entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
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
public abstract class Person extends BaseEntity {
    public static final String NAME = "name";

    @Column(nullable = false)
    String name;
}
