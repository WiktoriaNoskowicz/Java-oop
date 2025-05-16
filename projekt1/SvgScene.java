import java.io.FileWriter;
import java.io.IOException;

public class SvgScene {
    private Shape[] shapes;
    private int currentReplacementIndex;

    public SvgScene() {
        shapes = new Shape[3];
        currentReplacementIndex = 0;
    }
    //    Najpierw przechodzimy się po tablicy i dodajemy nowy Point do pierwszego napotkanego miejsca w tablicy (opcjonalne)
//    następnie jeśli żadniego nie znajedziemy to po prostu podmieniamy punkt znajdujący się na currentReplacementIndex,
//    jeśli dojdziemy do końca tablicy, zerujemy currentReplacementIndex

    public void addPolygon(Shape s) {
        for (int i = 0; i < this.shapes.length; i++) {
            if (this.shapes[i] == null) {
                this.shapes[i] = s;
                return;
            } //sprawdza najpierw czy sa wolne miejsca
        }
        shapes[this.currentReplacementIndex] = s;
        this.currentReplacementIndex++;
        if (this.currentReplacementIndex == this.shapes.length) {
            this.currentReplacementIndex = 0;
        }
    }

    public String toSvg() {
        String res = " ";
        for (Shape poly : shapes) {
            if (poly != null) {
                res += poly.toSvg(0, 0);
                res += "\n";
            }
        }
        return res;
    }
    public void save(String filePath) {
        boolean hasAny = false; //zakladamy ze na poczatku jest pusty
        float minX = Float.MAX_VALUE, minY = Float.MAX_VALUE;
        float maxX = -Float.MAX_VALUE, maxY = -Float.MAX_VALUE;

        for (Shape s : shapes) {
            if (s == null || !(s instanceof Polygon)) continue;
            hasAny = true;
            BoundingBox box = ((Polygon)s).boundingBox();
            minX = Math.min(minX, box.x());
            minY = Math.min(minY, box.y());
            maxX = Math.max(maxX, box.x() + box.width());
            maxY = Math.max(maxY, box.y() + box.height());
        }
//        Celem tego kroku jest:
//        określenie, jak duży ma być obszar SVG (żeby objął wszystkie wielokąty),
//                przesunięcie całego rysunku, tak żeby zaczął się od (0, 0).

        if (!hasAny) { //hasAny == false
            System.out.println("No polygons to save.");
            return;
        }

        float offsetX = minX;
        float offsetY = minY;
        float width = maxX - minX;
        float height = maxY - minY; //oblicza przesuniecie i rozmiar obrazka + offset zeby zaczynał sie od (0,0)

        StringBuilder svgContent = new StringBuilder(); //tworzy pusty kontener na svg do ktorego dodajemy elementy

        svgContent.append(String.format(
                "<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"%.2f\" height=\"%.2f\" viewBox=\"0 0 %.2f %.2f\">\n",
                width, height, width, height
        ));

        for (Shape s:shapes) {
            if (s != null) {
                svgContent.append(s.toSvg(-offsetX, -offsetY)).append("\n"); //przesuwamy o offset -offsetX, -offsetY, aby rysunek był dobrze wypozycjonowany w (0, 0).
            }
        }

        svgContent.append("</svg>");

        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(svgContent.toString());
            System.out.println("SVG file saved successfully!");
        } catch (IOException e) {
            System.err.println("Error saving SVG file: " + e.getMessage());
        }
    }



}
