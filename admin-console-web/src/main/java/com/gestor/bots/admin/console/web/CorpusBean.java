
package com.gestor.bots.admin.console.web;


import com.gestor.bots.admin.console.model.Corpus;
import com.gestor.bots.admin.console.servicio.CorpusService;
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
public class CorpusBean extends BaseBean implements Serializable {

    private static final String ENTIDAD = "Corpus";
    
    @Inject
    private CorpusService corpusService;

    private List<Corpus> corpusList;

    private Corpus corpus;
    private Corpus corpusSel;
    
    @PostConstruct
    public void init() {
        this.corpusList = this.corpusService.obtenerTodos();
    }

    @Override
    public void nuevo() {
        super.nuevo();
        this.corpus = new Corpus();
    }

    @Override
    public void modificar() {
        super.modificar();
        this.corpus = new Corpus();
        try {
            BeanUtils.copyProperties(this.corpus, this.corpusSel);
        } catch (Exception ex) {
            FacesUtil.addMessageError(null, "No se puede modificar el "+ENTIDAD);
        }
    }

    @Override
    public void consultar() {
        super.consultar();
        this.corpus = this.corpusSel;
    }

    public void guardar() {
        if (super.isEnModificar()) {
            try {
                this.corpusService.modificar(corpus);
                FacesUtil.addMessageInfo("Se modifico el corpus: " + this.corpus.getId());
                super.cancelar();
            } catch (Exception e) {
                FacesUtil.addMessageError(null, "Ocurrio un error al modificar el corpus: "+this.corpus);
            }
        } else {
            try {
                this.corpusService.crear(corpus);
                FacesUtil.addMessageInfo("Se creo la corpus: " + this.corpus.getId());
                super.cancelar();
            } catch (Exception e) {
                FacesUtil.addMessageError(null, "No se pudo crear la corpus: "+this.corpus);
            }
        }
        
    }

    public List<Corpus> getCorpusList() {
        return corpusList;
    }

    public Corpus getCorpus() {
        return corpus;
    }

    public void setCorpus(Corpus corpus) {
        this.corpus = corpus;
    }

    public Corpus getCorpusSel() {
        return corpusSel;
    }

    public void setCorpusSel(Corpus corpusSel) {
        this.corpusSel = corpusSel;
    }
    
    public String getTituloPanel() {
        return super.tituloPanel+CorpusBean.ENTIDAD;
    }

}
