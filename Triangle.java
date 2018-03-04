import java.awt.Color;
import java.awt.image.BufferedImage;

public class Triangle implements Visitable {

    private int x1;
    private int x2;
    private int x3;
    private int y1;
    private int y2;
    private int y3;
    private BufferedImage paper;

    public final int getX1() {
        return x1;
    }

    public final void setX1(final int x1) {
        this.x1 = x1;
    }

    public final int getX2() {
        return x2;
    }

    public final void setX2(final int x2) {
        this.x2 = x2;
    }

    public final int getX3() {
        return x3;
    }

    public final void setX3(final int x3) {
        this.x3 = x3;
    }

    public final int getY1() {
        return y1;
    }

    public final void setY1(final int y1) {
        this.y1 = y1;
    }

    public final int getY2() {
        return y2;
    }

    public final void setY2(final int y2) {
        this.y2 = y2;
    }

    public final int getY3() {
        return y3;
    }

    public final void setY3(final int y3) {
        this.y3 = y3;
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

    private Color borderColor;
    private Color fillColor;

    public Triangle(final String xOne, final String yOne, final String xTwo, final String yTwo,
            final String xThree, final String yThree, final String c1, final String a1,
            final String c2, final String a2, final BufferedImage paper) {
        // TODO Auto-generated constructor stub
        int xUnu = Integer.parseInt(xOne);
        int xDoi = Integer.parseInt(xTwo);
        int xTrei = Integer.parseInt(xThree);
        int yUnu = Integer.parseInt(yOne);
        int yDoi = Integer.parseInt(yTwo);
        int yTrei = Integer.parseInt(yThree);
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
        setX1(xUnu);
        setX2(xDoi);
        setX3(xTrei);
        setY1(yUnu);
        setY2(yDoi);
        setY3(yTrei);
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
