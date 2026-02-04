package math;

import java.lang.Math;
import java.util.ArrayList;

public class Vector extends Coordinate
{
    protected Vector()
    {
    }

    public Vector(double[] values)
    {
        super(values);
    }

    public Vector(Vector v)
    {
        super(v);
    }

    public Vector(Point p, Point q)
    {
        if (p.getDimension() != q.getDimension()) throw new RuntimeException("Dimension mismatch");
        else {
            for (int i = 0; i < p.getDimension(); i++)
            {
                this.setCoord(i, q.getCoord(i) - p.getCoord(i));
            }
        }
    }

    public double getLength()
    {
        double sqrSum = 0;
        for (int i = 0; i < this.getDimension(); i++) sqrSum += (Math.pow(this.getCoord(i), 2));
        return Math.sqrt(sqrSum);
    }

    public Vector unitVector()
    {
        double[] newCoord = new double[this.getDimension()];
        for (int i = 0; i < newCoord.length; i++)
        {
            newCoord[i] = newCoord[i] / this.getLength();
        }
        return new Vector(newCoord);
    }

    public double scalar(Vector v) {
        if (this.getDimension() != v.getDimension()) throw new RuntimeException("Dimension mismatch");
        else {
            double sum = 0;
            for (int i = 0; i < this.getDimension(); i++) {
                sum += this.getCoord(i) * v.getCoord(i);
            }
            return sum;
        }
    }

    public double norm(Vector v) {
        return Math.sqrt(this.scalar(v));
    }
}