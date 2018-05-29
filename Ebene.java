import greenfoot.*;
public abstract class Ebene
{
    Raum[][] raeume;
    int rx,ry;
    private int anzahlGegner = -1;
    
    public void raumwechsel(Spieler s, Richtung r)
    {
        int sx = s.getX();
        int sy = s.getY();
        
        raeume[ry][rx].removeObject(s);
        rx = rx + r.dx;
        ry = ry + r.dy;
        raeume[ry][rx].addObject(s,sx,sy);
        
        switch (r) 
        {
            case LINKS:
                s.setLocation(9, sy);
                break;
            case RECHTS:
                s.setLocation(0, sy);
                break;
            case OBEN:
                s.setLocation(sx, 9);
                break;
            case UNTEN:
                s.setLocation(sx, 0);
                break;
        }
        Greenfoot.setWorld(raeume[ry][rx]);
    }
    
    protected int zaehleGegner()
    {
        int rv = 0;
        
        for (int i = 0; i < raeume.length; i++)
        {
            for (int j = 0; j < raeume[0].length; j++)
            {
                rv += raeume[j][i].anzahlGegner();
            }
        }
        
        return rv;
    }
    
    public int anzahlGegner() 
    {
        if (anzahlGegner == -1)
        {
            anzahlGegner = zaehleGegner();
        }
        
        return anzahlGegner;
    }
}
