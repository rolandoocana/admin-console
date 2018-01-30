
package com.gestor.bots.admin.console.web;

import com.gestor.bots.admin.console.model.Regla;
import com.gestor.bots.admin.console.servicio.ReglaService;
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
public class ReglaBean extends BaseBean implements Serializable {

    private static final String ENTIDAD = "Regla";
    
    @Inject
    private ReglaService reglaService;

    private List<Regla> reglaList;

    private Regla regla;
    private Regla reglaSel;
    
    @PostConstruct
    public void init() {
        this.reglaList = this.reglaService.obtenerTodos();
    }

    @Override
    public void nuevo() {
        super.nuevo();
        this.regla = new Regla();
    }

    @Override
    public void modificar() {
        super.modificar();
        this.regla = new Regla();
        try {
            BeanUtils.copyProperties(this.regla, this.reglaSel);
        } catch (Exception ex) {
            FacesUtil.addMessageError(null, "No se puede modificar la "+ENTIDAD);
        }
    }

    @Override
    public void consultar() {
        super.consultar();
        this.regla = this.reglaSel;
    }

    public void guardar() {
        if (super.isEnModificar()) {
            try {
                this.reglaService.modificar(regla);
                FacesUtil.addMessageInfo("Se modifico la regla: " + this.regla.getNombre());
                super.cancelar();
            } catch (Exception e) {
                FacesUtil.addMessageError(null, "Ocurrio un error al modificar la regla: "+this.regla);
            }
        } else {
            try {
                this.reglaService.crear(regla);
                FacesUtil.addMessageInfo("Se creo la regla: " + this.regla.getNombre());
                super.cancelar();
            } catch (Exception e) {
                FacesUtil.addMessageError(null, "No se pudo crear la regla: "+this.regla);
            }
        }
        
    }

    public List<Regla> getReglaList() {
        return reglaList;
    }

    public Regla getRegla() {
        return regla;
    }

    public void setRegla(Regla regla) {
        this.regla = regla;
    }

    public Regla getReglaSel() {
        return reglaSel;
    }

    public void setReglaSel(Regla reglaSel) {
        this.reglaSel = reglaSel;
    }
    
    public String getTituloPanel() {
        return super.tituloPanel+ReglaBean.ENTIDAD;
    }

}
