package math;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class Coordinate<Number>
{
    protected ArrayList<Number> coord;

    protected Coordinate(int n)
    {
        this.coord = new ArrayList<>();
    }

    public Coordinate(Number[] values)
    {
        this.coord = new ArrayList<>(Arrays.asList(values));
    }

    public Coordinate(Coordinate<Number> c)
    {
        this.coord = c.getCoords();
    }
/*
    protected void randomize(Number min, Number max)
    {
        int range = (int) max - (int) min;
        for (int i = 0; i < this.coord.size(); i++)
        {
            coord.set(i, (Number) (Math.random() * range) + (int) min));
        }
    }
 */
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
        if (n < this.coord.length) return this.coord[n];
        else throw new RuntimeException("Dimension out of range");
    }

    public void setCoord(int n, double value)
    {
        if (n < this.coord.length) this.coord[n] = value;
        else throw new RuntimeException("Dimension out of range");
    }

    public ArrayList<Number> getCoords()
    {
        return this.coord;
    }

    public void setCoords(double[] values)
    {
        this.coord = values;
    }

    public int getDimension()
    {
        return this.coord.length;
    }
}