package gestion_datos;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalculoPuntajeTest {

    @Test
    public void calcularPorcentajeAcertadasTest() {
        int[] respuestasUsuario = {4, 5, 1, 2, 6, 3, 6, 2, 1, 3, 5, 4, 2, 6, 1, 2, 1, 3, 5, 6, 4, 3, 4, 5, 8, 2, 3, 8, 7, 4, 5, 1, 7, 6, 1, 2, 3, 4, 3, 7, 8, 6, 5, 4, 1, 2, 5, 6, 7, 6, 8, 2, 1, 5, 2, 4, 1, 6, 3, 5};
        CalculoPuntaje cal = new CalculoPuntaje(respuestasUsuario);
        float valorEsperado = 100;
        float valorObtenido = cal.calcularPorcentajeCorrectas();
        assertEquals(valorEsperado, valorObtenido, 0.001);
        
    }

}
