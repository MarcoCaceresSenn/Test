package gestion_datos;

public class CalculoPuntaje {

    private int[] respuestasUsuario;
    private int[] respuestasCorrectas = {4, 5, 1, 2, 6, 3, 6, 2,1, 3, 5, 4, 2, 6, 1, 2, 1, 3, 5, 6, 4, 3, 4, 5, 8, 2, 3, 8, 7, 4, 5, 1, 7, 6, 1, 2, 3, 4, 3, 7, 8, 6, 5, 4, 1, 2, 5, 6, 7, 6, 8, 2, 1, 5, 2, 4, 1, 6, 3, 5};

    public CalculoPuntaje(int[] respuestasUsuario) {
        this.respuestasUsuario = respuestasUsuario;
    }
    
    private int calcularCorrectas(){
        int cantRespuestasCorrectas = 0;
        for (int i = 0; i < this.respuestasCorrectas.length; i++) {
            if (this.respuestasCorrectas[i] == this.respuestasUsuario[i]){
                cantRespuestasCorrectas++;
            }
        }
        return cantRespuestasCorrectas;
    }
    
    public float calcularPorcentajeCorrectas(){
        float porcentaje = calcularCorrectas();
        porcentaje = porcentaje / this.respuestasCorrectas.length;
        porcentaje = porcentaje * 100;
        return porcentaje;
    }
    
}
