package beans.backing;

import beans.helper.LocalidadHelper;
import beans.model.Candidato;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIInput;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Named
@RequestScoped
public class VacanteForm extends Object {

    @Inject
    private Candidato candidato;

    private boolean comentarioEnviado;
    @Inject
    private LocalidadHelper localidadHelper;

    Logger log = LogManager.getRootLogger();

    public VacanteForm() {
        log.info("Creando el objeto VacanteForm");
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    public String enviar() {
        if (this.candidato.getNombre().equals("Juan")) {
            if (this.candidato.getApellido().equals("Perez")) {
                String msg = "Gracias, pero Juan Perez ya trabaja con nosotros";
                FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
                FacesContext facesContext = FacesContext.getCurrentInstance();
                String componentId = null;//este es un mensaje de tipo global
                facesContext.addMessage(componentId, facesMessage);
                return "index";
            }
            log.info("Entrando al caso de exito");
            return "exito";
        } else {
            log.info("Entrando al caso de fallo");
            return "fallo";
        }
    }

    public void codigoPostalListener(ValueChangeEvent valueChangeEvent) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        UIViewRoot uiViewRoot = facesContext.getViewRoot();
        int nuevoCodigoPostal = ((Long) valueChangeEvent.getNewValue()).intValue();
        //El getNewValue() devuelve un tipo Long, entonces para asegurar que no haya un 
        //error de conversion de dato, primero lo casteamos a Long y luego al dato lo pasamos
        //a int.

        UIInput localidadIdInputText = (UIInput) uiViewRoot.findComponent("vacanteForm:localidadId");
        int localidadId = this.localidadHelper.getLocalidadIdPostal(nuevoCodigoPostal);
        localidadIdInputText.setValue(localidadId);
        localidadIdInputText.setSubmittedValue(localidadId);

        UIInput ciudadInputText = (UIInput) uiViewRoot.findComponent("vacanteForm:ciudad");
        String nuevaCiudad = "Vicente Lopez";
        ciudadInputText.setValue(nuevaCiudad);
        ciudadInputText.setSubmittedValue(nuevaCiudad);

        facesContext.renderResponse();
    }

public void ocultarComentario(ActionEvent actionEvent){
        this.comentarioEnviado= !this.comentarioEnviado;
    }
    
    public boolean isComentarioEnviado() {
        return comentarioEnviado;
    }

    public void setComentarioEnviado(boolean comentarioEnviado) {
        this.comentarioEnviado = comentarioEnviado;
    }

    public LocalidadHelper getLocalidadHelper() {
        return localidadHelper;
    }

    public void setLocalidadHelper(LocalidadHelper localidadHelper) {
        this.localidadHelper = localidadHelper;
    }
    
}
