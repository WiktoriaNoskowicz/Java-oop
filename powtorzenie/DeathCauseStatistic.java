import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DeathCauseStatistic {
    private String icdCode;
    private int[] deathByAgeGroup;

    public DeathCauseStatistic(String icdCode, int[] deathByAgeGroup) {
        this.icdCode = icdCode;
        this.deathByAgeGroup = deathByAgeGroup;
    }

    public String getIcdCode() {
        return icdCode;
    }

    public void setIcdCode(String icdCode) {
        this.icdCode = icdCode;
    }

    public static DeathCauseStatistic fromCsvLine(String line){ //czyta git
        String[] res = line.trim().split(","); //trim usuwa tab po kodzie, split dzieli ze wzgeldu na przecinki i wstawia do tablicy

        String icdCode = res[0];
        int[] deathByAgeGroup = new int[res.length-1];

        for (int i=1; i< res.length;i++){
            if(res[i].equals("-")){
                deathByAgeGroup[i-1] = 0;
            }else{
                deathByAgeGroup[i-1] = Integer.parseInt(res[i]);
            }
        }
        return new DeathCauseStatistic(icdCode,deathByAgeGroup);
        }



    private static final int[][] AGE_BRACKETS = {
            {0, 4}, {5, 9}, {10, 14}, {15, 19}, {20, 24},
            {25, 29}, {30, 34}, {35, 39}, {40, 44}, {45, 49},
            {50, 54}, {55, 59}, {60, 64}, {65, 69}, {70, 74},
            {75, 79}, {80, 84}, {85, 89}, {90, 94}, {95, 200}
    }; //wszytstkie przedziały wiekowe w tablicy
        public AgeBracketDeaths getAge(int age){
            for (int i = 0; i < AGE_BRACKETS.length; i++) {
                int[] brackets = AGE_BRACKETS[i]; //tworzy tablice aby sprawdzic czy age znajduje sie w przedzialach
                if (age >= brackets[0] && age <= brackets[1]) {
                    return new AgeBracketDeaths(brackets[0], brackets[1], this.deathByAgeGroup[i]); //jesli tak to tworzy nowa instancje AgeBracketDeaths która zawiera
                    // granice wieku brackets[0] - brackets[1] i liczbe zgonów w danej grupie wiekowej
                }
            }
            return null;

        }

    public class AgeBracketDeaths{
        public final int young;
        public final int old;
        public final int deathCount;

        public AgeBracketDeaths(int young, int old, int deathCount) {
            this.young = young;
            this.old = old;
            this.deathCount = deathCount;
        }

        public int getYoung() {
            return young;
        }

        public int getOld() {
            return old;
        }

        public int getDeathCount() {
            return deathCount;
        }
        @Override
        public String toString() {
            return String.format("Wiek: %d-%d, zgony: %d", this.young, this.old, this.deathCount);
        }
    }



}

