//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

//        DigitalClock d1 = new DigitalClock(12,40,00, DigitalClock.Clock12or24.Clock12);
//       DigitalClock d2 = new DigitalClock(01,00,00, DigitalClock.Clock12or24.Clock12);
//        DigitalClock d3 = new DigitalClock(11,59,00, DigitalClock.Clock12or24.Clock24);

//        System.out.printf(d1.checkType());
//       System.out.printf(d2.checkType());
//        System.out.printf(d3.checkType());
//        System.out.printf(d4.checkType());

//        City.parseFile();

//        City c1 = new City("Warszawa",-3,"52.2297 N", "21.0122 E");
//        City c2 = new City("Kijów",7,"50.4501 N", "30.5234 E");
//        Clock clock = new Clock(12,33,44,c1);
////        Clock clock1 = new Clock(12,33,44,c2);
//        clock.setCity(c2);
//        DigitalClock d4 = new DigitalClock(11,59,00, DigitalClock.Clock12or24.Clock12,c1);
//
//        nie dziala
        City lub = new City("Lublin",2,"51.2465 N", "22.5684 E");
//        lub.localMeanTime();
//        System.out.println(lub);
        AnalogClock a = new AnalogClock(12,23,33,lub);
        a.toSvg("zegar.svg");
    }
}