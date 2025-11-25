package math;

public abstract class Coordinate
{
    protected double[] coord;

    public Coordinate(int n)
    {
        this.coord = new double[n];
    }

    public Coordinate(double[] values)
    {
        this.coord = values;
    }

    public Coordinate(Coordinate c)
    {
        this.coord = c.getCoords();
    }

    protected void randomize()
    {
        this.randomize(-10, 10);
    }

    protected void randomize(double min, double max)
    {
        double range = (double) max - min;
        for (double val : this.coord)
        {
            val = (Math.random() * range) + min;
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
        if (n < this.coord.length) return this.coord[n];
        else throw new RuntimeException("Dimension out of range");
    }

    public void setCoord(int n, double value)
    {
        if (n < this.coord.length) this.coord[n] = value;
        else throw new RuntimeException("Dimension out of range");
    }

    public double[] getCoords()
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