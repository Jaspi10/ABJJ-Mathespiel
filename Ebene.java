import greenfoot.*;
public class Ebene
{
    Raum[][] raeume = new Raum[3][3];
    int rx,ry;
    public Ebene()
    {
        RaumPool rp = new RaumPool();
        raeume[0][1] = rp.getRaum(new RaumInfo().requireTuerUnten());
        raeume[1][0] = rp.getRaum(new RaumInfo().requireTuerUnten().requireTuerRechts());
        raeume[1][1] = rp.getRaum(new RaumInfo().requireTuerUnten().requireTuerRechts().requireTuerLinks().requireTuerOben());
        raeume[1][2] = rp.getRaum(new RaumInfo().requireTuerUnten().requireTuerLinks());
        raeume[2][0] = rp.getRaum(new RaumInfo().requireTuerOben().requireTuerRechts());
        raeume[2][1] = rp.getRaum(new RaumInfo().requireTuerOben().requireTuerLinks().requireTuerRechts());
        raeume[2][2] = rp.getRaum(new RaumInfo().requireTuerOben().requireTuerLinks());
        
        
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
