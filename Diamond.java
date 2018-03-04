import java.awt.Color;
import java.awt.image.BufferedImage;

public class Diamond implements Visitable {

    private int x;
    private int y;
    private int diagOrizontala;
    private int diagVerticala;
    private Color borderColor;
    private Color fillColor;
    private BufferedImage paper;

    public Diamond(final String xc, final String yc, final String d1, final String d2,
            final String c1, final String a1, final String c2, final String a2,
            final BufferedImage paper) {
        // TODO Auto-generated constructor stub
        int xcentru = Integer.parseInt(xc);
        int ycentru = Integer.parseInt(yc);
        int diagonalaOrizontala = Integer.parseInt(d1);
        int diagonalaVerticala = Integer.parseInt(d2);
        final int trei = 3;
        final int cinci = 5;
        final int sapte = 7;
        final int hexa = 16;
        String redString = c1.substring(1, trei);
        String greenString = c1.substring(trei, cinci);
        String blueString = c1.substring(cinci, sapte);
        int red = Integer.parseInt(redString, hexa);
        int green = Integer.parseInt(greenString, hexa);
        int blue = Integer.parseInt(blueString, hexa);
        int alpha = Integer.parseInt(a1);
        Color contur = new Color(red, green, blue, alpha);
        setBorderColor(contur);
        redString = c2.substring(1, trei);
        greenString = c2.substring(trei, cinci);
        blueString = c2.substring(cinci, sapte);
        red = Integer.parseInt(redString, hexa);
        green = Integer.parseInt(greenString, hexa);
        blue = Integer.parseInt(blueString, hexa);
        alpha = Integer.parseInt(a2);
        Color culoare = new Color(red, green, blue, alpha);
        setFillColor(culoare);
        setX(xcentru);
        setY(ycentru);
        setDiagOrizontala(diagonalaOrizontala);
        setDiagVerticala(diagonalaVerticala);
        setPaper(paper);

    }

    public final BufferedImage getPaper() {
        return paper;
    }

    public final void setPaper(final BufferedImage paper) {
        this.paper = paper;
    }

    public final int getX() {
        return x;
    }

    public final void setX(final int x) {
        this.x = x;
    }

    public final int getY() {
        return y;
    }

    public final void setY(final int y) {
        this.y = y;
    }

    public final int getDiagOrizontala() {
        return diagOrizontala;
    }

    public final void setDiagOrizontala(final int diagOrizontala) {
        this.diagOrizontala = diagOrizontala;
    }

    public final int getDiagVerticala() {
        return diagVerticala;
    }

    public final void setDiagVerticala(final int diagVerticala) {
        this.diagVerticala = diagVerticala;
    }

    public final Color getBorderColor() {
        return borderColor;
    }

    public final void setBorderColor(final Color borderColor) {
        this.borderColor = borderColor;
    }

    public final Color getFillColor() {
        return fillColor;
    }

    public final void setFillColor(final Color fillColor) {
        this.fillColor = fillColor;
    }

    @Override
    public final void accept(final Visitor s) {
        // TODO Auto-generated method stub
        s.draw(this, getPaper());
    }

}
