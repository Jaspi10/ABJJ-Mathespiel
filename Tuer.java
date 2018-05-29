import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Tuer extends Hindernis
{
    boolean rechts;
    
    private static final GreenfootImage BILD_TUER_LINKS = new GreenfootImage("images\\t�r.png");
    private static final GreenfootImage BILD_TEUR_RECHTS;
    
    static {
        GreenfootImage tmp = new GreenfootImage("images\\t�r.png");
        tmp.mirrorHorizontally();
        BILD_TEUR_RECHTS = tmp;
    }
    
    public Tuer (boolean rechts)
    {
        this.rechts = rechts;
        
        if (rechts) 
        {
            setImage(BILD_TEUR_RECHTS);
        } else 
        {
            setImage(BILD_TUER_LINKS);
        }
    }
    
    public void oeffne()
    {
        int offset = rechts ? -1 : 1;
        Tuer tuer2 = (Tuer) getOneObjectAtOffset(offset, 0, Tuer.class);
        
        getWorld().removeObject(tuer2);
        getWorld().removeObject(this);
    }
}
