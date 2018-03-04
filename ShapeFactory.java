import java.awt.image.BufferedImage;

public class ShapeFactory {
    private static ShapeFactory shapeFactory = new ShapeFactory();

    public static ShapeFactory getShapeFactory() {
        return shapeFactory;
    }

    //Metoda getShape instantiaza forma de pe linia curenta
    public final Visitable getShape(final String string, final BufferedImage paper) {
        String[] tokens = string.split(" ");
        String shapeType = tokens[0];
        if (shapeType == null) {
            return null;
        }
        final int trei = 3;
        final int patru = 4;
        final int cinci = 5;
        final int sase = 6;
        final int sapte = 7;
        final int opt = 8;
        final int noua = 9;
        final int zece = 10;
        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle(tokens[1], tokens[2], tokens[trei], tokens[patru], tokens[cinci],
                    tokens[sase], tokens[sapte], paper);

        } else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle(tokens[1], tokens[2], tokens[trei], tokens[patru], tokens[cinci],
                    tokens[sase], tokens[sapte], tokens[opt], paper);

        } else if (shapeType.equalsIgnoreCase("SQUARE")) {
            return new Square(tokens[1], tokens[2], tokens[trei], tokens[patru], tokens[cinci],
                    tokens[sase], tokens[sapte], paper);

        } else if (shapeType.equalsIgnoreCase("CANVAS")) {
            return new Canvas(tokens[2], tokens[1], tokens[trei], tokens[patru], paper);

        } else if (shapeType.equalsIgnoreCase("DIAMOND")) {
            return new Diamond(tokens[1], tokens[2], tokens[trei], tokens[patru], tokens[cinci],
                    tokens[sase], tokens[sapte], tokens[opt], paper);

        } else if (shapeType.equalsIgnoreCase("LINE")) {
            return new Line(tokens[1], tokens[2], tokens[trei], tokens[patru], tokens[cinci],
                    tokens[sase], paper);

        } else if (shapeType.equalsIgnoreCase("POLYGON")) {
            int numberOfPoints = Integer.parseInt(tokens[1]);
            return new Polygon(tokens[1], tokens, tokens[2 * numberOfPoints + 2],
                    tokens[2 * numberOfPoints + trei], tokens[2 * numberOfPoints + patru],
                    tokens[2 * numberOfPoints + cinci], paper);

        } else if (shapeType.equalsIgnoreCase("TRIANGLE")) {
            return new Triangle(tokens[1], tokens[2], tokens[trei], tokens[patru], tokens[cinci],
                    tokens[sase], tokens[sapte], tokens[opt], tokens[noua], tokens[zece], paper);
        }

        return null;
    }
}