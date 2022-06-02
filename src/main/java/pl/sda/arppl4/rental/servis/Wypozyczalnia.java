package pl.sda.arppl4.rental.servis;

import pl.sda.arppl4.rental.model.Samochod;
import pl.sda.arppl4.rental.model.SkrzyniaBiegow;
import pl.sda.arppl4.rental.model.StatusSamochodu;
import pl.sda.arppl4.rental.model.TypNadwozia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Wypozyczalnia {
    private Map<String, Samochod> pojazdy = new HashMap<>();

    public void dodajSamochod(String numerRejstracyjny, SkrzyniaBiegow skrzyniaBiegow, TypNadwozia typNadwozia, StatusSamochodu statusSamochodu) {
        if (!pojazdy.containsKey(numerRejstracyjny)) {
            pojazdy.put(numerRejstracyjny, new Samochod(numerRejstracyjny, skrzyniaBiegow, typNadwozia, statusSamochodu));
        }
    }

    public List<Samochod> zwrocListe() {
        return new ArrayList<>(pojazdy.values());
    }

    public List<Samochod> zwrocListeDostepnych() {
        List<Samochod> listaDostepnych = new ArrayList<>();
        for (Samochod pojazd : pojazdy.values()) {
            if (pojazd.getStatus() == StatusSamochodu.DOSTEPNY) {
                listaDostepnych.add(pojazd);
            }
        }
        return listaDostepnych;
    }

    public List<Samochod> zwrocListeWynajetych() {
        List<Samochod> listaDostepnych = new ArrayList<>();
        for (Samochod pojazd : pojazdy.values()) {
            if (pojazd.getStatus() == StatusSamochodu.WYNAJETY) {
                listaDostepnych.add(pojazd);
            }
        }
        return listaDostepnych;
    }

    public void usunSamochod(String numerRejstracyjny) {
        pojazdy.get(numerRejstracyjny).setStatus(StatusSamochodu.NIEDOSTEPNY);
    }
}
