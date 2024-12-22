package railway.model;

import lombok.*;
import railway.types.SeatType;
import railway.types.Station;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Ticket {
    private LocalDate departDate;
    private Station departFrom;
    private Station arriveAt;
    private SeatType seatType;
    private int amount;
}
