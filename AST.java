import java.util.Random;

//Stellt eine arithmetische Aufgabe dar
public class AST implements Aufgabe 
{
    
    Knoten wurzel;
    
    public AST(Knoten wurzel)
    {
        this.wurzel = wurzel;
    }
    
    public static AST generiereAST() 
    {
        Aufgabengenerator g = new Aufgabengenerator();
        AST ast = g.generiereAufgabe();
        System.out.println(ast.wurzel.knotenZuString() + " = " + ast.wurzel.auswerten());
        return ast;
    }

    public String aufgabenText()
    {
        return wurzel.knotenZuString();
    }

    public boolean pruefeLoesung(double loesung)
    {
        return wurzel.auswerten() == loesung;
    }
}
