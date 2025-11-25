package math;
import java.lang.Math;

public class Complex extends Number
{
    double re;
    double im;

    public Complex(double pRe, double pIm)
    {
        this.setRe(pRe);
        this.setIm(pIm);
    }

    public Complex(double reOrRad, double imOrTheta, boolean polar)
    {
        if (!polar)
        {
            this.setRe(reOrRad);
            this.setIm(imOrTheta);
        }
        else
        {
            this.setRe(reOrRad * Math.cos(imOrTheta));
            this.setIm(reOrRad * Math.sin(imOrTheta));
        }
    }

    public Complex(Complex z)
    {
        this.setRe(z.getRe());
        this.setIm(z.getIm());
    }

    public Complex getComplexConjugate()
    {
        return new Complex(this.getRe(), this.getIm() * -1);
    }

    public Complex add(Complex z)
    {
        return new Complex(this.getRe() + z.getRe(), this.getIm() + z.getIm());
    }

    public Complex subtract(Complex z)
    {
        z.setRe(-z.getRe());
        z.setIm(-z.getIm());
        return this.add(z);
    }

    public Complex multiply(Complex z)
    {
        double a1 = this.getRe();
        double b1 = this.getIm();
        double a2 = z.getRe();
        double b2 = z.getIm();

        return new Complex(a1 * a2 + b1 * b2, a1 * b2 + a2 * b1);
    }

    public Complex[] getRoots(int deg)
    {
        if (deg <= 1) throw new RuntimeException("Invalid degree");
        else
        {
            Complex[] roots = new Complex[deg];
            for (int i = 0; i < deg; i++)
            {
                roots[i] = new Complex(
                        Math.pow(this.getRad(), 1.0 / deg),
                        (this.getTheta() + (2 * Math.PI * i)) / deg,
                        true);
            }
            return roots;
        }
    }

    public double getRe()
    {
        return this.re;
    }

    public void setRe(double pRe)
    {
        this.re = pRe;
    }

    public double getIm()
    {
        return this.im;
    }

    public void setIm(double pIm)
    {
        this.im = pIm;
    }

    public double getRad()
    {
        return Math.sqrt(this.re * this.re + this.im * this.im);
    }

    public double getTheta()
    {
        return (Math.atan2(this.im, this.re) * 180) / Math.PI;
    }

    public String toString()
    {
        String rePart = "";
        if (this.getRe() != 0.0) rePart += this.getRe();
        String imPart = "";
        if (this.getIm() != 0.0) imPart += this.getIm() + "i";
        if (!rePart.isEmpty() && !imPart.isEmpty()) return rePart + " + " + imPart;
        else return rePart + imPart;
    }

    @Override
    public int intValue()
    {
        return (int) this.getRad();
    }

    @Override
    public long longValue()
    {
        return (long) this.getRad();
    }

    @Override
    public float floatValue()
    {
        return (float) this.getRad();
    }

    @Override
    public double doubleValue()
    {
        return (double) this.getRad();
    }
}