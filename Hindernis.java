import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Hindernis extends Actor
{
    
    private static final String ORDNER_HINDERNIS = "images\\hindernis";
    private static final ImagePool POOL_HINDERNIS = new ImagePool(ORDNER_HINDERNIS);

    public Hindernis()
    {
        setImage(POOL_HINDERNIS.getImage());
    }
}
