package com.kodilla.testing.shape;

import com.kodilla.testing.forum.ForumComment;

import java.util.ArrayList;

public class ShapeCollector {
    ArrayList<Shape> figures = new ArrayList<Shape>();

    public void addFigure(Shape shape) {
        figures.add(shape);
    }

    public boolean removeFigure(Shape shape) {
        boolean result = false;
        if (figures.contains(shape)) {
            figures.remove(shape);
            result = true;
        }
        return result;
    }

    public Shape getFigure(int n) {
        Shape shape = null;
        if (n >= 0 && n < figures.size()) {
            shape = figures.get(n);
        }
        return shape;
    }

    public ArrayList<Shape> showFigures() {
        return figures;
    }
}
