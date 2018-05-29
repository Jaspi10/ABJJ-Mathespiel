import greenfoot.*;
public abstract class Ebene
{
    Raum[][] raeume;
    int rx,ry;
    public Ebene()
    {

    }
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
}
