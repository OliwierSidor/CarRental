package pl.sda.arppl4.rental.servis;

import pl.sda.arppl4.rental.model.Samochod;
import pl.sda.arppl4.rental.model.StatusSamochodu;

import java.util.*;

public class Wypozyczalnia {
    private Map<String, Samochod> pojazdy = new HashMap<>();
    private List<Samochod> archiwumWypozyczen = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void dodajSamochod(Samochod samochod) {
        if (!pojazdy.containsKey(samochod.getNumerRejstracyjny())) {
            pojazdy.put(samochod.getNumerRejstracyjny().toUpperCase(), samochod);
        }
    }

    public void usunSamochod(String numerRejstracyjny) {
        pojazdy.get(numerRejstracyjny).setStatus(StatusSamochodu.NIEDOSTEPNY);
    }

    public void wynajmijSamochod(String numerRejstracyjny) {
        if (pojazdy.containsKey(numerRejstracyjny) && pojazdy.get(numerRejstracyjny).getStatus() != StatusSamochodu.WYNAJETY) {
            Samochod samochod = pojazdy.get(numerRejstracyjny);
            samochod.setStatus(StatusSamochodu.WYNAJETY);
            archiwumWypozyczen.add(samochod);
        }
    }

    public void wynajmijSamochod() {
        System.out.println("Podaj numer rejstracyjny");
        String numerRejstracyjny = scanner.next();
        wynajmijSamochod(numerRejstracyjny);
    }

    public void oddajSamochod(String numerRejstracyjny) {
        if (pojazdy.containsKey(numerRejstracyjny) && pojazdy.get(numerRejstracyjny).getStatus() == StatusSamochodu.WYNAJETY) {
            Samochod samochod = pojazdy.get(numerRejstracyjny);
            samochod.setStatus(StatusSamochodu.DOSTEPNY);
        }
    }

    public void oddajSamochod() {
        System.out.println("Podaj numer rejstracyjny");
        String numerRejstracyjny = scanner.next();
        oddajSamochod(numerRejstracyjny);
    }

    public List<Samochod> zwrocListeWszystkich() {
        return new ArrayList<>(pojazdy.values());
    }

    private List<Samochod> zwrocArchiwumWynajmow() {
        return archiwumWypozyczen;
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
        List<Samochod> listaWynajetych = new ArrayList<>();
        for (Samochod pojazd : pojazdy.values()) {
            if (pojazd.getStatus() == StatusSamochodu.WYNAJETY) {
                listaWynajetych.add(pojazd);
            }
        }
        return listaWynajetych;
    }

    public void wyswietlListeWszystkich() {
        List<Samochod> samochody = zwrocListeWszystkich();
        for (Samochod samochod : samochody) {
            System.out.println(samochod);
        }
    }

    public void wyswietlListeWynajetych() {
        List<Samochod> samochody = zwrocListeWynajetych();
        for (Samochod samochod : samochody) {
            System.out.println(samochod);
        }
    }

    public void wyswietlListeDostepnych() {
        List<Samochod> samochody = zwrocListeDostepnych();
        for (Samochod samochod : samochody) {
            System.out.println(samochod);
        }
    }

    public void wyswietlArchiwumWynajmow() {
        List<Samochod> samochody = zwrocArchiwumWynajmow();
        for (Samochod samochod : samochody) {
            System.out.println(samochod);
        }
    }

    public void wyswietlCeneSamochodu() {
        System.out.println("Podaj numer rejstracyjny");
        String numerRejstracyjny = scanner.next().toUpperCase();
        wyswietlCeneSamochodu(numerRejstracyjny);
    }

    public void wyswietlCeneSamochodu(String numerRejstracyjny) {
        if (pojazdy.containsKey(numerRejstracyjny)) {
            Samochod samochod = pojazdy.get(numerRejstracyjny);
            System.out.println(samochod.getCena());
        }
    }


}
