import java.awt.Color;
import java.awt.image.BufferedImage;

public class Polygon implements Visitable {

    private int[] xCoordinates;
    private int[] yCoordinates;
    private int numberOfPints;
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

    public Polygon(final String points, final String[] coordinates, final String c1,
            final String a1, final String c2, final String a2, final BufferedImage paper) {
        // TODO Auto-generated constructor stub
        int numberOfPoints = Integer.parseInt(points);
        int[] xCoordinate = new int[numberOfPoints];
        int[] yCoordinate = new int[numberOfPoints];
        int c = 0;
        setNumberOfPints(numberOfPoints);
        for (int i = 2; i <= 2 * numberOfPoints; i += 2) {
            xCoordinate[c] = Integer.parseInt(coordinates[i]);
            yCoordinate[c] = Integer.parseInt(coordinates[i + 1]);
            c++;

        }
        setxCoordinates(xCoordinate);
        setyCoordinates(yCoordinate);

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

    public final int[] getxCoordinates() {
        return xCoordinates;
    }

    public final void setxCoordinates(final int[] xCoordinates) {
        this.xCoordinates = xCoordinates;
    }

    public final int[] getyCoordinates() {
        return yCoordinates;
    }

    public final void setyCoordinates(final int[] yCoordinates) {
        this.yCoordinates = yCoordinates;
    }

    public final int getNumberOfPints() {
        return numberOfPints;
    }

    public final void setNumberOfPints(final int numberOfPints) {
        this.numberOfPints = numberOfPints;
    }

    @Override
    public final void accept(final Visitor s) {
        // TODO Auto-generated method stub
        s.draw(this, getPaper());
    }

}
