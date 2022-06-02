package rental.servis;

import org.junit.Assert;
import org.junit.Test;
import pl.sda.arppl4.rental.model.Samochod;
import pl.sda.arppl4.rental.model.SkrzyniaBiegow;
import pl.sda.arppl4.rental.model.StatusSamochodu;
import pl.sda.arppl4.rental.model.TypNadwozia;
import pl.sda.arppl4.rental.servis.Wypozyczalnia;

import java.util.List;

public class WypozyczalniaTest {
    @Test
    public void test_mozliweJestDodawanieSamochodu() {
        Samochod testowanySamochod = new Samochod("test1", SkrzyniaBiegow.AUTOMATYCZNA, TypNadwozia.CABRIO, StatusSamochodu.DOSTEPNY);

        Wypozyczalnia wypozyczalnia = new Wypozyczalnia();

        wypozyczalnia.dodajSamochod(testowanySamochod.getNumerRejstracyjny(), testowanySamochod.getSkrzynia(), testowanySamochod.getTyp(), testowanySamochod.getStatus());

        List<Samochod> wynikZwroconaLista = wypozyczalnia.zwrocListe();
        wynikZwroconaLista.contains(testowanySamochod);
        Assert.assertTrue("Lista powinna zawierac samochod testowany", wynikZwroconaLista.contains(testowanySamochod));
    }

    @Test
    public void test_nieJestMozliweNadpisanieSamochodu() {
        Samochod testowanySamochod = new Samochod("test1", SkrzyniaBiegow.AUTOMATYCZNA, TypNadwozia.SUV, StatusSamochodu.DOSTEPNY);
        Samochod testowanySamochodDrugi = new Samochod("test1", SkrzyniaBiegow.MANUAL, TypNadwozia.CABRIO, StatusSamochodu.NIEDOSTEPNY);

        Wypozyczalnia wypozyczalnia = new Wypozyczalnia();

        wypozyczalnia.dodajSamochod(testowanySamochod.getNumerRejstracyjny(), testowanySamochod.getSkrzynia(), testowanySamochod.getTyp(), testowanySamochod.getStatus());
        wypozyczalnia.dodajSamochod(testowanySamochodDrugi.getNumerRejstracyjny(), testowanySamochodDrugi.getSkrzynia(), testowanySamochodDrugi.getTyp(), testowanySamochodDrugi.getStatus());

        List<Samochod> wynikZwroconaLista = wypozyczalnia.zwrocListe();
        Assert.assertEquals("Lista powinna zawierac dokladnie 1 pojazd", 1, wynikZwroconaLista.size());
        Assert.assertTrue("Lista zwrocona przez obiekt wypozyczalnia nie zawiera pojazdu dodanego a powinna go zawierac", wynikZwroconaLista.contains(testowanySamochod));
    }

    @Test
    public void test_mozemyPobracListeSamochodowDostepnych(){
        Samochod testowanySamochod = new Samochod("test1", SkrzyniaBiegow.AUTOMATYCZNA, TypNadwozia.SUV, StatusSamochodu.DOSTEPNY);
        Samochod testowanySamochodDrugi = new Samochod("test2", SkrzyniaBiegow.MANUAL, TypNadwozia.CABRIO, StatusSamochodu.NIEDOSTEPNY);

        Wypozyczalnia wypozyczalnia = new Wypozyczalnia();

        wypozyczalnia.dodajSamochod(testowanySamochod.getNumerRejstracyjny(), testowanySamochod.getSkrzynia(), testowanySamochod.getTyp(), testowanySamochod.getStatus());
        wypozyczalnia.dodajSamochod(testowanySamochodDrugi.getNumerRejstracyjny(), testowanySamochodDrugi.getSkrzynia(), testowanySamochodDrugi.getTyp(), testowanySamochodDrugi.getStatus());

        wypozyczalnia.zwrocListeDostepnych();
        List<Samochod> wynikZwroconaListaWszystkich = wypozyczalnia.zwrocListe();
        Assert.assertEquals("Lista powinna zawierac dokladnie 2 pojazd", 2, wynikZwroconaListaWszystkich.size());

        List<Samochod> dostepne = wypozyczalnia.zwrocListeDostepnych();
        Assert.assertEquals("Lista powinna zawierac dokladnie 2 pojazd", 1, dostepne.size());
        Assert.assertTrue("Lista powinna zawierac samochod testowany ktory jest dostepny", dostepne.contains(testowanySamochod));
    }

    @Test
    public void test_mozemyZmieniecStatusSamochoduNaNiedostepny(){
        Samochod testowanySamochod = new Samochod("test1", SkrzyniaBiegow.AUTOMATYCZNA, TypNadwozia.CABRIO, StatusSamochodu.DOSTEPNY);

        Wypozyczalnia wypozyczalnia = new Wypozyczalnia();

        wypozyczalnia.dodajSamochod(testowanySamochod.getNumerRejstracyjny(), testowanySamochod.getSkrzynia(), testowanySamochod.getTyp(), testowanySamochod.getStatus());

        List<Samochod> wynikZwroconaLista = wypozyczalnia.zwrocListe();
        wynikZwroconaLista.contains(testowanySamochod);
        Assert.assertTrue("Lista powinna zawierac samochod testowany", wynikZwroconaLista.contains(testowanySamochod));

        wypozyczalnia.usunSamochod("test1");
        Assert.assertTrue("Samochod stał sie niedostepny", wynikZwroconaLista.get(0).getStatus().equals(StatusSamochodu.NIEDOSTEPNY));
    }
    @Test
    public void test_uzytkownikNieZepsujeMetodyZmianyStatusuNaNiedostepnyPrzekazujacNieistniejacySamochod(){

    }
}
