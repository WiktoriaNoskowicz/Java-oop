import java.time.LocalDate;
import java.time.LocalTime;

public class Clock {
//    LocalTime setTime = LocalTime.now(); -> mozna to ustawic i pobierac
    int hour;
    int minute;
    int second;
    private City city;

    public void setCurrentTime(){
        LocalDate setTime = LocalDate.now();
    }

    public City getCity() {
        return city;
    }

    public void setCitySetter(City city) {
        this.city = city;
    }

    public Clock(int hour, int minute, int second, City city) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        this.city = city;
    }

    public void setCity(City city){
        this.city.Stolica = city.Stolica;
        this.city.DlugoscGeograficzna = city.DlugoscGeograficzna;
        this.city.SzerokoscGeograficzna = city.SzerokoscGeograficzna;
        if(this.city.StrefaCzasowaLetnia<city.StrefaCzasowaLetnia){
        this.city.StrefaCzasowaLetnia = city.StrefaCzasowaLetnia - this.city.StrefaCzasowaLetnia;
            System.out.println(this.city.StrefaCzasowaLetnia);
        }
        else if (this.city.StrefaCzasowaLetnia>city.StrefaCzasowaLetnia){
            this.city.StrefaCzasowaLetnia = city.StrefaCzasowaLetnia + this.city.StrefaCzasowaLetnia;
            System.out.println(this.city.StrefaCzasowaLetnia);
        }
    }

    public void setTime(){
        LocalTime setTime = LocalTime.now();
        int hour = setTime.getHour();
        if (hour>23){
            throw new IllegalArgumentException("zle podane godziny podaj w zakresie 0-23");
        }
        int minute = setTime.getMinute();
        if (hour>23){
            throw new IllegalArgumentException("zle podane minuty podaj w zakresie 0-59");
        }
        int second = setTime.getSecond();
        if (hour>23){
            throw new IllegalArgumentException("zle podane sekundy, podaj w zakresie 0-59");
        }
    }
    public String toString(){
        String res;
        res = String.format("%02d:%02d:%02d\n", this.hour, this.minute, this.second);
        return res;
    }

}
