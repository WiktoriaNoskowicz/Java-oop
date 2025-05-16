public class Ellipse extends Shape {
    private Point middle;
    private double rX;
    private double rY;

    public Ellipse(Style pole, Point middle, double rX, double rY,Style style) {
        super(style);
        this.middle = middle;
        this.rX = rX;
        this.rY = rY;
    }

    public Point getMiddle() {
        return middle;
    }

    public void setMiddle(Point middle) {
        this.middle = middle;
    }

    public double getrX() {
        return rX;
    }

    public void setrX(double rX) {
        this.rX = rX;
    }

    public double getrY() {
        return rY;
    }

    public void setrY(double rY) {
        this.rY = rY;
    }
    @Override
    public String toSvg(double offsetX, double offsetY) {
        return "<ellipse cx=\"" + this.middle.getX() + "\" cy=\"" + this.middle.getY() + "\" rx=\"" + this.rX + "\" ry=\"" + this.rY + "\" " + this.style.toSvg(0, 0) + " />";
    }
}
