import java.util.ArrayList;

public class Pacjent {
    private String imie;
    private String nazwisko;

    public ArrayList<String> choroby = new ArrayList<>();
//konstruktor
    public Pacjent(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    public void dodajChorobe(String nazwaChoroby) {
        this.choroby.add(nazwaChoroby);

    }
//gettery i settery
    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    //toString();
    @Override
    public String toString() {
        return  imie + " " + nazwisko;
    }
}
