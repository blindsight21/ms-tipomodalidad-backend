/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.tipomodalidad.service;

import java.math.BigDecimal;
import java.util.List;
import pe.gob.mimp.tipomodalidad.bean.FindByParamBean;
import pe.gob.mimp.tipomodalidad.bean.TipoModalidadBean;

/**
 *
 * @author Omar
 */
public interface TipoModalidadService {

    void crearTipoModalidad(TipoModalidadBean tipoModalidadBean) throws Exception;

    void editarTipoModalidad(TipoModalidadBean tipoModalidadBean) throws Exception;

//    void anularTipoModalidad(TipoModalidadBean tipoModalidadBean) throws Exception;
    String obtenerTipoModalidadPorId(BigDecimal nidTipoModalidad) throws Exception;

    List<TipoModalidadBean> loadTipoModalidadList(FindByParamBean findByParamBean) throws Exception;

    Integer getRecordCount(FindByParamBean findByParamBean) throws Exception;

    TipoModalidadBean find(BigDecimal id);

}
