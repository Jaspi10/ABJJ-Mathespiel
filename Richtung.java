
//Richtungen fuer Bewegung und Raumwechsel
public enum Richtung 
{
    OBEN(0, -1),
    UNTEN(0, 1),
    LINKS(-1, 0),
    RECHTS(1, 0);
    
    //Horizontale Bewegung
    public final int dx;
    //Vertikale Bewegung
    public final int dy;
    
    Richtung (int dx, int dy) 
    {
        this.dx = dx;
        this.dy = dy;
    }
}
