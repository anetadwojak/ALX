import java.util.ArrayList;

public class Przychodnia {

    private String nazwa;
    private String miasto;
    public ArrayList<Pacjent> pacjenci = new ArrayList<>();
    public ArrayList<Lekarz> lekarze = new ArrayList<>();

    //konstruktor
    public Przychodnia (String nazwa, String miasto) {
        this.nazwa=nazwa;
        this.miasto=miasto;
    }
    //metoda dodajaca pacjentow do listy
    public void dodajPacjenta(Pacjent pacjent){
        this.pacjenci.add(pacjent);
    }

    //metoda wypisująca listę pacjentow
    public void listaPacjentow() {
        for (Pacjent x: this.pacjenci) {
            System.out.println("Imię: "+x.getImie()+", "+"Nazwisko: "+x.getNazwisko());
        }
    }
    //metoda przepisująca pacjenta do innej przychodni - dodaje do nowej, usuwa ze starej
    public void przepiszPacjenta(Przychodnia nowaPrzychodnia, Pacjent pacjent){
        nowaPrzychodnia.dodajPacjenta(pacjent);
        this.pacjenci.remove(pacjent);
    }
    //metoda usuwająca pacjenta
    public void usunPacjenta (Pacjent pacjent) {
        this.pacjenci.remove(pacjent);
    }
    //metoda wypisująca listę lekarzy
    public void listaLekarzy(){
        System.out.println("Lista lekarzy przcyhodni "+this.getNazwa()+": ");
        for(Lekarz x: this.lekarze){
            System.out.println(x);
        }
    }

    //metoda przypiszPacjenta
    public void przypiszPacjenta(int nrLekarza, String nazwisko, String zabieg) {
        for (Pacjent z : this.pacjenci) {
            if (nazwisko.equals(z.getNazwisko())) {
                Lekarz lekarz = this.lekarze.get(nrLekarza); //pobral obiekt lekarz ze wskazanego indexu w liscie,
                lekarz.pacjenciDoPrzyjecia.put(z,zabieg);
                break;
            }
        }
    }

    //metoda wypisująca pacjentów ktorych ma przyjac wybrany lekarz

    public void pokazPacjentow(Lekarz lekarz){
       for(Lekarz x : this.lekarze) {
           if (x.equals(lekarz)) {

               for (Pacjent pacjent : x.pacjenciDoPrzyjecia.keySet()) {//wypisanie z mapy pacjenciDoPrzyjecia któa jest polem klasy Lekarz, kluczem obiekt klasy Pacjent
                   System.out.println(pacjent + " " + x.pacjenciDoPrzyjecia.get(pacjent));
               }
           }
       }
    }

    //gettery i settery
    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    //toString();

    @Override
    public String toString() {
        return "Przychodnia{" +
                "nazwa='" + nazwa + '\'' +
                ", miasto='" + miasto + '\'' +
                '}';
    }
}
