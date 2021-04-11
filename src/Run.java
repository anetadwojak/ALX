import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Run {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Przychodnia> przychodnie = new ArrayList<>();

        while (true) {
            System.out.println("Wybierz moduł: 1-Przychodnia; 2-Pacjent; 3-Lekarz; 4-Statystyki; 5-Koniec");
            String opcja = sc.nextLine();
            if (opcja.equals("1")) {
                while (true) {
                    System.out.println("1 - dodaj przychodnie; 2-dodaj pacjenta, 3-lista przychodni, 4-lista pacjentów, 5-koniec");
                    String wybor = sc.nextLine();
                    if (wybor.equals("1")) {
                        System.out.println("Podaj nazwę przychodni: ");
                        String nazwa = sc.nextLine();
                        System.out.println("Podaj miasto, w którym znajduje się przychodnia: ");
                        String miasto = sc.nextLine();
                        Przychodnia przychodnia = new Przychodnia(nazwa, miasto);
                        przychodnie.add(przychodnia);
                        System.out.println("Przychodnia została dodana!");
                    } else if (wybor.equals("2")) {
                        System.out.println("Podaj imię pacjenta: ");
                        String imie = sc.nextLine();
                        System.out.println("Podaj nazwisko pacjenta: ");
                        String nazwisko = sc.nextLine();
                        Pacjent pacjent = new Pacjent(imie, nazwisko);
                        System.out.println("Podaj nazwe przychodni, do której chcesz zapisać pacjenta: ");
                        String nazwa = sc.nextLine();
                        //dodanie do danej przychodni
                        for (Przychodnia x : przychodnie) {
                            if (nazwa.equals(x.getNazwa())) {
                                x.dodajPacjenta(pacjent);
                                System.out.println("Pacjent został zapisany do przychodni!");
                                break;
                            }
                        }
                    } else if (wybor.equals("3")) {

                        for (Przychodnia x : przychodnie) {
                            System.out.println("Nazwa: " + x.getNazwa() + "" + "Miasto: " + x.getMiasto());
                        }
                    } else if (wybor.equals("4")) {
                        System.out.println("Podaj nazwę przychodni, dla której chcesz wyświetlić listę pacjentów: ");
                        String nazwa = sc.nextLine();
                        for (Przychodnia x : przychodnie) {
                            if (nazwa.equals(x.getNazwa())) {
                                System.out.println("Lista pacjentów przychodni " + x.getNazwa() + ":");
                                x.listaPacjentow();
                                break;
                            }
                        }
                    } else if (wybor.equals("5")) {
                        break;
                    }

                }
            } else if (opcja.equals("2")) {//moduł Pacjenta
                while (true) {
                    System.out.println("1-dodaj chorobę, 2-lista chorób pacjenta, 3-zmodyfikuj dane pacjenta, 4- przepisz pacjenta do innej przychodni, 5-usuń pacjenta; 6-koniec");
                    String opc = sc.nextLine();
                    if (opc.equals("1")) {
                        System.out.println("Podaj nazwę przychodni, do której należy pacjent: ");
                        String nazwa = sc.nextLine();
                        System.out.println("Podaj nazwisko pacjenta: ");
                        String nazwisko = sc.nextLine();
                        System.out.println("Podaj chorobę: ");
                        String choroba = sc.nextLine();
                        for (Przychodnia x : przychodnie) {
                            if (nazwa.equals(x.getNazwa())) {
                                for (Pacjent y : x.pacjenci) {
                                    if (y.getNazwisko().equals(nazwisko)) {
                                        y.dodajChorobe(choroba);
                                        break;
                                    }
                                }
                                break;
                            }
                        }

                    } else if (opc.equals("2")) { //wypisanie chorb pacjenta
                        System.out.println("Podaj nazwisko pacjenta: ");
                        String nazwisko = sc.nextLine();
                        System.out.println("Podaj nazwę przychodni, do której należy pacjent: ");
                        String nazwa = sc.nextLine();
                        for (Przychodnia x : przychodnie) {
                            if (nazwa.equals(x.getNazwa())) {
                                for (Pacjent y : x.pacjenci) {
                                    if (nazwisko.equals(y.getNazwisko())) {
                                        for (String chor : y.choroby) {
                                            System.out.println(chor);
                                        }
                                    }
                                }
                                break;
                            }
                        }

                    } else if (opc.equals("3")) {//modyfikacja danych pacjenta
                        System.out.println("Podaj nazwę przychodni, do której należy pacjent: ");
                        String nazwa = sc.nextLine();
                        System.out.println("Podaj nazwisko pacjenta, którego dane chcesz zmodyfikować: ");
                        String nazwisko = sc.nextLine();
                        System.out.println("Jakie dane chcesz zmodyfikować: i-imie, n-nazwisko");
                        String wybor = sc.nextLine();
                        for (Przychodnia x : przychodnie) {
                            if (nazwa.equals(x.getNazwa())) {
                                for (Pacjent y : x.pacjenci) {
                                    if (wybor.equals("i") && nazwisko.equals(y.getNazwisko())) {
                                        System.out.println("Podaj nowe imie: ");
                                        String noweImie = sc.nextLine();
                                        y.setImie(noweImie);
                                        break;
                                    } else if (wybor.equals("n") && nazwisko.equals(y.getNazwisko())) {
                                        System.out.println("Podaj nowe nazwisko: ");
                                        String noweNazwisko = sc.nextLine();
                                        y.setNazwisko(noweNazwisko);
                                        break;
                                    }
                                }
                                break;
                            }
                        }
                    } else if (opc.equals("4")) { //przepisanie pacjenta do nowej przychodni
                        System.out.println("Podaj nazwę przychodni, do której należy pacjent: ");
                        String nazwa = sc.nextLine();
                        System.out.println("Podaj nazwisko pacjenta, którego chcesz przepisać: ");
                        String nazwisko = sc.nextLine();
                        System.out.println("Podaj nazwę przychodni, do której chcesz przepisać pacjenta: ");
                        String nowaNazwa = sc.nextLine();
                        for (Przychodnia x : przychodnie) {//x-przychodnia w której teraz jest pacjent
                            if (nazwa.equals(x.getNazwa())) {
                                for (Pacjent y : x.pacjenci) {//y-obiekt pacjent o podanym nazwisku
                                    if (nazwisko.equals(y.getNazwisko())) {
                                        for (Przychodnia z : przychodnie) {//z-przychodnia do ktorej przepisujemy pacjenta
                                            if (nowaNazwa.equals(z.getNazwa())) {
                                                x.przepiszPacjenta(z, y);
                                                System.out.println("Pacjent został przepisany do przychodni " + z.getNazwa() + "!");
                                                break;
                                            }
                                        }
                                        break;
                                    }
                                }
                                break;
                            }
                        }

                    } else if (opc.equals("5")) {//usuwanie pacjenta
                        System.out.println("Podaj nazwę przychodni, do której należy pacjent: ");
                        String nazwa = sc.nextLine();
                        System.out.println("Podaj nazwisko pacjenta, którego chcesz usunąć: ");
                        String nazwisko = sc.nextLine();
                        for (Przychodnia x : przychodnie) {
                            if (nazwa.equals(x.getNazwa())) {
                                for (Pacjent y : x.pacjenci) {
                                    if (nazwisko.equals(y.getNazwisko())) {
                                        x.usunPacjenta(y);
                                        System.out.println("Pacjent został usunięty!");
                                        break;
                                    }
                                }
                                break;
                            }
                        }
                    } else if (opc.equals("6")) {//koniec modułu pacjenta
                        break;
                    }
                }

            } else if (opcja.equals("3")) {//moduł lekarz
                while (true) {
                    System.out.println("1-dodaj nowego lekarza, 2-usuń lekarza, 3-wyświetl listę lekarzy, 4-zapisz pacjenta na zabieg, 5-wyświetl listę pacjentów zapisanych do danego lekarza, 6-koniec");
                    String wybor = sc.nextLine();
                    if (wybor.equals("1")) {
                        System.out.println("Podaj nazwę przychodni, do której chcesz dodać lekarza: ");
                        String nazwa = sc.nextLine();
                        System.out.println("Podaj imie lekarza: ");
                        String imie = sc.nextLine();
                        System.out.println("Podaj nazwisko lekarza: ");
                        String nazwisko = sc.nextLine();
                        Lekarz lekarz = new Lekarz(imie, nazwisko);
                        for (Przychodnia x : przychodnie) {
                            if (nazwa.equals(x.getNazwa())) {
                                x.lekarze.add(lekarz);
                                System.out.println("Lekarz " + lekarz + " został dodany do przychodni " + x.getNazwa() + "!");
                                break;
                            }
                        }
                    } else if (wybor.equals("2")) {
                        System.out.println("Podaj nazwę przychodni, z której chcesz usunąć lekarza: ");
                        String nazwa = sc.nextLine();
                        System.out.println("Podaj nazwisko lekarza: ");
                        String nazwisko = sc.nextLine();
                        for (Przychodnia x : przychodnie) {
                            if (nazwa.equals(x.getNazwa())) {
                                for (Lekarz y : x.lekarze) {
                                    if (nazwisko.equals(y.getNazwisko())) {
                                        x.lekarze.remove(y);
                                        System.out.println("Lekarz " + y + " został usunięty z przychodni " + x.getNazwa() + "!");
                                        break;
                                    }
                                }
                                break;
                            }
                        }
                    } else if (wybor.equals("3")) {//lista lekarzy wybranej przychodni
                        System.out.println("Podaj nazwę przychodni, której listę lekarzy chcesz wyświetlić: ");
                        String nazwa = sc.nextLine();
                        for (Przychodnia x : przychodnie) {
                            if (nazwa.equals(x.getNazwa())) {
                                x.listaLekarzy();
                                break;
                            }
                        }
                    } else if (wybor.equals("4")) {//przypisanie lekarzowi pacjenta na zabieg
                        System.out.println("Podaj nazwę przychodni, do której należy pacjent: ");
                        String nazwa = sc.nextLine();
                        System.out.println("Podaj nazwisko pacjenta: ");
                        String nazwisko = sc.nextLine();

                        System.out.println("Wybierz lekarza, do którego chcesz zapisać pacjenta: ");


                        for (Przychodnia x : przychodnie) {
                            if (nazwa.equals(x.getNazwa())) {
                                for (int i = 0; i < x.lekarze.size(); i++) {
                                    System.out.print(i+"-"+x.lekarze.get(i)+"; ");
                                        System.out.println();
                                    }
                                    int nrLekarza = sc.nextInt();//index w liscie
                                    sc.nextLine();

                                    System.out.println("Podaj nazwę zabiegu, na jaki chcesz zapisać pacjenta: ");
                                    String zabieg = sc.nextLine();
                                    x.przypiszPacjenta(nrLekarza, nazwisko, zabieg);
                                    System.out.println("Pacjent został zapisany!");
                                    System.out.println();

                                }
                                break;
                            }
                            break;
                        } else if (wybor.equals("5")){//wypisanie pacjentów, których ma przyjąc wybrany lekarz
                        System.out.println("Podaj nazwę przychodni: ");
                        String nazwa=sc.nextLine();
                        System.out.println("Podaj nazwisko lekarza: ");
                        String nazwisko=sc.nextLine();
                        for (Przychodnia x : przychodnie){
                            if(nazwa.equals(x.getNazwa())){
                                for (Lekarz y: x.lekarze){
                                    if (nazwisko.equals(y.getNazwisko())) {
                                        x.pokazPacjentow(y);
                                        break;
                                    }
                                }
                            }
                            break;
                        }

                    } else if (wybor.equals("6")) {
                        break;//koniec modułu lekarz
                    }

                }
            }else if(opcja.equals("4")){
                System.out.println("1-statystyki wybranej przychodni, 2-statystyki wszystkich przychodni");
                String wybor=sc.nextLine();
                if(wybor.equals("1")){
                    System.out.println("Podaj nazwę przychodni, której statystyki chcesz zobaczyć: ");
                    String nazwa=sc.nextLine();
                    for(Przychodnia x : przychodnie){
                        if(nazwa.equals(x.getNazwa())){
                            System.out.println("Liczba pacjentów w przychodni "+x.getNazwa()+" :"+x.pacjenci.size());
                            break;
                        }
                    }
                }else if(wybor.equals("2")){
                    for(Przychodnia x : przychodnie){
                        System.out.println("Liczba pacjentów w przychodni "+x.getNazwa()+": "+x.pacjenci.size());
                    }
                }
            }
            else if (opcja.equals("5")) { //koniec programu
                break;
            }
        }
    }
}