import java.util.ArrayList;

public class ComandoDoWhile extends ComandoDeControle {
    
    private ArrayList<Comando> commandList;
    private Expressao logicalExpr;
    
    public ComandoDoWhile() {
        this.commandList = new ArrayList<Comando>();
    }

    public void setLogicalExpr(Expressao expr) {
        this.logicalExpr = expr;
        if (!this.logicalExpr.getIsLogical())
            throw new RuntimeException("Comando DO..WHILE requer condicao logica");
    }
    
    public void addCommand(Comando comando) {
        this.commandList.add(comando);
    }
    
    public String writeCode(int nivel) {
        StringBuilder str = new StringBuilder();
        
        for (int i=0; i<nivel; i++)
                str.append("\t");
                
        str.append("do {\n");
        
        for(Comando c: commandList) {
            str.append(c.writeCode(nivel+1));
        }
        
        for (int i=0; i<nivel; i++)
                str.append("\t");
                
        str.append("} while(")
            .append(this.logicalExpr.ImprimeExpressao())
        .append(");\n");
        
        return str.toString();
    }
    
}