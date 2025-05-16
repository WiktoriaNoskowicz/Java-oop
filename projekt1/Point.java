public class Point {
    private float x;
    private float y; //jak private to mamy dostep przez gettery i settery

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }
    public Point(){
        this.x = 0;
        this.y = 0;
    }
    //    Następnie tworzymy konstruktor kopiujący tworzący kopię GŁĘBOKĄ obiektu

    public Point(Point old) {
        this.x = old.getX();
        this.y = old.getY(); //tworzenie niezaleznej kopii - gleboka kopia
    }
//    Point p1 = new Point(1, 1);
//    Point p2 = new Point(p1); // użyty konstruktor kopiujący
//
//    p1.setX(999); // zmiana p1
//
//System.out.println(p2); // nadal x=1, y=1 — NIE ZMIENIŁO SIĘ!


    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
    //    Za pomocą @Override zastępujemy domyślną postać String naszej klasy
    @Override
    public String toString() {
        return "x = " + this.x + " y = " + this.y;
    }
    public String toSvg(){
        return "<circle cx=\"" + this.x + "\" cy=\"" + this.y + "\" r=\"5\" fill=\"black\" />";
    }
    public void translate(float x, float y) {
       this.x += x;
       this.y += y;
    }
    public Point translated(float x, float y) {
        return new Point(this.x+x,this.y+y);
    }
}
