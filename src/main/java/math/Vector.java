package math;

import java.lang.Math;

public class Vector extends Coordinate
{
    public Vector(int n)
    {
        super(n);
    }

    public Vector(double[] values)
    {
        super(values);
    }

    public Vector(Vector v)
    {
        super(v);
    }

    public double getLength()
    {
        double sqrSum = 0;
        for (int i = 0; i < this.getDimension(); i++) sqrSum += (this.coord[i] * this.coord[i]);
        return Math.sqrt(sqrSum);
    }

    public Vector unitVector()
    {
        double[] newCoord = coord;
        for (int i = 0; i < newCoord.length; i++)
        {
            newCoord[i] /= this.getLength();
        }
        return new Vector(newCoord);
    }

    @Override
    public String toString() {
        if (this.getDimension() == 1) return "|" + this.coord[0] + "|";
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < this.getDimension(); i++)
        {
            if (i == 0)
            {
                output.append("⌈");
                output.append(this.coord[i]);
                output.append("⌉\n");
            }
            if (i > 0 && i < this.getDimension() - 1)
            {
                output.append("|");
                output.append(this.coord[i]);
                output.append("|\n");
            }
            if (i == this.getDimension() - 1)
            {
                output.append("⌊");
                output.append(this.coord[i]);
                output.append("⌋\n");
            }
        }
        return output.toString();
    }
}