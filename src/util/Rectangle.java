package util;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Rectangle {

    private Line<Point3D> line0;
    private Line<Point3D> line1;
    private Line<Point3D> line2;
    private Line<Point3D> line3;

    private boolean isVisible;
    private Color color;
    private Texture texture;

    public Rectangle(Color color, Line<Point3D> line0, Line<Point3D> line1, Line<Point3D> line2, Line<Point3D> line3) {
        this(line0, line1, line2, line3);
        this.color = color;
        isVisible = false;
        texture = new Texture(color);
    }

    public Rectangle(Line<Point3D> line0, Line<Point3D> line1, Line<Point3D> line2, Line<Point3D> line3) {

        this.line0 = line0;
        this.line1 = (line1.getStart().equals(line0.getEnd())) ? line1 : line1.reverse();
        this.line2 = (line2.getStart().equals(line1.getEnd())) ? line2 : line2.reverse();
        this.line3 = (line3.getStart().equals(line2.getEnd())) ? line3 : line3.reverse();

        isVisible = false;
    }

    public Color getColor() {
        return color;
    }

    public Texture getTexture() {
        return texture;
    }

    public boolean contains(Line<Point3D> line) {
        return line0.equals(line) || line1.equals(line) || line2.equals(line) || line3.equals(line);
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }

    public List<Point3D> getPoints() {
        List<Point3D> points = new ArrayList<Point3D>();
        points.add(line0.getStart());
        points.add(line1.getStart());
        points.add(line2.getStart());
        points.add(line3.getStart());
        return points;
    }
}

