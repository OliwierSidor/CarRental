package pl.sda.arppl4.rental.servis;

import pl.sda.arppl4.rental.model.Samochod;
import pl.sda.arppl4.rental.model.SkrzyniaBiegow;
import pl.sda.arppl4.rental.model.StatusSamochodu;
import pl.sda.arppl4.rental.model.TypNadwozia;

import java.util.*;

public class Wypozyczalnia {
    private Map<String, Samochod> pojazdy = new HashMap<>();
    private List<Samochod> archiwumWypozyczen = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);
    private static final String NUMER_REJESTRACYJNY = "Podaj numer rejestracyjny ";

    public void dodajSamochod(Samochod samochod) {
        if (!pojazdy.containsKey(samochod.getNumerRejstracyjny())) {
            pojazdy.put(samochod.getNumerRejstracyjny().toUpperCase(), samochod);
        }
    }

    private SkrzyniaBiegow pobierzSkrzynieBiegow() {
        try {
            return SkrzyniaBiegow.valueOf(scanner.next().toUpperCase());
        } catch (Exception exception) {
            System.out.println("Wystąpił błąd przy pobieraniu skrzyni biegów, podaj jeszcze raz ");
            return pobierzSkrzynieBiegow();
        }
    }

    private TypNadwozia pobierzTypNadwozia() {
        try {
            return TypNadwozia.valueOf(scanner.next().toUpperCase());
        } catch (Exception exception) {
            System.out.println("Wystąpił błąd przy pobieraniu typu nadwozia, podaj jeszcze raz");
            return pobierzTypNadwozia();
        }
    }

    private Double pobierzCene() {
        try {
            return Double.valueOf(scanner.next());
        } catch (Exception exception) {
            System.out.println("Wpisałeś zły format ceny, podaj jeszcze raz");
            return pobierzCene();
        }
    }

    public void dodajSamochod() {
        System.out.println(NUMER_REJESTRACYJNY);
        String numerRejstracyjny = scanner.next();
        System.out.println("Podaj typ skrzyni biegów (manual/automat)");
        SkrzyniaBiegow skrzyniaBiegow = pobierzSkrzynieBiegow();
        System.out.println("Podaj typ nadwozia (SUV, SEDAN, CABRIO)");
        TypNadwozia typNadwozia = pobierzTypNadwozia();
        System.out.println("Podaj cenę za jeden dzień użytkowania");
        double cena = pobierzCene();
        Samochod samochod = new Samochod(numerRejstracyjny, skrzyniaBiegow, typNadwozia, StatusSamochodu.DOSTEPNY, cena);
        pojazdy.put(numerRejstracyjny.toUpperCase(), samochod);
    }

    public void usunSamochod(String numerRejstracyjny) {
        pojazdy.get(numerRejstracyjny).setStatus(StatusSamochodu.NIEDOSTEPNY);
    }

    public void usunSamochod() {
        System.out.println(NUMER_REJESTRACYJNY);
        String numerRejstracyjny = scanner.next();
        pojazdy.remove(numerRejstracyjny.toUpperCase());
    }

    public void wynajmijSamochod(String numerRejstracyjny) {
        if (pojazdy.containsKey(numerRejstracyjny) && pojazdy.get(numerRejstracyjny).getStatus() != StatusSamochodu.WYNAJETY) {
            Samochod samochod = pojazdy.get(numerRejstracyjny);
            samochod.setStatus(StatusSamochodu.WYNAJETY);
            archiwumWypozyczen.add(samochod);
        }
    }

    public void wynajmijSamochod() {
        System.out.println(NUMER_REJESTRACYJNY);
        String numerRejstracyjny = scanner.next().toUpperCase();
        wynajmijSamochod(numerRejstracyjny);
    }

    public void oddajSamochod(String numerRejstracyjny) {
        if (pojazdy.containsKey(numerRejstracyjny) && pojazdy.get(numerRejstracyjny).getStatus() == StatusSamochodu.WYNAJETY) {
            Samochod samochod = pojazdy.get(numerRejstracyjny);
            samochod.setStatus(StatusSamochodu.DOSTEPNY);
        }
    }

    public void oddajSamochod() {
        System.out.println(NUMER_REJESTRACYJNY);
        String numerRejstracyjny = scanner.next().toUpperCase();
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
        System.out.println("Lista wszystkich samochodów");
        List<Samochod> samochody = zwrocListeWszystkich();
        for (Samochod samochod : samochody) {
            System.out.println(samochod);
        }
    }

    public void wyswietlListeWynajetych() {
        System.out.println("Lista wynajetych samochodów");
        List<Samochod> samochody = zwrocListeWynajetych();
        for (Samochod samochod : samochody) {
            System.out.println(samochod);
        }
    }

    public void wyswietlListeDostepnych() {
        System.out.println("Lista dostępnych samochodów");
        List<Samochod> samochody = zwrocListeDostepnych();
        for (Samochod samochod : samochody) {
            System.out.println(samochod);
        }
    }

    public void wyswietlArchiwumWynajmow() {
        System.out.println("Lista archiwalnych wynajmów");
        List<Samochod> samochody = zwrocArchiwumWynajmow();
        for (Samochod samochod : samochody) {
            System.out.println(samochod);
        }
    }

    public void wyswietlCeneSamochodu() {
        System.out.println(NUMER_REJESTRACYJNY + " ");
        String numerRejstracyjny = scanner.next().toUpperCase();
        wyswietlCeneSamochodu(" " + numerRejstracyjny);
    }

    public void wyswietlCeneSamochodu(String numerRejstracyjny) {
        System.out.println("Cena samochodu" + numerRejstracyjny);
        if (pojazdy.containsKey(numerRejstracyjny)) {
            Samochod samochod = pojazdy.get(numerRejstracyjny);
            System.out.println(samochod.getCena());
        }
    }
}
