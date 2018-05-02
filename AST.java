import java.util.Random;

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
        Random r = new Random();
        AST ast = new AST(KnotenOperation.generiere(r, 2, 0.6));
        System.out.println(ast.wurzel.knotenZuString() + " = " + ast.wurzel.auswerten());
        return ast;
    }
}
