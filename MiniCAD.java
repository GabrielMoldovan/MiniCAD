import java.awt.Color;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MiniCAD implements Visitor {

    private boolean checkBorder(final int x, final int y, final BufferedImage paper) {
        return (x >= 0 && y >= 0 && x < paper.getWidth() && y < paper.getHeight());

    }

    private void floodFill(final int x, final int y, final Color color, final Color borderColor,
            final BufferedImage paper) {
        Queue<int[]> q = new LinkedList<int[]>();
        q.add(new int[] { x, y });
        while (q.isEmpty() == false) {
            int[] point = q.remove();
            if (checkBorder(point[0] - 1, point[1], paper)
                    && paper.getRGB(point[0] - 1, point[1]) != borderColor.getRGB()
                    && paper.getRGB(point[0] - 1, point[1]) != color.getRGB()) {
                q.add(new int[] { point[0] - 1, point[1] });
                paper.setRGB(point[0] - 1, point[1], color.getRGB());
            }
            if (checkBorder(point[0], point[1] - 1, paper)
                    && paper.getRGB(point[0], point[1] - 1) != borderColor.getRGB()
                    && paper.getRGB(point[0], point[1] - 1) != color.getRGB()) {
                q.add(new int[] { point[0], point[1] - 1 });
                paper.setRGB(point[0], point[1] - 1, color.getRGB());
            }
            if (checkBorder(point[0] + 1, point[1], paper)
                    && paper.getRGB(point[0] + 1, point[1]) != borderColor.getRGB()
                    && paper.getRGB(point[0] + 1, point[1]) != color.getRGB()) {
                q.add(new int[] { point[0] + 1, point[1] });
                paper.setRGB(point[0] + 1, point[1], color.getRGB());
            }
            if (checkBorder(point[0], point[1] + 1, paper)
                    && paper.getRGB(point[0], point[1] + 1) != borderColor.getRGB()
                    && paper.getRGB(point[0], point[1] + 1) != color.getRGB()) {
                q.add(new int[] { point[0], point[1] + 1 });
                paper.setRGB(point[0], point[1] + 1, color.getRGB());
            }
        }
    }

    
    @Override
    public final void draw(final Circle s, final BufferedImage paper) {
        // TODO Auto-generated method stub

        int xc = s.getX();
        int yc = s.getY();
        int r = s.getRaza();
        int x = 0, y = r;
        final int trei = 3;
        int doi = 2;
        int d = trei - doi * r;
        while (y >= x) {
            if (checkBorder(xc + x, yc + y, paper)) {
                paper.setRGB(xc + x, yc + y, s.getBorderColor().getRGB());
            }
            if (checkBorder(xc - x, yc + y, paper)) {
                paper.setRGB(xc - x, yc + y, s.getBorderColor().getRGB());
            }
            if (checkBorder(xc + x, yc - y, paper)) {
                paper.setRGB(xc + x, yc - y, s.getBorderColor().getRGB());
            }
            if (checkBorder(xc - x, yc - y, paper)) {
                paper.setRGB(xc - x, yc - y, s.getBorderColor().getRGB());
            }
            if (checkBorder(xc + y, yc + x, paper)) {
                paper.setRGB(xc + y, yc + x, s.getBorderColor().getRGB());
            }
            if (checkBorder(xc + y, yc - x, paper)) {
                paper.setRGB(xc + y, yc - x, s.getBorderColor().getRGB());
            }
            if (checkBorder(xc - y, yc + x, paper)) {
                paper.setRGB(xc - y, yc + x, s.getBorderColor().getRGB());
            }
            if (checkBorder(xc - y, yc - x, paper)) {
                paper.setRGB(xc - y, yc - x, s.getBorderColor().getRGB());
            }

            x++;
            if (d > 0) {
                y--;
                final int patru = 4;
                final int zece = 10;
                d = d + patru * (x - y) + zece;
            } else {
                final int patru = 4;
                final int sase = 6;
                d = d + patru * x + sase;
            }
            if (checkBorder(xc + x, yc + y, paper)) {
                paper.setRGB(xc + x, yc + y, s.getBorderColor().getRGB());
            }
            if (checkBorder(xc - x, yc + y, paper)) {
                paper.setRGB(xc - x, yc + y, s.getBorderColor().getRGB());
            }
            if (checkBorder(xc + x, yc - y, paper)) {
                paper.setRGB(xc + x, yc - y, s.getBorderColor().getRGB());
            }
            if (checkBorder(xc - x, yc - y, paper)) {
                paper.setRGB(xc - x, yc - y, s.getBorderColor().getRGB());
            }
            if (checkBorder(xc + y, yc + x, paper)) {
                paper.setRGB(xc + y, yc + x, s.getBorderColor().getRGB());
            }
            if (checkBorder(xc + y, yc - x, paper)) {
                paper.setRGB(xc + y, yc - x, s.getBorderColor().getRGB());
            }
            if (checkBorder(xc - y, yc + x, paper)) {
                paper.setRGB(xc - y, yc + x, s.getBorderColor().getRGB());
            }
            if (checkBorder(xc - y, yc - x, paper)) {
                paper.setRGB(xc - y, yc - x, s.getBorderColor().getRGB());
            }

        }
        floodFill(xc, yc, s.getFillColor(), s.getBorderColor(), paper);
    }

    @Override
    public final void draw(final Canvas c, final BufferedImage paper) {
        // // TODO Auto-generated method stub
        for (int i = 0; i < c.getHeight(); i++) {
            for (int j = 0; j < c.getWidth(); j++) {
                paper.setRGB(i, j, c.getBorderColor().getRGB());
            }
        }
    }

    @Override
    public final void draw(final Line l, final BufferedImage paper) {
        // TODO Auto-generated method stub
        int x1 = l.getxStart();
        int x2 = l.getxFinish();
        int y1 = l.getyStart();
        int y2 = l.getyFinis();

        if (x1 == x2) {
            if (y1 < y2) {
                for (int i = y1; i <= y2; i++) {
                    if (checkBorder(x1, i, paper)) {
                        paper.setRGB(x1, i, l.getColor().getRGB());
                    }
                }
            } else {
                for (int i = y2; i <= y1; i++) {
                    if (checkBorder(x1, i, paper)) {
                        paper.setRGB(x1, i, l.getColor().getRGB());
                    }
                }
            }
            return;
        }
       
        int deltaX = Math.abs(x2 - x1);
        int deltaY = Math.abs(y2 - y1);
        int s1 = (int) (Math.signum(x2 - x1) * 1);
        int s2 = (int) (Math.signum(y2 - y1) * 1);

        boolean interchanged = false;
        if (deltaY > deltaX) {
            int aux = deltaX;
            deltaX = deltaY;
            deltaY = aux;
            interchanged = true;
        }

        int error = 2 * deltaY - deltaX;

        for (int i = 0; i <= deltaX; i++) {
            if (x1 >= 0 && y1 >= 0 && x1 < paper.getWidth() && y1 < paper.getHeight()) {

                paper.setRGB(x1, y1, l.getColor().getRGB());
            }
            while (error > 0) {
                if (interchanged) {
                    x1 = x1 + s1;
                } else {
                    y1 = y1 + s2;
                }
                error = error - 2 * deltaX;
            }

            if (interchanged) {
                y1 = y1 + s2;
            } else {
                x1 = x1 + s1;
            }

            error = error + 2 * deltaY;
        }
    }

    @Override
    public final void draw(final Square s, final BufferedImage paper) {
        // TODO Auto-generated method stub
        String red;
        String green;
        String blue;
        if (Integer.toHexString(s.getBorderColor().getRed()).length() == 1) {
            red = "0" + Integer.toHexString(s.getBorderColor().getRed());
        } else {
            red = Integer.toHexString(s.getBorderColor().getRed());
        }
        if (Integer.toHexString(s.getBorderColor().getGreen()).length() == 1) {
            green = "0" + Integer.toHexString(s.getBorderColor().getGreen());
        } else {
            green = Integer.toHexString(s.getBorderColor().getGreen());
        }
        if (Integer.toHexString(s.getBorderColor().getBlue()).length() == 1) {
            blue = "0" + Integer.toHexString(s.getBorderColor().getBlue());
        } else {
            blue = Integer.toHexString(s.getBorderColor().getBlue());
        }
        String color = "#" + red + green + blue;
        
        draw(new Line((String.valueOf(s.getxSus())), String.valueOf(s.getySus()),
                String.valueOf(s.getxSus() + s.getLatura() - 1), String.valueOf(s.getySus()), color,
                String.valueOf(s.getBorderColor().getAlpha()), paper), paper);

        draw(new Line((String.valueOf(s.getxSus() + s.getLatura() - 1)),
                String.valueOf(s.getySus()), String.valueOf(s.getxSus() + s.getLatura() - 1),
                String.valueOf(s.getySus() + s.getLatura() - 1), color,
                String.valueOf(s.getBorderColor().getAlpha()), paper), paper);

        draw(new Line((String.valueOf(s.getxSus() + s.getLatura() - 1)),
                String.valueOf(s.getySus() + s.getLatura() - 1), String.valueOf(s.getxSus()),
                String.valueOf(s.getySus() + s.getLatura() - 1), color,
                String.valueOf(s.getBorderColor().getAlpha()), paper), paper);

        draw(new Line((String.valueOf(s.getxSus())),
                String.valueOf(s.getySus() + s.getLatura() - 1), String.valueOf(s.getxSus()),
                String.valueOf(s.getySus()), color, String.valueOf(s.getBorderColor().getAlpha()),
                paper), paper);
        for (int i = s.getxSus() + 1; i < s.getxSus() + s.getLatura() - 1; i++) {
            for (int j = s.getySus() + 1; j < s.getySus() + s.getLatura() - 1; j++) {
                if (checkBorder(i, j, paper)) {
                    paper.setRGB(i, j, s.getFillColor().getRGB());
                }
            }
        }

    }

    @Override
    public final void draw(final Rectangle r, final BufferedImage paper) {
        // TODO Auto-generated method stubString red;
        String red;
        String green;
        String blue;
        if (Integer.toHexString(r.getBorderColor().getRed()).length() == 1) {
            red = "0" + Integer.toHexString(r.getBorderColor().getRed());
        } else {
            red = Integer.toHexString(r.getBorderColor().getRed());
        }
        if (Integer.toHexString(r.getBorderColor().getGreen()).length() == 1) {
            green = "0" + Integer.toHexString(r.getBorderColor().getGreen());
        } else {
            green = Integer.toHexString(r.getBorderColor().getGreen());
        }
        if (Integer.toHexString(r.getBorderColor().getBlue()).length() == 1) {
            blue = "0" + Integer.toHexString(r.getBorderColor().getBlue());
        } else {
            blue = Integer.toHexString(r.getBorderColor().getBlue());
        }
        String color = "#" + red + green + blue;

        draw(new Line((String.valueOf(r.getxSus())), String.valueOf(r.getySus()),
                String.valueOf(r.getxSus() + r.getLungime() - 1), String.valueOf(r.getySus()),
                color, String.valueOf(r.getBorderColor().getAlpha()), paper), paper);

        draw(new Line((String.valueOf(r.getxSus() + r.getLungime() - 1)),
                String.valueOf(r.getySus()), String.valueOf(r.getxSus() + r.getLungime() - 1),
                String.valueOf(r.getySus() + r.getInaltime() - 1), color,
                String.valueOf(r.getBorderColor().getAlpha()), paper), paper);

        draw(new Line((String.valueOf(r.getxSus() + r.getLungime() - 1)),
                String.valueOf(r.getySus() + r.getInaltime() - 1), String.valueOf(r.getxSus()),
                String.valueOf(r.getySus() + r.getInaltime() - 1), color,
                String.valueOf(r.getBorderColor().getAlpha()), paper), paper);

        draw(new Line((String.valueOf(r.getxSus())),
                String.valueOf(r.getySus() + r.getInaltime() - 1), String.valueOf(r.getxSus()),
                String.valueOf(r.getySus()), color, String.valueOf(r.getBorderColor().getAlpha()),
                paper), paper);

        for (int i = r.getxSus() + 1; i < r.getxSus() + r.getLungime() - 1; i++) {
            for (int j = r.getySus() + 1; j < r.getySus() + r.getInaltime() - 1; j++) {
                if (checkBorder(i, j, paper)) {
                    paper.setRGB(i, j, r.getFillColor().getRGB());
                }
            }
        }
    }

    @Override
    public final void draw(final Diamond d, final BufferedImage paper) {
        // TODO Auto-generated method stub
        String red;
        String green;
        String blue;
        if (Integer.toHexString(d.getBorderColor().getRed()).length() == 1) {
            red = "0" + Integer.toHexString(d.getBorderColor().getRed());
        } else {
            red = Integer.toHexString(d.getBorderColor().getRed());
        }
        if (Integer.toHexString(d.getBorderColor().getGreen()).length() == 1) {
            green = "0" + Integer.toHexString(d.getBorderColor().getGreen());
        } else {
            green = Integer.toHexString(d.getBorderColor().getGreen());
        }
        if (Integer.toHexString(d.getBorderColor().getBlue()).length() == 1) {
            blue = "0" + Integer.toHexString(d.getBorderColor().getBlue());
        } else {
            blue = Integer.toHexString(d.getBorderColor().getBlue());
        }   
        String color = "#" + red + green + blue;
        draw(new Line((String.valueOf(d.getX())),
                String.valueOf(d.getY() - (d.getDiagVerticala() / 2)),
                String.valueOf(d.getX() - (d.getDiagOrizontala() / 2)), String.valueOf(d.getY()),
                color, String.valueOf(d.getBorderColor().getAlpha()), paper), paper);

        draw(new Line((String.valueOf(d.getX() - (d.getDiagOrizontala() / 2))),
                String.valueOf(d.getY()), String.valueOf(d.getX()),
                String.valueOf(d.getY() + (d.getDiagVerticala() / 2)), color,
                String.valueOf(d.getBorderColor().getAlpha()), paper), paper);

        draw(new Line((String.valueOf(d.getX())),
                String.valueOf(d.getY() + (d.getDiagVerticala() / 2)),
                String.valueOf(d.getX() + (d.getDiagOrizontala() / 2)), String.valueOf(d.getY()),
                color, String.valueOf(d.getBorderColor().getAlpha()), paper), paper);

        draw(new Line((String.valueOf(d.getX() + (d.getDiagOrizontala() / 2))),
                String.valueOf(d.getY()), String.valueOf(d.getX()),
                String.valueOf(d.getY() - (d.getDiagVerticala() / 2)), color,
                String.valueOf(d.getBorderColor().getAlpha()), paper), paper);

        floodFill(d.getX(), d.getY(), d.getFillColor(), d.getBorderColor(), paper);
    }

    @Override
    public final void draw(final Polygon p, final BufferedImage paper) {
        // TODO Auto-generated method stub
        String red;
        String green;
        String blue;
        if (Integer.toHexString(p.getBorderColor().getRed()).length() == 1) {
            red = "0" + Integer.toHexString(p.getBorderColor().getRed());
        } else {
            red = Integer.toHexString(p.getBorderColor().getRed());
        }
        if (Integer.toHexString(p.getBorderColor().getGreen()).length() == 1) {
            green = "0" + Integer.toHexString(p.getBorderColor().getGreen());
        } else {
            green = Integer.toHexString(p.getBorderColor().getGreen());
        }
        if (Integer.toHexString(p.getBorderColor().getBlue()).length() == 1) {
            blue = "0" + Integer.toHexString(p.getBorderColor().getBlue());
        } else {
            blue = Integer.toHexString(p.getBorderColor().getBlue());
        }
        String color = "#" + red + green + blue;
        int[] xCoordinates = p.getxCoordinates();
        int[] yCoordinates = p.getyCoordinates();

        for (int i = 0; i < (p.getNumberOfPints() - 1); i++) {
            draw(new Line((String.valueOf(xCoordinates[i])), String.valueOf(yCoordinates[i]),
                    String.valueOf(xCoordinates[i + 1]), String.valueOf(yCoordinates[i + 1]), color,
                    String.valueOf(p.getBorderColor().getAlpha()), paper), paper);
        }

        draw(new Line((String.valueOf(xCoordinates[p.getNumberOfPints() - 1])),
                String.valueOf(yCoordinates[p.getNumberOfPints() - 1]),
                String.valueOf(xCoordinates[0]), String.valueOf(yCoordinates[0]), color,
                String.valueOf(p.getBorderColor().getAlpha()), paper), paper);

        int xc = 0;
        int yc = 0;
        for (int i = 0; i < p.getNumberOfPints(); i++) {
            xc += xCoordinates[i];
            yc += yCoordinates[i];
        }
        xc = xc / p.getNumberOfPints();
        yc = yc / p.getNumberOfPints();
        floodFill(xc, yc, p.getFillColor(), p.getBorderColor(), paper);
    }

    @Override
    public final void draw(final Triangle t, final BufferedImage paper) {
        // TODO Auto-generated method stub
        String red;
        String green;
        String blue;
        if (Integer.toHexString(t.getBorderColor().getRed()).length() == 1) {
            red = "0" + Integer.toHexString(t.getBorderColor().getRed());
        } else {
            red = Integer.toHexString(t.getBorderColor().getRed());
        }
        if (Integer.toHexString(t.getBorderColor().getGreen()).length() == 1) {
            green = "0" + Integer.toHexString(t.getBorderColor().getGreen());
        } else {
            green = Integer.toHexString(t.getBorderColor().getGreen());
        }
        if (Integer.toHexString(t.getBorderColor().getBlue()).length() == 1) {
            blue = "0" + Integer.toHexString(t.getBorderColor().getBlue());
        } else {
            blue = Integer.toHexString(t.getBorderColor().getBlue());
        }
        String color = "#" + red + green + blue;
        draw(new Line((String.valueOf(t.getX1())), String.valueOf(t.getY1()),
                String.valueOf(t.getX2()), String.valueOf(t.getY2()), color,
                String.valueOf(t.getBorderColor().getAlpha()), paper), paper);

        draw(new Line((String.valueOf(t.getX2())), String.valueOf(t.getY2()),
                String.valueOf(t.getX3()), String.valueOf(t.getY3()), color,
                String.valueOf(t.getBorderColor().getAlpha()), paper), paper);

        draw(new Line((String.valueOf(t.getX3())), String.valueOf(t.getY3()),
                String.valueOf(t.getX1()), String.valueOf(t.getY1()), color,
                String.valueOf(t.getBorderColor().getAlpha()), paper), paper);
        final int trei = 3;
        int xc = (t.getX1() + t.getX2() + t.getX3()) / trei;
        int yc = (t.getY1() + t.getY2() + t.getY3()) / trei;
        floodFill(xc, yc, t.getFillColor(), t.getBorderColor(), paper);

    }

}
