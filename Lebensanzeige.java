import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Lebensanzeige extends Actor 
{
    private static final String PFAD_HERZ = "images\\herz.png";
    private static final GreenfootImage BILD_HERZ = new GreenfootImage(PFAD_HERZ);
    
    public void update(int leben) 
    {
        if (leben <= 0)
        {
            setImage((GreenfootImage) null);
            return;
        }
        
        GreenfootImage img = new GreenfootImage(BILD_HERZ.getWidth() * leben * 2, BILD_HERZ.getHeight());
        
        for (int i = 0; i < leben; i++)
        {
            img.drawImage(BILD_HERZ, BILD_HERZ.getWidth() * leben + BILD_HERZ.getWidth() * i - 25, 0);
        }
        
        setImage(img);
    }
}
