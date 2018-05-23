import greenfoot.*;
public class Ebene
{
    Raum[][] raeume = new Raum[3][3];
    int rx,ry;
    public Ebene()
    {            
        raeume[0][1] = new Raum(false, true, false, false);
        raeume[1][0] = new Raum(false, true, false, true);
        raeume[1][1] = new Raum(true, true, true, true);
        raeume[1][2] = new Raum(false, true, true, false);
        raeume[2][0] = new Raum(true, false, false, true);
        raeume[2][1] = new Raum(true, false, true, true);
        raeume[2][2] = new Raum(true, false, true, false);
        
        
        raeume[2][0].addGegner(new Gegner());
        raeume[1][1].addBossTuer();
        
        Spieler s = new Spieler();
        s.setEbene(this);
        raeume[2][0].addObject(s, 1, 8);
        Greenfoot.setWorld(raeume[2][0]);
        rx = 0;
        ry = 2;
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
