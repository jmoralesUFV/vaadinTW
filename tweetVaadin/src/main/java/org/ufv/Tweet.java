package org.ufv;

import org.ocpsoft.prettytime.PrettyTime;

import java.time.LocalDateTime;
import java.util.Date;

public class Tweet {

    private String nombre_usuario;
    private String mensaje;
    private String tamaño;
    private Date fecha;

    public Tweet() {
    }

    public Tweet(String nombre_usuario, String mensaje, String tamaño, Date fecha) {
        this.nombre_usuario = nombre_usuario;
        this.mensaje = mensaje;
        this.tamaño = tamaño;
        this.fecha = fecha;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getTamaño() {
        return tamaño;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getFechaFormateada(Date fecha)
    {
        PrettyTime p = new PrettyTime();
        String fechaF = (p.format(new Date()));
        return fechaF;
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "nombre_usuario='" + nombre_usuario + '\'' +
                ", mensaje='" + mensaje + '\'' +
                ", tamaño='" + tamaño + '\'' +
                ", fecha=" + fecha +
                '}';
    }
}
