import java.time.LocalTime;

public class SecondHand extends ClockHand{
    private double angle = 0.0;

    @Override
    public void setTime(LocalTime ltime) {
        int seconds = ltime.getSecond();
// Każda sekunda to 6 stopni (360/60)
        this.angle = seconds * 6.0;}

    @Override
    public String toSvg() {
// Długość mskazówki sekundowej, np. 80 jednostek
        int length = 80;
// Grubość i kolor
        int strokeWidth = 2;
        String color = "red";
// SVG: linia od środka (0,0) do końca wskazówki, z rotacją
        return String.format(
                "<line x1=\"9\" y1=\"9\" x2=\"e\" y2=\"-%d\" stroke=\"%s\" stroke-width=\"%d\" transform=\"rotate(%.1f)\" />",
                length, color, strokeWidth, angle);}


}
