package math;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class Coordinate
{
    protected double[] coord;

    protected Coordinate()
    {
    }

    public Coordinate(double[] values)
    {
        this.coord = values;
    }

    public Coordinate(Coordinate c)
    {
        this.coord = c.getCoords();
    }

    public void randomize(Number min, Number max)
    {
        int range = (int) max - (int) min;
        for (int i = 0; i < this.getDimension(); i++)
        {
            setCoord(i, (Math.random() * range) + (int) min);
        }
    }

    public Vector toVector()
    {
        return new Vector(this.coord);
    }

    public Point toPoint()
    {
        return new Point(this.coord);
    }

    public double getCoord(int n)
    {
        if (n < this.getDimension()) return this.coord[0];
        else throw new RuntimeException("Dimension out of range");
    }

    public void setCoord(int n, double value)
    {
        if (n < this.getDimension()) this.coord[n] = value;
        else throw new RuntimeException("Dimension out of range");
    }

    public double[] getCoords()
    {
        return this.coord;
    }

    public void setCoords(double[] values)
    {
        if (this.getDimension() != values.length) throw new RuntimeException("Dimension mismatch");
        else this.coord = values;
    }

    public int getDimension()
    {
        return this.coord.length;
    }

    @Override
    public String toString()
    {
        StringBuilder output = new StringBuilder("(");
        for (int i = 0; i < this.getDimension(); i++)
        {
            output.append(this.getCoord(i));
            if (i != this.getDimension() - 1) output.append("|");
        }
        return output.append(")").toString();
    }
}