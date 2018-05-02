import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Raum2 extends Ebene1
{
    public Raum2()
    {
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Wand wand = new Wand();
        addObject(wand,0,9);
        Wand wand2 = new Wand();
        addObject(wand2,0,8);
        Wand wand3 = new Wand();
        addObject(wand3,0,7);
        Wand wand4 = new Wand();
        addObject(wand4,0,6);
        Wand wand5 = new Wand();
        addObject(wand5,0,3);
        Wand wand6 = new Wand();
        addObject(wand6,0,2);
        Wand wand7 = new Wand();
        addObject(wand7,0,1);
        Wand wand8 = new Wand();
        addObject(wand8,0,0);
        Wand wand9 = new Wand();
        addObject(wand9,1,0);
        Wand wand10 = new Wand();
        addObject(wand10,1,9);
    }
}
