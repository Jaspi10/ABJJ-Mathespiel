import greenfoot.*;

public class Ebene1 extends Ebene 
{
    public Ebene1()
    {
        RaumPool rp = new RaumPool();
        raeume[0][1] = rp.getRaum(new RaumInfo().requireTuerUnten().requireIstBoss());
        raeume[1][0] = rp.getRaum(new RaumInfo().requireTuerUnten().requireTuerRechts());
        raeume[1][1] = rp.getRaum(new RaumInfo().requireTuerUnten().requireTuerRechts().requireTuerLinks().requireTuerOben());
        raeume[1][2] = rp.getRaum(new RaumInfo().requireTuerUnten().requireTuerLinks());
        raeume[2][0] = rp.getRaum(new RaumInfo().requireTuerOben().requireTuerRechts().requireIstStart());
        raeume[2][1] = rp.getRaum(new RaumInfo().requireTuerOben().requireTuerLinks().requireTuerRechts());
        raeume[2][2] = rp.getRaum(new RaumInfo().requireTuerOben().requireTuerLinks());
        
        raeume[1][1].addBossTuer();
        
        Spieler s = new Spieler();
        s.setEbene(this);
        raeume[2][0].addObject(s, 1, 8);
        Greenfoot.setWorld(raeume[2][0]);
        rx = 0;
        ry = 2;
    }
}
