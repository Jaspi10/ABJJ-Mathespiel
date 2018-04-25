//Stellt eine arithmetische Aufgabe dar
public class AST  
{
    
    Knoten wurzel;
    
    public AST(Knoten wurzel)
    {
        this.wurzel = wurzel;
    }
    
    //TODO: Zufall
    public static AST generiereAST() 
    {
        KnotenZahl sieben = new KnotenZahl(7.0);
        KnotenZahl fuenf = new KnotenZahl(5.0);
        
        KnotenOperation plus = new KnotenOperation(fuenf, sieben, EOperation.ADDITION);
        
        KnotenZahl zehn = new KnotenZahl(10.0);
        
        KnotenOperation mal = new KnotenOperation(zehn, plus, EOperation.MULTIPLIKATION);
        
        KnotenZahl zwanzig = new KnotenZahl(20.0);
        
        KnotenOperation plus2 = new KnotenOperation(zwanzig, mal, EOperation.ADDITION);
        
        System.out.println(plus2.auswerten());
        
        return new AST(plus2);
    }
}
