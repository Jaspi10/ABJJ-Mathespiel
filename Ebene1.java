import greenfoot.*;
public class Ebene1 extends World
{
    Raum[][] raeume = new Raum[3][3];
    int rx,ry;
    public Ebene1()
    {            
        super(10, 10, 50);
        raeume[0][1] = new R_0_1();
        raeume[1][0] = new R_1_0();
        raeume[1][1] = new R_1_1();
        raeume[1][2] = new R_1_2();
        raeume[2][0] = new R_2_0();
        raeume[2][1] = new R_2_1();
        raeume[2][2] = new R_2_2();
        
        Spieler s = new Spieler();
        s.setEbene(this);
        raeume[2][0].addObject(s, 1, 8);
        Greenfoot.setWorld(raeume[2][0]);
        rx = 0;
        ry = 2;
    }
    public void raumwechsel(Spieler s,int dx,int dy)
    {
        int sx = s.getX();
        int sy = s.getY();
        
        raeume[ry][rx].removeObject(s);
        rx = rx + dx;
        ry = ry + dy;
        raeume[ry][rx].addObject(s,sx,sy);
        if (dx == 1)
        {
            s.setLocation(0, sy);
        }
        if (dx == -1)
        {
            s.setLocation(9, sy);
        }
        if (dy == 1)
        {
            s.setLocation(sx, 0);
        }
        if (dy == -1)
        {
            s.setLocation(sx, 9);
        }
        Greenfoot.setWorld(raeume[ry][rx]);
    }
}
