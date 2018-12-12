package control;

import org.junit.Test;
import static org.junit.Assert.*;

public class GestorContadorTest {

    @Test
    public void sumarContadorTest() {
        int contadorActual = GestorContador.getInstance().getContador();
        contadorActual++;
        GestorContador.getInstance().setContador(contadorActual);
        int valorObtenido = GestorContador.getInstance().getContador();
        int valorEsperado = 2;
        assertEquals(valorEsperado, valorObtenido);
    }

}
