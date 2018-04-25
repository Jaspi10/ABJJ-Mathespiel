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
}
