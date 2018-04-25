//Rechenoperation mit zwei Eingaben und einem Ergebnis
public class KnotenOperation extends Knoten 
{
    Knoten linkesKind;
    Knoten rechtesKind;
    
    EOperation typ;
    
    public KnotenOperation (Knoten rechtesKind, Knoten linkesKind, EOperation typ) 
    {
        this.linkesKind = linkesKind;
        this.rechtesKind = rechtesKind;
        this.typ = typ;
    }
    
    public double auswerten()
    {
        switch(typ)
        {
            case ADDITION:
                return linkesKind.auswerten() + rechtesKind.auswerten();
            case SUBTRAKTION:
                return linkesKind.auswerten() - rechtesKind.auswerten();
            case MULTIPLIKATION:
                return linkesKind.auswerten() * rechtesKind.auswerten();
            case DIVISION:
                return linkesKind.auswerten() / rechtesKind.auswerten();
        }
        
        //Eigentlich nicht erreichbar
        return 0;
    }
}
