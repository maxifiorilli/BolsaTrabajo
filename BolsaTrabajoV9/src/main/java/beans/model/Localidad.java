package beans.model;

public class Localidad {
    
    private int localidadId;
    private String nombreLocalidad;
    private int codigoPostal;

    public Localidad() {
    }

    public Localidad(int localidadId, String nombreLocalidad, int codigoPostal) {
        this.localidadId = localidadId;
        this.nombreLocalidad = nombreLocalidad;
        this.codigoPostal = codigoPostal;
    }

    public int getLocalidadId() {
        return localidadId;
    }

    public void setLocalidadId(int localidadId) {
        this.localidadId = localidadId;
    }

    public String getNombreLocalidad() {
        return nombreLocalidad;
    }

    public void setNombreLocalidad(String nombreLocalidad) {
        this.nombreLocalidad = nombreLocalidad;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

  
}
