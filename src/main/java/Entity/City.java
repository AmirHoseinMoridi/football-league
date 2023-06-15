package Entity;

import Base.Entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class City extends BaseEntity {
    public static final String NAME = "name";


    @Column(nullable = false)
    String name;
}
