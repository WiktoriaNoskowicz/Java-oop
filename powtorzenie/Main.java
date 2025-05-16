import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        String filePath = "zgony(3).csv"; // względna ścieżka do pliku

//        // Zad.1
//
//        ArrayList<DeathCauseStatistic> stats = new ArrayList<DeathCauseStatistic>();
//
//        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
//            // pomijamy 2 pierwsze wiersze, są bezużyteczne
//            br.readLine();
//            br.readLine();
//
//            String line;
//            while ((line = br.readLine()) != null) {
//                DeathCauseStatistic stat = DeathCauseStatistic.fromCsvLine(line);
//                stats.add(stat);
//                System.out.println(stat.getIcdCode());
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

                // Zad.2

//        System.out.println(stats.get(22).getAge(22));
//
        // Zad.3

        DeathCauseStatisticsList list = new DeathCauseStatisticsList();
        list.repopulate("zgony(3).csv");

        int age = 75;
        int topN = 5;

        System.out.println("Top " + topN + " najśmiertelniejszych chorób dla wieku " + age + ":");
        List<DeathCauseStatistic> topDiseases = list.mostDeadlyDiseases(age, topN);
        for (DeathCauseStatistic stat : topDiseases) {
            System.out.println(stat.getIcdCode());
        }

//        //        // Zad. 4
//
        ICDCodeTabular timeOptimized = null;
        ICDCodeTabular memoryOptimized = null;

        try {
            timeOptimized = new ICDCodeTabularOptimizedForTime("icd10_descriptions.txt");
            memoryOptimized = new ICDCodeTabularOptimizedForMemory("icd10_descriptions.txt"); // jeśli też rzuca IOException
        } catch (IOException e) {
            System.err.println("Błąd wczytywania pliku ICD: " + e.getMessage());
            e.printStackTrace();
            return; // lub System.exit(1);
        }



        String descTime = "N/A";
        String descMemory = "N/A";
        try {
            descTime = timeOptimized.getDescription("A00");
        } catch (IndexOutOfBoundsException e) {
            descTime = "(not found)";
        }
        System.out.println("  Description (time-optimized): " + descTime);

        try {
            descMemory = memoryOptimized.getDescription("A01.00");
        } catch (IndexOutOfBoundsException e) {
            descMemory = "(not found)";
        }
        System.out.println("  Description (memory-optimized): " + descMemory);

//
//
   }


    }