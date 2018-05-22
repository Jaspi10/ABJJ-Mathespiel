import java.util.Random;
import java.lang.NumberFormatException;

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

    public boolean pruefeAntwort(String antwortText)
    {
        double antwort;
        try {
            antwort = Double.parseDouble(antwortText);
        } catch (NumberFormatException e) {
            return false;
        }
            
        
        return wurzel.auswerten() == antwort;
    }
}
