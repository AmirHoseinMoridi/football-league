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
public class Match extends BaseEntity {


    @ManyToOne
    Team guest;

    @ManyToOne
    Team host;

    Year year;
    Integer guestsGoals = 0;


    Integer hostsGoals = 0;


    public void addGuestsGoals(){
        this.guestsGoals++;
    }
    public void addHostsGoals(){
        this.hostsGoals++;
    }


}
