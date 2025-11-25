package math;

public class Point<Number> extends Coordinate<Number>
{
    public Point(int n)
    {
        super(n);
    }

    public Point(Number[] values)
    {
        super(values);
    }

    public Point(Point<Number> p)
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