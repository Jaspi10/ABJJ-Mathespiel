import greenfoot.*;

public class R_2_0 extends Ebene1
{

    public R_2_0()
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
        addObject(wand,7,0);
        Wand wand2 = new Wand();
        addObject(wand2,8,0);
        Wand wand3 = new Wand();
        addObject(wand3,9,0);
        Wand wand4 = new Wand();
        addObject(wand4,9,1);
        Wand wand5 = new Wand();
        addObject(wand5,9,2);
        Wand wand6 = new Wand();
        addObject(wand6,9,3);
        Wand wand7 = new Wand();
        addObject(wand7,6,0);
        Wand wand8 = new Wand();
        addObject(wand8,3,0);
        Wand wand9 = new Wand();
        addObject(wand9,2,0);
        Wand wand10 = new Wand();
        addObject(wand10,1,0);
        Wand wand11 = new Wand();
        addObject(wand11,0,0);
        Wand wand12 = new Wand();
        addObject(wand12,9,6);
        Wand wand13 = new Wand();
        addObject(wand13,9,7);
        Wand wand14 = new Wand();
        addObject(wand14,9,8);
        Wand wand15 = new Wand();
        addObject(wand15,9,9);
        Wand wand16 = new Wand();
        addObject(wand16,6,8);
        Wand wand17 = new Wand();
        addObject(wand17,7,4);
        Wand wand18 = new Wand();
        addObject(wand18,4,5);
        Wand wand19 = new Wand();
        addObject(wand19,3,4);
        Wand wand20 = new Wand();
        addObject(wand20,3,3);
        wand20.setLocation(0,1);
        wand19.setLocation(0,2);
        wand18.setLocation(0,3);
        wand17.setLocation(0,4);
        wand16.setLocation(6,8);
        wand16.setLocation(6,8);
        wand16.setLocation(6,8);
        wand16.setLocation(0,5);
        Wand wand21 = new Wand();
        addObject(wand21,0,7);
        Wand wand22 = new Wand();
        addObject(wand22,0,6);
        Wand wand23 = new Wand();
        addObject(wand23,0,8);
        Wand wand24 = new Wand();
        addObject(wand24,0,9);
        Wand wand25 = new Wand();
        addObject(wand25,1,9);
        Wand wand26 = new Wand();
        addObject(wand26,2,9);
        Wand wand27 = new Wand();
        addObject(wand27,3,9);
        Wand wand28 = new Wand();
        addObject(wand28,4,9);
        Wand wand29 = new Wand();
        addObject(wand29,5,9);
        Wand wand30 = new Wand();
        addObject(wand30,6,9);
        Wand wand31 = new Wand();
        addObject(wand31,8,9);
        Wand wand32 = new Wand();
        addObject(wand32,7,9);
        Spieler spieler = new Spieler();
        addObject(spieler,1,8);
        GegnerX gegnerx = new GegnerX();
        addObject(gegnerx,3,1);
        GegnerY gegnery = new GegnerY();
        addObject(gegnery,8,6);
        Gegner gegner = new Gegner();
        addObject(gegner,8,1);
    }
}
