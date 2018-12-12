package gestion_datos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileMaker {

    public static String leerDatosUsuario(String nombreArchivo) {
        String dato = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File("resources//DatosUsuario//" + nombreArchivo + ".txt")));
            dato = br.readLine();
            br.close();
            borrarDatosUsuario(nombreArchivo);
        } catch (IOException e) {
        }
        return dato;
    }

    public static boolean almacenarDatosUsuario(String nombreArchivo, String datoUsuario) {
        try {
            FileWriter fl = new FileWriter("resources//DatosUsuario//" + nombreArchivo + ".txt");
            BufferedWriter bf = new BufferedWriter(fl);
            bf.write(datoUsuario);
            bf.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }
    
    private static void borrarDatosUsuario(String nombreArchivo){
        File file = new File("resources//DatosUsuario//" + nombreArchivo + ".txt");
        file.delete();
    }
}
