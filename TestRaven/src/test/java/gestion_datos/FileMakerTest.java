package gestion_datos;

import org.junit.Test;
import static org.junit.Assert.*;

public class FileMakerTest {

    @Test
    public void crearArchivoTest() {
        assertTrue(FileMaker.almacenarDatosUsuario("nombre", "Nombre Usuario"));
    }
    

}
