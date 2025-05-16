import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DeathCauseStatisticsList {
    private List<DeathCauseStatistic> stats = new ArrayList<DeathCauseStatistic>();
    private boolean isValidICD10(String code) {
        return code.matches("^[A-Z]\\d{2}.*");
    }

    public void repopulate(String path) {
        this.stats.clear();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            br.readLine();
            br.readLine();

            String line;
            while ((line = br.readLine()) != null) {
                DeathCauseStatistic stat = DeathCauseStatistic.fromCsvLine(line);
                if (isValidICD10(stat.getIcdCode())) {
                    this.stats.add(stat);
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<DeathCauseStatistic> mostDeadlyDiseases(int age, int n) {
        List<DeathCauseStatistic> validStats = new ArrayList<>();
        List<Integer> deathCounts = new ArrayList<>();


        // Wybieramy tylko statystyki z danymi dla danego wieku
        for (DeathCauseStatistic stat : this.stats) {
            DeathCauseStatistic.AgeBracketDeaths bracket = stat.getAge(age);
            if (bracket != null) {
                validStats.add(stat);
                deathCounts.add(bracket.deathCount);
            }
        }

        // sortujemy list
        for (int i = 0; i < deathCounts.size() - 1; i++) {
            for (int j = i + 1; j < deathCounts.size(); j++) {
                if (deathCounts.get(i) < deathCounts.get(j)) { //< sortowanie malejace, >sortowanie rosnace

                    // robimy swap deathCounts
                    int temp = deathCounts.get(i);
                    deathCounts.set(i, deathCounts.get(j));
                    deathCounts.set(j, temp);

                    // robimy swap statystyk
                    DeathCauseStatistic tmp = validStats.get(i);
                    validStats.set(i, validStats.get(j));
                    validStats.set(j, tmp);
                }
            }
        }

        List<DeathCauseStatistic> sortedStats = new ArrayList<>();
        for (int i = 0; i < n && i < validStats.size(); i++) {
            sortedStats.add(validStats.get(i));
        }

        return sortedStats;
    }

//    public List<DeathCauseStatistic> mostDeadlyDiseases(int age, int n) {
//        List<DeathCauseStatistic> validStats = new ArrayList<>();
//
//        for (DeathCauseStatistic stat : this.stats) {
//            if (stat.getAge(age) != null) {
//                validStats.add(stat);
//            }
//        }
//
//        // Sortowanie malejąco według liczby zgonów dla danego wieku
//        validStats.sort((a, b) -> {
//            int aDeaths = a.getAge(age).deathCount;
//            int bDeaths = b.getAge(age).deathCount;
//            return Integer.compare(bDeaths, aDeaths); // malejąco
//        });
//
//        // Zwracamy n pierwszych elementów tez dziala
//        return validStats.subList(0, Math.min(n, validStats.size()));
//    }




}
