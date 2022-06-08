package pl.sda.arppl4.rental;

import pl.sda.arppl4.rental.model.Samochod;
import pl.sda.arppl4.rental.model.SkrzyniaBiegow;
import pl.sda.arppl4.rental.model.StatusSamochodu;
import pl.sda.arppl4.rental.model.TypNadwozia;
import pl.sda.arppl4.rental.servis.Wypozyczalnia;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Wypozyczalnia wypozyczalnia = new Wypozyczalnia();
        Samochod samochod1 = new Samochod("Audi", SkrzyniaBiegow.AUTOMATYCZNA, TypNadwozia.SUV, StatusSamochodu.DOSTEPNY, 350.00);
        Samochod samochod2 = new Samochod("Skoda", SkrzyniaBiegow.MANUAL, TypNadwozia.CABRIO, StatusSamochodu.DOSTEPNY, 200.00);

        wypozyczalnia.dodajSamochod(samochod1);
        wypozyczalnia.dodajSamochod(samochod2);
        String rola;
        do {
            System.out.println("Jesteś pracownikiem czy klientem? (jeśli chcesz zakończyc program wpisz 'koniec')");
            rola = scanner.next();
            if (rola.equalsIgnoreCase("pracownik")) {
                int czynnosc;
                do {
                    System.out.println("Lista dostępnych opcji:");
                    System.out.println("1. Wyświetl listę samochodów");
                    System.out.println("2. Wyświetl listę aktywnych wynajmów");
                    System.out.println("3. Wyświetl archiwum wynajmów");
                    System.out.println("4. Wyloguj");
                    czynnosc = scanner.nextInt();
                    switch (czynnosc) {
                        case 1 -> wypozyczalnia.wyswietlListeWszystkich();
                        case 2 -> wypozyczalnia.wyswietlListeWynajetych();
                        case 3 -> wypozyczalnia.wyswietlArchiwumWynajmow();
                        case 4 -> System.out.println("Do widzenia");
                        default -> System.out.println("Nie rozumiem. Wpisz: '1' lub '2' lub '3'");
                    }
                } while (czynnosc != 4);
            } else if (rola.equalsIgnoreCase("klient")) {
                int czynnosc;
                do {
                    System.out.println("Lista dostępnych opcji:");
                    System.out.println("1. Wyświetl listę samochodów");
                    System.out.println("2. Wyświetl listę dostepnych samochodow");
                    System.out.println("3. Wyświetl cene samochodu");
                    System.out.println("4. Wynajmij samochod");
                    System.out.println("5. Oddaj samochod");
                    System.out.println("6. Wyloguj");
                    czynnosc = scanner.nextInt();
                    switch (czynnosc) {
                        case 1 -> wypozyczalnia.wyswietlListeWszystkich();
                        case 2 -> wypozyczalnia.wyswietlListeDostepnych();
                        case 3 -> wypozyczalnia.wyswietlCeneSamochodu();
                        case 4 -> wypozyczalnia.wynajmijSamochod();
                        case 5 -> wypozyczalnia.oddajSamochod();
                        default -> System.out.println("Nie rozumiem. Wpisz: '1' lub '2' lub '3'");
                    }
                } while (czynnosc != 6);
            }
        } while (!rola.equalsIgnoreCase("koniec"));
    }
}
