public class Polygon extends Shape {
    private Point[] points;

    public Point[] getPoints() {
        return points;
    }

    public void setPoints(Point[] points) {
        this.points = points;
    }

    public Polygon(Point[] points,Style style) {
        super(style);
        this.points = new Point[points.length];
        for(int i = 0; i < points.length; i++){
            this.points[i] = new Point(points[i].getX(), points[i].getY()); //kazdy element tablicy tworzy nowy punkt

        }
    }
    public Polygon(Point[] points) {
        this(points,new Style("none","black",1.0)); //jesli nie damy parametru style to bedzie domyslne

    }

    //gleboka kopia kostruktora polygon
    public Polygon(Polygon old) {
        super(new Style(old.style.fillColor,old.style.strokeColor,old.style.strokeWidth));
        //Point[] oldPoints = old.getPoints(); //przypisujemy do tablicy z gettera obiektu z ktorgo chcemy kopie
        this.points = new Point[old.getPoints().length];
        for(int i = 0; i < old.getPoints().length; i++){
            this.points[i] = new Point(old.getPoints()[i].getX(), old.getPoints()[i].getY()); //kazdy element tablicy tworzy nowy punkt
        }
    }
    //dziala tez tak -> z labow rozwiazanie
//    public Polygon(Polygon other) {
//        Point[] otherPoints = other.getPoints();
//        this.points = new Point[otherPoints.length];
//        for (int i = 0; i < points.length; i++) {
//            this.points[i] = new Point(otherPoints[i].getX(), otherPoints[i].getY());
//        }
//    }

    @Override
    public String toString() { //inf o punktach wielokatu
        String result = "";
        for (int i = 0; i < this.points.length; i++)  {
            result += "Punkt nr. " + (i + 1) + "\n" + this.points[i] + "\n";
        }

        return result;
    }
    @Override
    public String toSvg(double offsetX, double offsetY) {
        String result = "<polygon points=\"";

        for (int i = 0; i < points.length; i++) {
            result += (points[i].getX() + offsetX) + "," + (points[i].getY() + offsetY);
            if (i < points.length - 1) {
                result += " ";
            }
        }
        result += "\" " + this.GetS.toSvg(0,0) + " />";
        return result;
    }
    public BoundingBox boundingBox() {
        float minX = Float.MAX_VALUE, minY = Float.MAX_VALUE;
        float maxX = -Float.MAX_VALUE, maxY = -Float.MAX_VALUE;

        for (Point p : this.points) {
            minX = Math.min(minX, p.getX());
            minY = Math.min(minY, p.getY());
            maxX = Math.max(maxX, p.getX());
            maxY = Math.max(maxY, p.getY());
        }

        return new BoundingBox(minX, minY, maxX - minX, maxY - minY);
    }

    public static Polygon square(Segment diagonal, Style style) {
        // Tworzymy prostopadły segment do przekątnej
        Segment perpendicular = diagonal.perpendicular(diagonal.length());

        // Tablica punktów z których zrobimi kwadrat
        Point[] points = new Point[4];

        // Środek przekątnej
        double midX = (diagonal.getStart().getX() + diagonal.getEnd().getX()) / 2;
        double midY = (diagonal.getStart().getY() + diagonal.getEnd().getY()) / 2;

        // Pierwsze dwa punkty to początek i koniec przekątnej
        points[0] = diagonal.getStart();
        points[1] = diagonal.getEnd();

        // Tworzymy pozostałe dwa punkty za pomocą segmentu prostopadłego do przekątnej
        points[2] = new Point(midX + perpendicular.getStart().getX(), midY + perpendicular.getStart().getY());
        points[3] = new Point(midX + perpendicular.getEnd().getX(), midY + perpendicular.getEnd().getY());

        // Zwracamy nowy obiekt Polygon
        return new Polygon(points, style);



}
