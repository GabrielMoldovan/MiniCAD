import java.awt.Color;
import java.awt.image.BufferedImage;

public class Circle implements Visitable {

    private int x;
    private int y;
    private int raza;
    private Color borderColor;
    private Color fillColor;
    private BufferedImage paper;

    public final BufferedImage getPaper() {
        return paper;
    }

    public final void setPaper(final BufferedImage paper) {
        this.paper = paper;
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

    public final int getRaza() {
        return raza;
    }

    public final void setRaza(final int raza) {
        this.raza = raza;
    }

    public Circle(final String x, final String y, final String raza, final String c1,
            final String a1, final String c2, final String a2, final BufferedImage paper) {
        // TODO Auto-generated constructor stub
        int xc = Integer.parseInt(x);
        int yc = Integer.parseInt(y);
        int radius = Integer.parseInt(raza);
        setX(xc);
        setY(yc);
        setRaza(radius);
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
        setPaper(paper);
    }

    @Override
    public final void accept(final Visitor s) {
        // TODO Auto-generated method stub
        s.draw(this, getPaper());
    }

}
