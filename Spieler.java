import greenfoot.*;
import java.util.List;

public class Spieler extends Actor
{
    private static final String PFAD_SPIELER = "images\\Mufflon.png";
    private static final GreenfootImage BILD_SPIELER = new GreenfootImage(PFAD_SPIELER);
    
    private int leben;
    private Lebensanzeige lebensanzeige = new Lebensanzeige();
    private Schluesselanzeige schluesselanzeige = new Schluesselanzeige();
    private boolean moved;
    private Ebene ebene;
    private int getoetet = 0;
    private boolean hatSchluessel = false;
    
    public Spieler()
    {
        setLeben(3);
        setImage(BILD_SPIELER);
    }

    public void act() 
    {
        move();
        if (moved) 
        {
            List<Gegner> gegner = getWorld().getObjects(Gegner.class);
            for (Gegner g : gegner) 
            {
                g.setMoving(true);
            }
            moved = false;
        }        
    }
    
    protected void addedToWorld(World world) 
    {
        world.addObject(lebensanzeige, 0, 0);
        world.addObject(schluesselanzeige, 9, 0);
    }

    public void setEbene(Ebene e)
    {
        ebene = e;
    }

    public void setLeben(int l)
    {
        leben = l;
        lebensanzeige.update(leben);
    }

    public int getLeben()
    {
        return leben;
    }

    public void move()
    {
        Richtung richtung = null;

        String key = Greenfoot.getKey();

        //Der Spieler hat keine Bewegungstaste gedrueckt
        if (key == null)
        {
            return;
        }

        switch (key)
        {
            case "w":
            richtung = Richtung.OBEN;
            break;
            case "a":
            richtung = Richtung.LINKS;
            break;
            case "s":
            richtung = Richtung.UNTEN;
            break;
            case "d":
            richtung = Richtung.RECHTS;
            break;
        }

        //Der Spieler hat keine Bewegungstaste gedrueckt
        if (richtung == null)
        {
            return;
        }

        int newX = getX() + richtung.dx;
        int newY = getY() + richtung.dy;

        //Pruefe auf Bewegung aus dem Raum
        if (newX > 9 || newY > 9 || newX < 0 || newY < 0) 
        {
            ebene.raumwechsel(this, richtung);
            return;
        }

        //Pruefe auf Hindernis
        Hindernis hindernis = (Hindernis) getOneObjectAtOffset(richtung.dx, richtung.dy, Hindernis.class);
        if (hindernis != null)
        {
            moved = true;
            if (hindernis.getClass() == Tuer.class && hatSchluessel)
            {
                ((Tuer) hindernis).oeffne();
            }
            return;
        }

        //Pruefe auf Gegner
        Gegner gegner = (Gegner) getOneObjectAtOffset(richtung.dx, richtung.dy, Gegner.class);
        if (gegner != null)
        {
            kampf(gegner);
            return;
        }

        moved = true;
        setLocation(newX, newY);
    }

    public void kampf(Gegner gegner)
    {
        Aufgabengenerator generator = new Aufgabengenerator();
        Aufgabe aufgabe = generator.generiereAufgabe();

        String antwort = Greenfoot.ask(aufgabe.aufgabenText());
        if (aufgabe.pruefeAntwort(antwort)) 
        {
            getoetet++;
            if (getoetet >= (int) (0.8 * ebene.anzahlGegner()))
            {
                schluesselanzeige.update(true);
                hatSchluessel = true;
            }
            gegner.niederlage();
        } else 
        {
            setLeben(getLeben() - 1);
            if (leben <= 0)
            {
                System.out.println("Verloren!");
                Greenfoot.stop();
            }
        }
    }
}
