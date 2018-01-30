
package com.gestor.bots.admin.console.web;


import com.gestor.bots.admin.console.model.EntrenamientoRegla;
import com.gestor.bots.admin.console.servicio.EntrenamientoReglaService;
import com.gestor.bots.admin.console.web.common.BaseBean;
import com.gestor.bots.admin.console.web.common.FacesUtil;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.commons.beanutils.BeanUtils;

/**
 *
 * @author Hendrix
 */
@Named
@ViewScoped
public class EntrenamientoReglaBean extends BaseBean implements Serializable {

    private static final String ENTIDAD = "Entrenamiento Regla";
    
    @Inject
    private EntrenamientoReglaService entrenamientoReglaService;

    private List<EntrenamientoRegla> entrenamientoReglaList;

    private EntrenamientoRegla entrenamientoRegla;
    private EntrenamientoRegla entrenamientoReglaSel;
    
    @PostConstruct
    public void init() {
        this.entrenamientoReglaList = this.entrenamientoReglaService.obtenerTodos();
    }

    @Override
    public void nuevo() {
        super.nuevo();
        this.entrenamientoRegla = new EntrenamientoRegla();
    }

    @Override
    public void modificar() {
        super.modificar();
        this.entrenamientoRegla = new EntrenamientoRegla();
        try {
            BeanUtils.copyProperties(this.entrenamientoRegla, this.entrenamientoReglaSel);
        } catch (Exception ex) {
            FacesUtil.addMessageError(null, "No se puede modificar  "+ENTIDAD);
        }
    }

    @Override
    public void consultar() {
        super.consultar();
        this.entrenamientoRegla = this.entrenamientoReglaSel;
    }

    public void guardar() {
        if (super.isEnModificar()) {
            try {
                this.entrenamientoReglaService.modificar(entrenamientoRegla);
                FacesUtil.addMessageInfo("Se modifico el Entrenamiento: " + this.entrenamientoRegla.getPk().getSecuenciaEntrenamiento());
                super.cancelar();
            } catch (Exception e) {
                FacesUtil.addMessageError(null, "Ocurrio un error al modificar la entrenamientoRegla: "+this.entrenamientoRegla);
            }
        } else {
            try {
                this.entrenamientoReglaService.crear(entrenamientoRegla);
                FacesUtil.addMessageInfo("Se creo el entrenamiento : " + this.entrenamientoRegla.getPk().getSecuenciaEntrenamiento());
                super.cancelar();
            } catch (Exception e) {
                FacesUtil.addMessageError(null, "No se pudo crear el entrenamiento : "+this.entrenamientoRegla);
            }
        }
        
    }

    public List<EntrenamientoRegla> getEntrenamientoReglaList() {
        return entrenamientoReglaList;
    }

    public EntrenamientoRegla getEntrenamientoRegla() {
        return entrenamientoRegla;
    }

    public void setEntrenamientoRegla(EntrenamientoRegla entrenamientoRegla) {
        this.entrenamientoRegla = entrenamientoRegla;
    }

    public EntrenamientoRegla getEntrenamientoReglaSel() {
        return entrenamientoReglaSel;
    }

    public void setEntrenamientoReglaSel(EntrenamientoRegla entrenamientoReglaSel) {
        this.entrenamientoReglaSel = entrenamientoReglaSel;
    }
    
    public String getTituloPanel() {
        return super.tituloPanel+ EntrenamientoReglaBean.ENTIDAD;
    }

}
