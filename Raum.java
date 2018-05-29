import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.*;

public class Raum extends World
{
    boolean tuerOben;
    boolean tuerUnten;
    boolean tuerLinks;
    boolean tuerRechts;
    
    public Raum()
    {
        super(10, 10, 50);
        
        setPaintOrder(Lebensanzeige.class, Schluesselanzeige.class);

        for (int i = 0; i < 10; i++)
        {
            addObject(new Wand(), i, 0);
        }

        for (int i = 0; i < 10; i++)
        {
            addObject(new Wand(), i, 9);
        }

        for (int i = 0; i < 10; i++)
        {
            addObject(new Wand(), 0, i);
        }

        for (int i = 0; i < 10; i++)
        {
            addObject(new Wand(), 9, i);
        }
    }

    public void addTuerOben() 
    {
        removeObject((Actor) getObjectsAt(4, 0, null).get(0));
        removeObject((Actor) getObjectsAt(5, 0, null).get(0));
        tuerOben = true;
    }
    
    public void addTuerUnten() 
    {
        removeObject((Actor) getObjectsAt(4, 9, null).get(0));
        removeObject((Actor) getObjectsAt(5, 9, null).get(0));
        tuerUnten = true;
    }
    
    public void addTuerLinks() 
    {
        removeObject((Actor) getObjectsAt(0, 4, null).get(0));
        removeObject((Actor) getObjectsAt(0, 5, null).get(0));
        tuerLinks = true;
    }
    
    public void addTuerRechts() 
    {
        removeObject((Actor) getObjectsAt(9, 4, null).get(0));
        removeObject((Actor) getObjectsAt(9, 5, null).get(0));
        tuerRechts = true;
    }
    
    public void addTueren(RaumInfo info)
    {
        if (info.tuerOben) addTuerOben();
        if (info.tuerUnten) addTuerUnten();
        if (info.tuerLinks) addTuerLinks();
        if (info.tuerRechts) addTuerRechts();
    }
    
    public int anzahlGegner()
    {
        return getObjects(Gegner.class).size();
    }

    //Random
    public Raum addSpieler(Spieler spieler)
    {
        while (true) 
        {
            int x = Greenfoot.getRandomNumber(8);
            int y = Greenfoot.getRandomNumber(8);

            if (getObjectsAt(x, y, null).isEmpty())
            {
                addObject(spieler, x, y);
                break;
            }
        }
        return this;
    }

    public Raum addGegner(Gegner gegner, int x, int y)
    {
        addObject(gegner, x, y);
        return this;
    }

    public Raum addGegner(String name, int x, int y)
    {
        Gegner gegner = null;
        switch (name)
        {
            case "Gegner":
                gegner = new Gegner();
                break;
            case "GegnerX":
                gegner = new GegnerX();
                break;
            case "GegnerY":
                gegner = new GegnerY();
                break;
        }
        addObject(gegner, x, y);
        return this;
    }

    public Raum addBossTuer()
    {
        addObject(new Tuer(false), 4, 0);
        addObject(new Tuer(true), 5, 0);
        return this;
    }
    
    public void rotiere() 
    {
        for (Object o : getObjects(null))
        {
            Actor a = (Actor) o;
            
            int x = 9 - a.getY();
            int y = a.getX();
            
            removeObject(a);
            
            if (a instanceof GegnerX)
            {
                addObject(new GegnerY(), x, y);
            } else if (a instanceof GegnerY)
            {
                addObject(new GegnerX(), x, y);
            } else
            {
                addObject(a, x, y);
            }
        }
        
        boolean tmp = tuerLinks;
        tuerLinks = tuerUnten;
        tuerUnten = tuerRechts;
        tuerRechts = tuerOben;
        tuerOben = tmp;
    }

    public void speichern(String name, boolean istBoss, boolean istStart) {
        try 
        {
            BufferedWriter w = new BufferedWriter(new FileWriter(new File(RaumPool.RAEUME_PFAD + "\\" + name))); //Not cross Platform uses Windows Filepath conventions
            
            RaumInfo info = new RaumInfo(name);
            info.tuerOben = tuerOben;
            info.tuerUnten = tuerUnten;
            info.tuerLinks = tuerLinks;
            info.tuerRechts = tuerRechts;
            info.istBoss = istBoss;
            info.istStart = istStart;
            
            info.speichern(w);
            
            for (Object o : getObjects(null)) 
            {
                Actor a = (Actor) o;
                if (a instanceof Hindernis && !(a instanceof Wand))
                {
                    w.write("Hindernis " + a.getX() + " " + a.getY() + "\n");
                    continue;
                }

                if (a instanceof Gegner && !(a instanceof Boss))
                {
                    w.write("Gegner " + a.getX() + " " + a.getY() + " " + a.getClass().getName() + "\n");
                    continue;
                }
            }

            w.flush();
            w.close();
        } catch (IOException e)
        {

        }
    }

    public static Raum laden(RaumInfo info, RaumInfo requirements)
    {
        Raum rv = new Raum();

        try 
        {
            BufferedReader r = new BufferedReader(new FileReader(new File(RaumPool.RAEUME_PFAD + "\\" + info.name)));
            r.lines().forEach(line -> {
                    String[] words = line.split(" ");
                    int x = 0;
                    int y = 0;
                    switch(words[0])
                    {
                        case "Hindernis":
                            x = Integer.parseInt(words[1]);
                            y = Integer.parseInt(words[2]);
                            rv.addObject(new Hindernis(), x, y);
                            break;
                        case "Gegner":
                            x = Integer.parseInt(words[1]);
                            y = Integer.parseInt(words[2]);
                            rv.addGegner(words[3], x, y);
                            break;
                    }
                });
        } catch (IOException e)
        {
        }
        
        rv.addTueren(info);
        while (!((requirements.tuerOben == rv.tuerOben) && (requirements.tuerUnten == rv.tuerUnten) && (requirements.tuerLinks == rv.tuerLinks) && (requirements.tuerRechts == rv.tuerRechts)))
        {
            rv.rotiere();
        }

        Greenfoot.setWorld(rv);

        return rv;
    }
    
    public static Raum laden(String name)
    {
        RaumInfo info = RaumInfo.lade(new File(RaumPool.RAEUME_PFAD + "\\" + name));
        
        return Raum.laden(info, info);
    }
}
