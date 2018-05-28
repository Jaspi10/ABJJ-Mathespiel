import java.io.*;

public class RaumInfo  
{
    boolean tuerOben;
    boolean tuerUnten;
    boolean tuerLinks;
    boolean tuerRechts;
    
    boolean istBoss;
    boolean istStart;
    
    String name;
    
    public RaumInfo(String name) 
    {
        this.name = name;
    }
    
    public RaumInfo() {}
    
    public RaumInfo requireTuerOben()
    {
        this.tuerOben = true;
        return this;
    }
    
    public RaumInfo requireTuerUnten()
    {
        this.tuerUnten = true;
        return this;
    }
    
    public RaumInfo requireTuerLinks()
    {
        this.tuerLinks = true;
        return this;
    }
    
    public RaumInfo requireTuerRechts()
    {
        this.tuerRechts = true;
        return this;
    }
    
    public RaumInfo requireIstBoss() 
    {
        this.istBoss = true;
        return this;
    }
    
    public RaumInfo requireIstStart() 
    {
        this.istStart = true;
        return this;
    }
    
    public void speichern(BufferedWriter w) throws IOException
    {        
        if (tuerOben)
        {
            w.write("Info tuerOben\n");
        }
        
        if (tuerUnten)
        {
            w.write("Info tuerUnten\n");
        }
        
        if (tuerLinks)
        {
            w.write("Info tuerLinks\n");
        }
        
        if (tuerRechts)
        {
            w.write("Info tuerRechts\n");
        }
        
        if (istBoss)
        {
            w.write("Info boss\n");
        }
        
        if (istStart)
        {
            w.write("Info start\n");
        }
    }
    
    public static RaumInfo lade(File f)
    {
        RaumInfo rv = new RaumInfo(f.getName());
        
        try 
        {
            BufferedReader r = new BufferedReader(new FileReader(f));
            
            r.lines().forEach(line -> {
                String[] words = line.split(" ");
                if ("Info".equals(words[0])) 
                {
                    switch (words[1])
                    {
                        case "tuerOben":
                            rv.tuerOben = true;
                            break;
                        case "tuerUnten":
                            rv.tuerUnten = true;
                            break;
                        case "tuerLinks":
                            rv.tuerLinks = true;
                            break;
                        case "tuerRechts":
                            rv.tuerRechts = true;
                            break;
                        case "start":
                            rv.istStart = true;
                            break;
                        case "boss":
                            rv.tuerOben = true;
                            break;
                    
                    }
                }
            });
        } catch (IOException e)
        {
        }
        return rv;
    }
    
    public int anzahlTueren() 
    {
        int rv = 0;
        
        if (tuerOben) rv++;
        if (tuerUnten) rv++;
        if (tuerLinks) rv++;
        if (tuerRechts) rv++;
        
        return rv;
    }
    
    public boolean istKompatibel(RaumInfo requirements)
    {
        if (requirements.istStart != istStart || requirements.istBoss != istBoss)
        {
            return false;
        }
        
        int requiredTueren = requirements.anzahlTueren();
        int tueren = anzahlTueren();
        
        if (requiredTueren != tueren)
        {
            return false;
        }
        
        if (tueren != 2) 
        {
            return true;
        } else
        {
            if ((tuerOben && tuerUnten) || (tuerLinks && tuerRechts)) 
            {
                return (requirements.tuerOben && requirements.tuerUnten) || (requirements.tuerLinks && requirements.tuerRechts);
            } else 
            {
                return !((requirements.tuerOben && requirements.tuerUnten) || (requirements.tuerLinks && requirements.tuerRechts));
            }
        }
    }
}
