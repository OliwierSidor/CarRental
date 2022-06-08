package pl.sda.arppl4.rental.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Samochod {
    private String numerRejstracyjny;
    private SkrzyniaBiegow skrzynia;
    private TypNadwozia typ;
    private StatusSamochodu status;
    private Double cena;
}
