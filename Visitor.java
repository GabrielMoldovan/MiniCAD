import java.awt.image.BufferedImage;

public interface Visitor {
   void draw(Circle s, BufferedImage paper);
   void draw(Canvas c, BufferedImage paper);
   void draw(Line l, BufferedImage paper);
   void draw(Square s, BufferedImage paper);
   void draw(Rectangle r, BufferedImage paper);
   void draw(Diamond d, BufferedImage paper);
   void draw(Polygon p, BufferedImage paper);
   void draw(Triangle t, BufferedImage paper);
}