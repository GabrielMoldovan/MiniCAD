
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;

final class Main {
    private Main() {
        // TODO Auto-generated constructor stub
    }

    public static void main(final String[] args) throws IOException {
//         Scanner s = new Scanner(new FileInputStream(args[0]));
        Scanner s = new Scanner(System.in);
        String numberOfShapes = s.nextLine();
        int n = Integer.parseInt(numberOfShapes);
        String line = s.nextLine();
        String[] tokens = line.split(" ");
        BufferedImage paper = new BufferedImage(Integer.parseInt(tokens[2]),
                Integer.parseInt(tokens[1]), BufferedImage.TYPE_4BYTE_ABGR);
        Visitable c = ShapeFactory.getShapeFactory().getShape(line, paper);
        ArrayList<Visitable> obiecte = new ArrayList<Visitable>();
        obiecte.add(c);
        MiniCAD cad = new MiniCAD();
        for (int i = 1; i < n; i++) {
            line = s.nextLine();
            Visitable shape = ShapeFactory.getShapeFactory().getShape(line, paper);
            obiecte.add(shape);

        }
        for (int i = 0; i < n; i++) {
            obiecte.get(i).accept(cad);

        }
        s.close();
        ImageIO.write(paper, "png", new File("drawing.png"));
    }
}
