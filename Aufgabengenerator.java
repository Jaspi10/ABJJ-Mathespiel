import java.util.Random;

public class Aufgabengenerator
{
    Random r = new Random();
    
    public AST generiereAufgabe() 
    {
       int zahl = r.nextInt(3);
       if (zahl == 0)
       {
           // a*(b+c)
           double bPlusC = r.nextInt(16) + 3; //Min: 3, Max: 18
           double b = r.nextInt(19 - (int) bPlusC) + 2;
           double a = r.nextInt(18) + 3;
           Knoten plus = new KnotenOperation(new KnotenZahl(bPlusC - b), new KnotenZahl(b), EOperation.ADDITION);
           Knoten mal = new KnotenOperation(new KnotenZahl(a), plus, EOperation.MULTIPLIKATION);
           return new AST(mal);
       } else if (zahl == 1) 
       {
           // a/b 
           //b teilt a
           double b = r.nextInt(10);
           double quotient = r.nextInt(10);
           Knoten division = new KnotenOperation(new KnotenZahl(b), new KnotenZahl(b*quotient), EOperation.DIVISION);
           return new AST(division);
       } else 
       {
           //(a*a)+(b*b)
           double a = r.nextInt(19) + 2;
           double b = r.nextInt(19) + 2;
           Knoten aQuadrat = new KnotenOperation(new KnotenZahl(a), new KnotenZahl(a), EOperation.MULTIPLIKATION);
           Knoten bQuadrat = new KnotenOperation(new KnotenZahl(b), new KnotenZahl(b), EOperation.MULTIPLIKATION);
           Knoten cQuadrat = new KnotenOperation(aQuadrat, bQuadrat, EOperation.ADDITION);
           return new AST(cQuadrat);
       }
    }
}