import java.awt.Color;
import java.awt.image.BufferedImage;

public class Canvas implements Visitable {

    private int height;
    private int width;
    private Color borderColor;
    private BufferedImage paper;

    public final BufferedImage getPaper() {
        return paper;
    }

    public final void setPaper(final BufferedImage paper) {
        this.paper = paper;
    }

    public Canvas(final String inaltime, final String latime, final String c, final String a,
            final BufferedImage paper) {
        // TODO Auto-generated constructor stub
        int inalt = Integer.parseInt(inaltime);
        int lat = Integer.parseInt(latime);
        final int trei = 3;
        final int cinci = 5;
        final int sapte = 7;
        final int hexa = 16;
        String redString = c.substring(1, trei);
        String greenString = c.substring(trei, cinci);
        String blueString = c.substring(cinci, sapte);
        int red = Integer.parseInt(redString, hexa);
        int green = Integer.parseInt(greenString, hexa);
        int blue = Integer.parseInt(blueString, hexa);
        int alpha = Integer.parseInt(a);
        Color culoare = new Color(red, green, blue, alpha);
        setHeight(inalt);
        setWidth(lat);
        setBorderColor(culoare);
        setPaper(paper);
    }

    public final int getHeight() {
        return height;
    }

    public final void setHeight(final int height) {
        this.height = height;
    }

    public final int getWidth() {
        return width;
    }

    public final void setWidth(final int width) {
        this.width = width;
    }

    public final Color getBorderColor() {
        return borderColor;
    }

    public final void setBorderColor(final Color borderColor) {
        this.borderColor = borderColor;
    }

    @Override
    public final void accept(final Visitor s) {
        // TODO Auto-generated method stub
        s.draw(this, getPaper());
    }

}
