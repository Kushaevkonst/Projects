package poligonsproject;

import java.util.List;

/**
 *
 * @author дом
 */
public class Verticles {

    private List<Vertice> verticles;
    public Verticles() {
    }
    public Verticles(List<Vertice> verticles) {
        if (verticles.size() < 3) {
            throw new IllegalArgumentException("List<Vertice> should be greater then 2");
        }
        this.verticles = verticles;
    }

    public List<Vertice> getVertices() {
        return verticles;
    }

    public void setVertices(List<Vertice> verticles) {
        this.verticles = verticles;
    }

    public class Vertice {

        Vertice(float x, float y) {
            this.x = x;
            this.y = y;
        }

        private float x;

        public float getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        private float y;

        public float getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        @Override
        public String toString() {
            return String.format("(%f; %f)", x, y);

        }
    }

}
