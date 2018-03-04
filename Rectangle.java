import java.awt.Color;
import java.awt.image.BufferedImage;

public class Rectangle implements Visitable {

    private int xSus;
    private int ySus;
    private int lungime;
    private int inaltime;
    private BufferedImage paper;
    private Color borderColor;
    private Color fillColor;

    public final int getxSus() {
        return xSus;
    }

    public final void setxSus(final int xSus) {
        this.xSus = xSus;
    }

    public final int getySus() {
        return ySus;
    }

    public final void setySus(final int ySus) {
        this.ySus = ySus;
    }

    public final int getLungime() {
        return lungime;
    }

    public final void setLungime(final int lungime) {
        this.lungime = lungime;
    }

    public final int getInaltime() {
        return inaltime;
    }

    public final void setInaltime(final int inaltime) {
        this.inaltime = inaltime;
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

    public Rectangle(final String x, final String y, final String h, final String l,
            final String c1, final String a1, final String c2, final String a2,
            final BufferedImage paper) {
        // TODO Auto-generated constructor stub
        int xS = Integer.parseInt(x);
        int yS = Integer.parseInt(y);
        int inalt = Integer.parseInt(h);
        int lung = Integer.parseInt(l);
        setxSus(xS);
        setySus(yS);
        setInaltime(inalt);
        setLungime(lung);
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

    public final BufferedImage getPaper() {
        return paper;
    }

    public final void setPaper(final BufferedImage paper) {
        this.paper = paper;
    }

    @Override
    public final void accept(final Visitor s) {
        // TODO Auto-generated method stub
        s.draw(this, getPaper());
    }

}
