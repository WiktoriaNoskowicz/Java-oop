import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.Map;

public class City {
    String Stolica;
    int StrefaCzasowaLetnia;
    String SzerokoscGeograficzna;
    String DlugoscGeograficzna;

    public City(String stolica, int strefaCzasowaLetnia, String dlugoscGeograficzna, String szerokoscGeograficzna) {
        Stolica = stolica;
        StrefaCzasowaLetnia = strefaCzasowaLetnia;
        DlugoscGeograficzna = dlugoscGeograficzna;
        SzerokoscGeograficzna = szerokoscGeograficzna;
    }

    public LocalTime localMeanTime(){
        LocalTime timeInZone = LocalTime.now(ZoneOffset.ofHours(this.StrefaCzasowaLetnia));
        double longitude = Double.parseDouble(this.DlugoscGeograficzna);
        // Przelicz długość geograficzną na double

        // Oblicz przesunięcie w minutach względem czasu UTC
        double totalMinutesOffset = longitude * 4.0;

        // Oblicz różnicę między czasem UTC a czasem strefowym
        int timeZoneOffsetMinutes = this.StrefaCzasowaLetnia * 60;

        // Czas UTC
        LocalTime utcTime = timeInZone.minusMinutes(timeZoneOffsetMinutes);

        // Dodaj offset miejscowy
        LocalTime meanTime = utcTime.plusMinutes((long) totalMinutesOffset);

        return meanTime;
    }

    public static void worstTimezoneFit(){

    }

    public static City parseLine(String line) {
        String[] res = line.split(",");
        City newCity = new City(res[0], Integer.valueOf(res[1]), res[2], res[3]);
        return newCity;

    }

    public static Map<String, City> parseFile() {
        BufferedReader reader;
        String line = "";
        Map<String, City> result = new HashMap<>();
        try {
            reader = new BufferedReader(new FileReader("strefy.csv"));
            line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
                if (line != null) {
                    City city = City.parseLine(line);
                    result.put(city.Stolica, city);
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;


    }
}
