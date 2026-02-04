package math;

import java.util.ArrayList;

public class Point extends Coordinate
{
    protected Point()
    {
    }

    public Point(double[] values)
    {
        super(values);
    }

    public Point(Point p)
    {
        super(p);
    }

    public double distanceTo(Point p) {
        if (this.getDimension() != p.getDimension()) throw new RuntimeException("Dimension mismatch");
        else {
            double sum = 0;
            for (int i = 0; i < this.getDimension(); i++) {
                sum += Math.pow(this.getCoord(i) - p.getCoord(i), 2);
            }
            return Math.sqrt(sum);
        }
    }
}