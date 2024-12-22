package railway.model;

import lombok.*;
import railway.types.Station;
import railway.types.Status;

@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Filter {
    private Station departStation;
    private Station arriveStation;
    private String departDate;
    private Status status;
}
