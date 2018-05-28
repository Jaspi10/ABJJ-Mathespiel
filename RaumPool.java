import greenfoot.*;
import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class RaumPool  
{
    public static final String RAEUME_PFAD = "raeume";
    
    private List<RaumInfo> raeume = new ArrayList();
    
    public RaumPool() 
    {
         for (File f : new File(RAEUME_PFAD).listFiles())
         {
             raeume.add(RaumInfo.lade(f));
         }
    }
    
    public Raum getRaum(RaumInfo requirements)
    {
        List<RaumInfo> kompatibleRaeume = new ArrayList();
        for (RaumInfo info : raeume)
        {
            if (info.istKompatibel(requirements)) {
                kompatibleRaeume.add(info);
            }
        }
        
        return Raum.laden(kompatibleRaeume.get(Greenfoot.getRandomNumber(kompatibleRaeume.size())), requirements);
    }
}
