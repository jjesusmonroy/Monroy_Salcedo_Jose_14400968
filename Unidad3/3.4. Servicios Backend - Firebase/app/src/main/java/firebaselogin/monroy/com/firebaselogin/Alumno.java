package firebaselogin.monroy.com.firebaselogin;

/**
 * Created by jjesusmonroy on 17/04/18.
 */

public class Alumno {
    String nombre,nocontrol;

    public Alumno(String nombre, String nocontrol) {
        this.nombre = nombre;
        this.nocontrol = nocontrol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNocontrol() {
        return nocontrol;
    }

    public void setNocontrol(String nocontrol) {
        this.nocontrol = nocontrol;
    }
}
