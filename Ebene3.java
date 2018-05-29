import greenfoot.*;

public class Ebene3 extends Ebene 
{    
    public Ebene3()
    {
        raeume = new Raum[5][5];
        RaumPool rp = new RaumPool();
        raeume[0][0] = rp.getRaum(new RaumInfo().requireTuerUnten().requireTuerRechts());
        raeume[0][1] = rp.getRaum(new RaumInfo().requireTuerLinks());
        raeume[0][2] = rp.getRaum(new RaumInfo().requireTuerUnten());
        raeume[0][3] = rp.getRaum(new RaumInfo().requireTuerRechts());
        raeume[0][4] = rp.getRaum(new RaumInfo().requireTuerUnten().requireTuerLinks());
        raeume[1][0] = rp.getRaum(new RaumInfo().requireTuerUnten().requireTuerOben());
        raeume[1][1] = rp.getRaum(new RaumInfo().requireTuerUnten().requireTuerRechts());
        raeume[1][2] = rp.getRaum(new RaumInfo().requireTuerOben().requireTuerRechts().requireTuerLinks());
        raeume[1][3] = rp.getRaum(new RaumInfo().requireTuerUnten().requireTuerLinks());
        raeume[1][4] = rp.getRaum(new RaumInfo().requireTuerUnten().requireTuerOben());
        raeume[2][0] = rp.getRaum(new RaumInfo().requireTuerOben().requireTuerRechts());
        raeume[2][1] = rp.getRaum(new RaumInfo().requireTuerUnten().requireTuerOben().requireTuerRechts().requireTuerLinks());
        raeume[2][2] = rp.getRaum(new RaumInfo().requireTuerUnten().requireTuerRechts().requireTuerLinks());
        raeume[2][3] = rp.getRaum(new RaumInfo().requireTuerUnten().requireTuerOben().requireTuerRechts().requireTuerLinks());
        raeume[2][4] = rp.getRaum(new RaumInfo().requireTuerOben().requireTuerLinks());
        raeume[3][0] = rp.getRaum(new RaumInfo().requireTuerUnten().requireTuerRechts());
        raeume[3][1] = rp.getRaum(new RaumInfo().requireTuerOben().requireTuerRechts().requireTuerLinks());
        raeume[3][2] = rp.getRaum(new RaumInfo().requireTuerUnten().requireTuerOben().requireTuerRechts().requireTuerLinks());
        raeume[3][3] = rp.getRaum(new RaumInfo().requireTuerOben().requireTuerRechts().requireTuerLinks());
        raeume[3][4] = rp.getRaum(new RaumInfo().requireTuerUnten().requireTuerLinks());
        raeume[4][0] = rp.getRaum(new RaumInfo().requireTuerOben().requireTuerRechts());
        raeume[4][1] = rp.getRaum(new RaumInfo().requireTuerRechts().requireTuerLinks());
        raeume[4][2] = rp.getRaum(new RaumInfo().requireTuerOben().requireTuerRechts().requireTuerLinks());
        raeume[4][3] = rp.getRaum(new RaumInfo().requireTuerRechts().requireTuerLinks());
        raeume[4][4] = rp.getRaum(new RaumInfo().requireTuerOben().requireTuerLinks());
        
        raeume[1][2].addBossTuer();
        
        Spieler s = new Spieler();
        s.setEbene(this);
        raeume[3][2].addSpieler(s);
        Greenfoot.setWorld(raeume[3][2]);
        rx = 2;
        ry = 3;
    }
}
