
package com.gestor.bots.admin.console.web;


import com.gestor.bots.admin.console.model.Sinonimo;
import com.gestor.bots.admin.console.servicio.SinonimoService;
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
public class SinonimoBean extends BaseBean implements Serializable {

    private static final String ENTIDAD = "Sinonimo";
    
    @Inject
    private SinonimoService sinonimoService;

    private List<Sinonimo> sinonimoList;

    private Sinonimo sinonimo;
    private Sinonimo sinonimoSel;
    
    @PostConstruct
    public void init() {
        this.sinonimoList = this.sinonimoService.obtenerTodos();
    }

    @Override
    public void nuevo() {
        super.nuevo();
        this.sinonimo = new Sinonimo();
    }

    @Override
    public void modificar() {
        super.modificar();
        this.sinonimo = new Sinonimo();
        try {
            BeanUtils.copyProperties(this.sinonimo, this.sinonimoSel);
        } catch (Exception ex) {
            FacesUtil.addMessageError(null, "No se puede modificar la "+ENTIDAD);
        }
    }

    @Override
    public void consultar() {
        super.consultar();
        this.sinonimo = this.sinonimoSel;
    }

    public void guardar() {
        if (super.isEnModificar()) {
            try {
                this.sinonimoService.modificar(sinonimo);
                FacesUtil.addMessageInfo("Se modifico el sinonimo: " + this.sinonimo.getSecuencia());
                super.cancelar();
            } catch (Exception e) {
                FacesUtil.addMessageError(null, "Ocurrio un error al modificar el sinonimo: "+this.sinonimo);
            }
        } else {
            try {
                this.sinonimoService.crear(sinonimo);
                FacesUtil.addMessageInfo("Se creo el sinonimo: " + this.sinonimo.getSecuencia());
                super.cancelar();
            } catch (Exception e) {
                FacesUtil.addMessageError(null, "No se pudo crear el sinonimo: "+this.sinonimo);
            }
        }
        
    }

    public List<Sinonimo> getSinonimoList() {
        return sinonimoList;
    }

    public Sinonimo getSinonimo() {
        return sinonimo;
    }

    public void setSinonimo(Sinonimo sinonimo) {
        this.sinonimo = sinonimo;
    }

    public Sinonimo getSinonimoSel() {
        return sinonimoSel;
    }

    public void setSinonimoSel(Sinonimo sinonimoSel) {
        this.sinonimoSel = sinonimoSel;
    }
    
    public String getTituloPanel() {
        return super.tituloPanel+SinonimoBean.ENTIDAD;
    }

}
