import java.util.Random;

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
    
    @Override
    public String knotenZuString()
    {
        String rechenzeichen = "";
         switch(typ)
        {
            case ADDITION:
                rechenzeichen = "+";
                break;
            case SUBTRAKTION:
                rechenzeichen = "-";
                break;
            case MULTIPLIKATION:
                rechenzeichen = "*";
                break;
            case DIVISION:
                rechenzeichen = "/";
                break;
        }
        return "(" + linkesKind.knotenZuString() + rechenzeichen + rechtesKind.knotenZuString() + ")";
    }
    
    public static KnotenOperation generiere(Random r, int tiefe, double operationsWahrscheinlichkeit) 
    {
        if (tiefe <= 0) 
        {
            operationsWahrscheinlichkeit = 0.0;
        }
        //TODO: Optimieren
        Knoten linkesKind;
        if (r.nextDouble() < operationsWahrscheinlichkeit)
        {
            linkesKind = KnotenOperation.generiere(r, tiefe-1, operationsWahrscheinlichkeit*0.5);
            operationsWahrscheinlichkeit *= 0.75;
        } else 
        {
            linkesKind = KnotenZahl.generiere(r, 2, 50);
        }
        
        Knoten rechtesKind;
        if (r.nextDouble() < operationsWahrscheinlichkeit)
        {
            rechtesKind = KnotenOperation.generiere(r, tiefe-1, operationsWahrscheinlichkeit*0.5);
            operationsWahrscheinlichkeit *= 0.75;
        } else 
        {
            rechtesKind = KnotenZahl.generiere(r, 2, 50);
        }
        
        EOperation operation = null;     
        switch (r.nextInt(4))
        {
            case 0:
                operation = EOperation.ADDITION;
                break;
            case 1:
                operation = EOperation.SUBTRAKTION;
                break;
            case 2:
                operation = EOperation.MULTIPLIKATION;
                break;
            case 3:
                operation = EOperation.DIVISION;
                break;
        }
        
        return new KnotenOperation(rechtesKind, linkesKind, operation);
    }
}
