import greenfoot.*;
import java.util.List;

public class Spieler extends Actor
{   
    private int leben;
    private boolean moved;
    private Ebene1 ebene;
    public Spieler()
    {
        leben = 3;
        getImage().scale(50, 50);
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
    public void setEbene(Ebene1 e)
    {
        ebene = e;
    }
    public void setLeben(int l)
    {
        leben = l;
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
        if (getOneObjectAtOffset(richtung.dx, richtung.dy, Hindernis.class) != null)
        {
            moved = true;
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
            gegner.sterbe();
        } else 
        {
            //Konsequenz fuer falsche antwort
        }
        
            
    }
}
