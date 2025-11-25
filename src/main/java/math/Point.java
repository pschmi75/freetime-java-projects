package math;

public class Point extends Coordinate
{
    public Point(int n)
    {
        super(n);
    }

    public Point(double[] values)
    {
        super(values);
    }

    public Point(Point p)
    {
        super(p);
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