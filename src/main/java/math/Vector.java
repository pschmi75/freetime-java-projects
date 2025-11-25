package math;

import java.lang.Math;
import java.util.ArrayList;

public class Vector<Number> extends Coordinate<Number>
{
    public Vector(int n)
    {
        super(n);
    }

    public Vector(Number[] values)
    {
        super(values);
    }

    public Vector(Vector<Number> v)
    {
        super(v);
    }

    public double getLength()
    {
        double sqrSum = 0;
        for (int i = 0; i < this.getDimension(); i++) sqrSum += (Math.pow((double) this.coord.get(i), 2));
        return Math.sqrt(sqrSum);
    }
/*
    public Vector<Number> unitVector()
    {
        ArrayList<Number> newCoord = coord;
        for (int i = 0; i < newCoord.size(); i++)
        {
            newCoord.set(i, (double) newCoord.get(i) / this.getLength());
        }
        return new Vector(newCoord);
    }
*/
    @Override
    public String toString() {
        if (this.getDimension() == 1) return "|" + this.coord.getFirst() + "|";
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < this.getDimension(); i++)
        {
            if (i == 0)
            {
                output.append("⌈");
                output.append(this.coord.get(i));
                output.append("⌉\n");
            }
            if (i > 0 && i < this.getDimension() - 1)
            {
                output.append("|");
                output.append(this.coord.get(i));
                output.append("|\n");
            }
            if (i == this.getDimension() - 1)
            {
                output.append("⌊");
                output.append(this.coord.get(i));
                output.append("⌋\n");
            }
        }
        return output.toString();
    }
}