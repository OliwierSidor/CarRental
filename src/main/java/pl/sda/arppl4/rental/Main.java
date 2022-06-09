package pl.sda.arppl4.rental;

import pl.sda.arppl4.rental.servis.InterfejsUzytkownika;
import pl.sda.arppl4.rental.servis.Wypozyczalnia;

public class Main {
    public static void main(String[] args) {
        Wypozyczalnia wypozyczalnia = new Wypozyczalnia();
        InterfejsUzytkownika interfejsUzytkownika = new InterfejsUzytkownika();
        interfejsUzytkownika.uruchom(wypozyczalnia);
    }
}
