import greenfoot.*;

public class Ebene1 extends Ebene 
{
    public Ebene1()
    {
        raeume = new Raum[3][3];
        RaumPool rp = new RaumPool();
        raeume[0][0] = rp.getRaum(new RaumInfo().requireTuerUnten().requireTuerRechts());
        raeume[0][1] = rp.getRaum(new RaumInfo().requireTuerUnten().requireTuerLinks());
        raeume[1][0] = rp.getRaum(new RaumInfo().requireTuerUnten().requireTuerOben().requireTuerRechts());
        raeume[1][1] = rp.getRaum(new RaumInfo().requireTuerUnten().requireTuerOben().requireTuerRechts().requireTuerLinks());
        raeume[1][2] = rp.getRaum(new RaumInfo().requireTuerOben().requireTuerLinks());
        raeume[2][0] = rp.getRaum(new RaumInfo().requireTuerOben().requireTuerRechts());
        raeume[2][1] = rp.getRaum(new RaumInfo().requireTuerOben().requireTuerRechts().requireTuerLinks());
        raeume[2][2] = rp.getRaum(new RaumInfo().requireTuerLinks());
        
        raeume[0][2] = Raum.laden("1Thronsaal");
        raeume[0][2].addObject(new Boss(3, "Bosse\\Boss1.png"), 4, 5);
        
        raeume[1][2].addBossTuer();
        
        Spieler s = new Spieler();
        s.setEbene(this);
        raeume[2][0].addSpieler(s);
        Greenfoot.setWorld(raeume[2][0]);
        rx = 0;
        ry = 2;
    }
}
