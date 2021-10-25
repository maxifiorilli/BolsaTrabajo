/*
 * Va a ser un intermediario para conectarse a una DB
 *o a alguna fuente de donde venga la informacion de Localidad al managebean
 *para no tener todo en una misma clase y separar funcionalidad
 */
package beans.helper;

import beans.model.Localidad;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;

@RequestScoped
@Named

public class LocalidadHelper {

    public List<Localidad> getLocalidades() {
        List<Localidad> localidades = new ArrayList<>();

        int localidadId = 1;
        Localidad localidad = new Localidad(localidadId++, "Florida Oeste", 1604);
        localidades.add(localidad);

        localidad = new Localidad(localidadId++, "Florida", 1602);
        localidades.add(localidad);

        localidad = new Localidad(localidadId++, "Olivos", 1636);
        localidades.add(localidad);

        return localidades;
    }

    public int getLocalidadIdPorNombre(String nombreLocalidad) {
        int localidadId = 0;
        List<Localidad> localidades = this.getLocalidades();

        for (Localidad localidad : localidades) {
            if (localidad.getNombreLocalidad().equals(nombreLocalidad)) {
                localidadId = localidad.getLocalidadId();
                break;
            }
        }
        return localidadId;
    }

    public int getLocalidadIdPostal(int CodigoPostal) {
        int localidadId = 0;
        List<Localidad> localidades = this.getLocalidades();

        for (Localidad localidad : localidades) {
            if (localidad.getCodigoPostal() == (CodigoPostal)) {
                localidadId = localidad.getLocalidadId();
            }
        }
        return localidadId;
    }
    
    public List<SelectItem>getSelectItems(){
        List<SelectItem>selectItems=new ArrayList<>();
        List<Localidad>localidades=this.getLocalidades();
        for(Localidad localidad:localidades){
            SelectItem selectItem=new SelectItem(localidad.getLocalidadId(),
            localidad.getNombreLocalidad());
            selectItems.add(selectItem);
        }
        return selectItems;
    }

}
