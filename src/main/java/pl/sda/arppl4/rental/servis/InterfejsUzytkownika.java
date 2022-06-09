package pl.sda.arppl4.rental.servis;

import java.util.Scanner;

public class InterfejsUzytkownika {
    Scanner scanner = new Scanner(System.in);

    public void uruchom(Wypozyczalnia wypozyczalnia) {
        String rola = "3";
        do {
            System.out.println("Kim jesteś?");
            System.out.println("1. Pracownik");
            System.out.println("2. Klient");
            System.out.println("3. Koniec");
            try {
                rola = scanner.next();
                if (rola.equalsIgnoreCase("1")) {
                    obsluzPracownika(wypozyczalnia);
                } else if (rola.equalsIgnoreCase("2")) {
                    obsluzKlienta(wypozyczalnia);
                } else {
                    System.out.println("Wystąpił błąd");
                }
            } catch (Exception exception) {
                System.out.println("Wystąpił błąd:" + exception.getMessage());
            }
        } while (!rola.equalsIgnoreCase("3"));
    }

    private void obsluzPracownika(Wypozyczalnia wypozyczalnia) {
        int czynnosc;
        do {
            System.out.println("Lista dostępnych opcji:");
            System.out.println("1. Wyświetl listę samochodów");
            System.out.println("2. Wyświetl listę aktywnych wynajmów");
            System.out.println("3. Wyświetl archiwum wynajmów");
            System.out.println("4. Dodaj samochód");
            System.out.println("5. Usuń samochód");
            System.out.println("6. Wyloguj");
            czynnosc = scanner.nextInt();
            switch (czynnosc) {
                case 1 -> wypozyczalnia.wyswietlListeWszystkich();
                case 2 -> wypozyczalnia.wyswietlListeWynajetych();
                case 3 -> wypozyczalnia.wyswietlArchiwumWynajmow();
                case 4 -> wypozyczalnia.dodajSamochod();
                case 5 -> wypozyczalnia.usunSamochod();
                case 6 -> System.out.println("Do widzenia");
                default -> System.out.println("Nie rozumiem. Wpisz: '1' lub '2' lub '3'");
            }
        } while (czynnosc != 6);
    }

    private void obsluzKlienta(Wypozyczalnia wypozyczalnia) {
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
}
