import java.awt.Color;
import java.awt.image.BufferedImage;

public class Line implements Visitable {

    private int xStart;
    private int xFinish;
    private int yStart;
    private int yFinis;
    private Color color;
    private BufferedImage paper;

    public final BufferedImage getPaper() {
        return paper;
    }

    public final void setPaper(final BufferedImage paper) {
        this.paper = paper;
    }

    public final int getxStart() {
        return xStart;
    }

    public final void setxStart(final int xStart) {
        this.xStart = xStart;
    }

    public final int getxFinish() {
        return xFinish;
    }

    public final void setxFinish(final int xFinish) {
        this.xFinish = xFinish;
    }

    public final int getyStart() {
        return yStart;
    }

    public final void setyStart(final int yStart) {
        this.yStart = yStart;
    }

    public final int getyFinis() {
        return yFinis;
    }

    public final void setyFinis(final int yFinis) {
        this.yFinis = yFinis;
    }

    public final Color getColor() {
        return color;
    }

    public final void setColor(final Color color) {
        this.color = color;
    }

    public Line(final String x1, final String y1, final String x2, final String y2, final String c,
            final String a, final BufferedImage paper) {
        // TODO Auto-generated constructor stub
        int xS = Integer.parseInt(x1);
        int yS = Integer.parseInt(y1);
        int xF = Integer.parseInt(x2);
        int yF = Integer.parseInt(y2);
        final int trei = 3;
        final int cinci = 5;
        final int sapte = 7;
        final int hexa = 16;
        String redString = c.substring(1, trei);
        String greenString = c.substring(trei, cinci);
        String blueString = c.substring(cinci, sapte);
     //   System.out.println(redString + greenString + blueString);
        int red = Integer.parseInt(redString, hexa);
        int green = Integer.parseInt(greenString, hexa);
        int blue = Integer.parseInt(blueString, hexa);
        int alpha = Integer.parseInt(a);
        Color culoare = new Color(red, green, blue, alpha);
        setxStart(xS);
        setyStart(yS);
        setxFinish(xF);
        setyFinis(yF);
        setColor(culoare);
        setPaper(paper);
    }

    @Override
    public final void accept(final Visitor s) {
        // TODO Auto-generated method stub
        s.draw(this, getPaper());

    }

}
