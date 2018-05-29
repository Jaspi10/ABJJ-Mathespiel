import greenfoot.*;

public class Spiel  
{
    private static int ebene;
    
    public static void neusSpiel()
    {
        ebene = 1;
        new Ebene1();
    }
    
    public static void naechsteEbene()
    {
        switch (ebene)
        {
            case 1:
                ebene = 2;
                new Ebene2();
                break;
            case 2:
                ebene = 3;
                new Ebene3();
                break;
            case 3:
                System.out.println("Gewonnen!");
                Greenfoot.stop();
                break;
        }
    }
}
