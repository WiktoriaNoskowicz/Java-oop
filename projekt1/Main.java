//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

//        Point p1 = new Point(1, 2);
//        Point p2 = new Point(3, 4);
//
////        System.out.println(p1);
////        System.out.println(p2);
//////        System.out.println(p1.toSvg());
////
//        Segment s1 = new Segment(p1, p2);
//        System.out.println(s1);
//        System.out.println(s1.length());
////        p1.setX(7);
////        System.out.println(p1);
////        System.out.println(s1);
////        System.out.println(s1.length()); sprawdzanie czy jest wrazliwy na zmiane p1
////zad 3
//        Point p3 = new Point(5, 6);
//        Point p4 = new Point(7, 8);
//        Point[] points = {p1, p2, p3, p4};
//        Polygon polygon = new Polygon(points);
//        System.out.println(polygon);

        Point[] trianglePoints = {
                new Point(10, 10),
                new Point(100, 10),
                new Point(50, 80)
        };

        // 2. Tworzenie obiektu Polygon
        Polygon triangle = new Polygon(trianglePoints);

        // 3. Tworzenie sceny
        SvgScene scene = new SvgScene();

        // 4. Dodawanie wielokątów do sceny
        scene.addPolygon(triangle);

        // Można dodać więcej wielokątów:
        Point[] squarePoints = {
                new Point(150, 150),
                new Point(200, 150),
                new Point(200, 200),
                new Point(150, 200)
        };
        Polygon square = new Polygon(squarePoints);
        scene.addPolygon(square);

        // 5. Wyświetlenie SVG w konsoli (opcjonalne)
        System.out.println(scene.toSvg());

        // 6. Zapis do pliku (ścieżka względna lub absolutna)
        scene.save("scene.svg");

        System.out.println("Test zakończony!");


    }
}