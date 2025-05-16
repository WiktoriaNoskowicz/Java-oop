public class Segment {
    private Point start;
    private Point end;

    public Point getStart() {
        return start;
    }

    public void setStart(Point start) {
        this.start = start;
    }

    public Point getEnd() {
        return end;
    }

    public void setEnd(Point end) {
        this.end = end;
    }

    //    Poprzez stworzenie NOWYCH OBIEKTÓW a nie przekazywanie REFERENCJI obiekt
//    Segment jest niewrażliwy na zmiany pynktów z których został stworzony

    public Segment(Point start, Point end) {
        this.start = new Point(start);
        this.end = new Point(end);
    }

//    Konstruktor kopiujący

    public Segment(Segment old) {
        this.start = new Point(old.getStart().getX(), old.getStart().getY());
        this.end = new Point(old.getEnd().getX(), old.getEnd().getY());

    }
//    public Segment(Point start, Point end) {
//        this.start = start;
//        this.end = end;
//    }ten konstruktor przypisuje referencje do obiektow Point, czyli jesli zmieni sie te pola
    //poza klasa to zmiany beda widoczne w obiekcie segemnt - obiekt jest niewrazliwy na zmiany punktow z ktorych zostal zlozony
//w przypadku gdy tworzymy segemnt na podstawie jakis punktow i sie one podtem zmieniaja to
    // sie zmienia i segment -> z konstruktorem kopiujacym segment ma swoje wlasne kopie Point wiec jest odporny na zmiane



    public String toString() {
        return "poczatek punktu: " + this.start + " koniec punktu: " + this.end;
    }

    public double length() {
        return Math.sqrt(Math.pow(this.end.getX() - this.start.getX(), 2) + Math.pow(this.end.getY() - this.start.getY(), 2));
    }
    public static Segment maxSegment(Segment[] segments){
        double max_len = segments[0].length();
        Segment max_segment = segments[0];
        for(Segment s : segments){
            if (s.length() > max_len){
                max_len = s.length();
                max_segment = s;
            }
        }
        return max_segment;
    }
    public Segment perpendicular() {
        // Obliczamy kierunek oryginalnego segmentu
        float dx = this.end.getX() - this.start.getX();
        float dy = this.end.getY() - this.start.getY();

        // Obliczamy segment prostopadły
        float perpendicularDx = -dy;
        float perpendicularDy = dx;

        // Normalizujemy prostopoadły segment (ma długość 1)
        double perpendicularLength = Math.sqrt(perpendicularDx * perpendicularDx + perpendicularDy * perpendicularDy);
        perpendicularDx /= perpendicularLength;
        perpendicularDy /= perpendicularLength;


        // Obliczamy środkowy punkt obecnego segmentu
        float midX = (this.start.getX() + this.end.getX()) / 2;
        float midY = (this.start.getY() + this.end.getY()) / 2;

        // Tworzymy nowy segment
        Point newStart = new Point(midX + perpendicularDx, midY + perpendicularDy);
        Point newEnd = new Point(midX - perpendicularDx, midY - perpendicularDy);

        // Zwracamy prostopadły segment
        return new Segment(newStart, newEnd);
    }
}
