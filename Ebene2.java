import greenfoot.*;

public class Ebene2 extends Ebene 
{    
    public Ebene2()
    {
        raeume = new Raum[4][4];
        RaumPool rp = new RaumPool();
        raeume[0][0] = rp.getRaum(new RaumInfo().requireTuerUnten().requireTuerRechts());
        raeume[0][1] = rp.getRaum(new RaumInfo().requireTuerUnten().requireTuerLinks());
        raeume[0][2] = rp.getRaum(new RaumInfo().requireTuerUnten().requireTuerRechts());
        raeume[0][3] = rp.getRaum(new RaumInfo().requireTuerUnten().requireTuerLinks());
        raeume[1][0] = rp.getRaum(new RaumInfo().requireTuerOben().requireTuerRechts());
        raeume[1][1] = rp.getRaum(new RaumInfo().requireTuerUnten().requireTuerOben().requireTuerRechts().requireTuerLinks());
        raeume[1][2] = rp.getRaum(new RaumInfo().requireTuerUnten().requireTuerOben().requireTuerRechts().requireTuerLinks());
        raeume[1][3] = rp.getRaum(new RaumInfo().requireTuerUnten().requireTuerOben().requireTuerLinks());
        raeume[2][0] = rp.getRaum(new RaumInfo().requireTuerUnten());
        raeume[2][1] = rp.getRaum(new RaumInfo().requireTuerUnten().requireTuerOben().requireTuerRechts());
        raeume[2][2] = rp.getRaum(new RaumInfo().requireTuerOben().requireTuerRechts().requireTuerLinks());
        raeume[2][3] = rp.getRaum(new RaumInfo().requireTuerUnten().requireTuerOben().requireTuerLinks());
        raeume[3][0] = rp.getRaum(new RaumInfo().requireTuerOben().requireTuerRechts());
        raeume[3][1] = rp.getRaum(new RaumInfo().requireTuerOben().requireTuerRechts().requireTuerLinks());
        raeume[3][2] = rp.getRaum(new RaumInfo().requireTuerLinks());
        raeume[3][3] = rp.getRaum(new RaumInfo().requireTuerOben());
        
        raeume[3][0].addBossTuer();
        
        Spieler s = new Spieler();
        s.setEbene(this);
        raeume[0][3].addSpieler(s);
        Greenfoot.setWorld(raeume[0][3]);
        rx = 3;
        ry = 0;
    }
}
