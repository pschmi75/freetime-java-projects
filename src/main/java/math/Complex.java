package math;
import java.lang.Math;

public class Complex
{

    double re;
    double im;

    public Complex(double pRe, double pIm)
    {
        this.re = pRe;
        this.im = pIm;
    }

    public Complex(double reOrRad, double imOrTheta, boolean polar)
    {
        if (!polar)
        {
            this.re = reOrRad;
            this.im = imOrTheta;
        }
        else
        {
            this.re = reOrRad * Math.cos(imOrTheta);
            this.im = reOrRad * Math.sin(imOrTheta);
        }
    }

    public Complex(Complex z)
    {
        this.re = z.getRe();
        this.im = z.getIm();
    }

    public Complex getComplexConjugate()
    {
        return new Complex(this.re, this.im * -1);
    }

    public Complex add(Complex z)
    {
        return new Complex(this.re += z.getRe(), this.im += z.getIm());
    }

    public Complex subtract(Complex z)
    {
        z.setRe(-z.getRe());
        z.setIm(-z.getIm());
        return this.add(z);
    }

    public Complex multiply(Complex z)
    {
        double a1 = this.re;
        double b1 = this.im;
        double a2 = z.getRe();
        double b2 = z.getIm();

        return new Complex(a1 * a2 + b1 * b2, a1 * b2 + a2 * b1);
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
        if (this.re != 0.0) rePart += this.re;
        String imPart = "";
        if (this.im != 0.0)
        {
            imPart += this.im + "i";
        }
        if (!rePart.isEmpty() && !imPart.isEmpty()) return rePart + " + " + imPart;
        else return rePart + imPart;
    }
}