package math;

public class Straight
{
    protected Vector pos;
    protected Vector dir;
    protected char param;
    char[] params = {'α', 'β', 'γ', 'δ', 'λ', 'μ'};

    public Straight(Vector pPos, char pParam, Vector pDir)
    {
        if (pPos.getLength() != pDir.getLength()) throw new RuntimeException("Vectors have different dimensions");
        else
        {
            this.pos = pPos;
            this.param = pParam;
            this.dir = pDir;
        }
    }

    public Point get(double param)
    {
        double[] newCoord = new double[pos.getDimension()];
        for (int i = 0; i < newCoord.length; i++) newCoord[i] = pos.getCoord(i) + (param * dir.getCoord(i));
        return new Point(newCoord);
    }

    @Override
    public String toString()
    {
        return pos.toString()  + " + " + param + " * " + dir.toString();
    }

}