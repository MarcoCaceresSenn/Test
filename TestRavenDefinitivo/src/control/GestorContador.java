package control;

public class GestorContador {
    
    private static final GestorContador instance = new GestorContador();
    private int contador = 1;
    
    private GestorContador(){
    }
    
    public static GestorContador getInstance(){
        return instance;
    }
    
    public int getContador(){
        return this.contador;
    }
    
    public void setContador(int contador){
        this.contador = contador;
    }
    
}
