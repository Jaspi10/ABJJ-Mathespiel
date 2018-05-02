import java.util.Random;

//Knoten ohne Kinder mit Zahlenwert
public class KnotenZahl extends Knoten
{
    double wert;
    
    public KnotenZahl(double wert) 
    {
        this.wert = wert;
    }
    
    @Override
    public double auswerten() 
    {
        return wert;
    }
    
    @Override
    public String knotenZuString()
    {
        return ""+ wert;
    }
    
    public static Knoten generiere(Random r, int min, int max) {
        //Zufallszahl zwischen min und max
        return new KnotenZahl(r.nextInt(max-min)+min);
    }
}
