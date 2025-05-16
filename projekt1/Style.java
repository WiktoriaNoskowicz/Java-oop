public class Style {
    public final String fillColor;
    public final String strokeColor;
    public final Double strokeWidth;

    public Style(String fillColor, String strokeColor, Double strokeWidth) {
        this.fillColor = fillColor;
        this.strokeColor = strokeColor;
        this.strokeWidth = strokeWidth;
    }

    public String toSvg(double offsetX, double offset){
        return "style=\"fill:" + this.fillColor + ";stroke:" + this.strokeColor + ";stroke-width:" + strokeWidth + "\"";
    }
}
