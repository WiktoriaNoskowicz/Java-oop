public abstract class Shape {
    protected Style pole;

    public Shape(Style pole) {
        this.pole = pole;
    }

    public Style getPole() {
        return pole;
    }

    public void setPole(Style pole) {
        this.pole = pole;
    }

    public abstract String toSvg(double offsetX, double offsetY); //abstrakcyjna metoda!! nie ma zawartosci
    // to dziedziczace klasy moga ja implemnentowac

}
