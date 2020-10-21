/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.tipomodalidad.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.mimp.siscap.model.TipoModalidad;
import pe.gob.mimp.siscap.repository.tipomodalidad.TipoModalidadRepository;
import pe.gob.mimp.tipomodalidad.bean.FindByParamBean;
import pe.gob.mimp.tipomodalidad.bean.TipoModalidadBean;
import pe.gob.mimp.tipomodalidad.converter.TipoModalidadCast;
import pe.gob.mimp.tipomodalidad.util.Util;
import pe.gob.mimp.tipomodalidad.service.TipoModalidadService;

/**
 *
 * @author Omar
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class TipoModalidadServiceImpl implements TipoModalidadService {

    @Autowired
    private TipoModalidadRepository tipoModalidadRepository;

    @Override
    public void crearTipoModalidad(TipoModalidadBean tipoModalidadBean) throws Exception {

        TipoModalidad tipoModalidad = new TipoModalidad();
        tipoModalidad.setTxtTipoModalidad(tipoModalidadBean.getTxtTipoModalidad());
        tipoModalidad.setNidUsuario(tipoModalidadBean.getNidUsuario());
        tipoModalidad.setTxtPc(tipoModalidadBean.getTxtPc());
        tipoModalidad.setTxtIp(tipoModalidadBean.getTxtIp());
        tipoModalidad.setFecEdicion(tipoModalidadBean.getFecEdicion());
        tipoModalidad.setFlgActivo(tipoModalidadBean.getFlgActivo());

        tipoModalidadRepository.save(tipoModalidad);

    }

    @Override
    public void editarTipoModalidad(TipoModalidadBean tipoModalidadBean) {

        TipoModalidad tipoModalidad = new TipoModalidad();

        tipoModalidad.setNidTipoModalidad(tipoModalidadBean.getNidTipoModalidad());
        tipoModalidad.setTxtTipoModalidad(tipoModalidadBean.getTxtTipoModalidad());
        tipoModalidad.setNidUsuario(tipoModalidadBean.getNidUsuario());
        tipoModalidad.setTxtPc(tipoModalidadBean.getTxtPc());
        tipoModalidad.setTxtIp(tipoModalidadBean.getTxtIp());
        tipoModalidad.setFecEdicion(tipoModalidadBean.getFecEdicion());
        tipoModalidad.setFlgActivo(tipoModalidadBean.getFlgActivo());

        tipoModalidadRepository.save(tipoModalidad);

    }

    @Override
    public String obtenerTipoModalidadPorId(BigDecimal nidTipoModalidad) throws Exception {

        Optional<TipoModalidad> tipoModalidad = tipoModalidadRepository.findById(nidTipoModalidad);

        if (tipoModalidad.isPresent()) {
            return tipoModalidad.get().getTxtTipoModalidad();
        }

        return "";
    }

    @Override
    public List<TipoModalidadBean> loadTipoModalidadList(FindByParamBean findByParamBean) throws Exception {

        if (findByParamBean.getParameters() == null) {
            findByParamBean.setParameters(new HashMap<>());
        }

        List<TipoModalidad> tipoModalidadList = tipoModalidadRepository.findByParams(findByParamBean.getParameters(), findByParamBean.getOrderBy());

        if (!Util.esListaVacia(tipoModalidadList)) {

            return tipoModalidadList.stream().map(tipoModalidad -> {
                TipoModalidadBean tipoModalidadBean = new TipoModalidadBean();
                tipoModalidadBean.setNidTipoModalidad(tipoModalidad.getNidTipoModalidad());
                tipoModalidadBean.setTxtTipoModalidad(tipoModalidad.getTxtTipoModalidad());
                tipoModalidadBean.setNidUsuario(tipoModalidad.getNidUsuario());
                tipoModalidadBean.setTxtPc(tipoModalidad.getTxtPc());
                tipoModalidadBean.setTxtIp(tipoModalidad.getTxtIp());
                tipoModalidadBean.setFecEdicion(tipoModalidad.getFecEdicion());
                tipoModalidadBean.setFlgActivo(tipoModalidad.getFlgActivo());
                return tipoModalidadBean;
            }).collect(Collectors.toList());
        }

        return null;
    }

    @Override
    public Integer getRecordCount(FindByParamBean findByParamBean) throws Exception {

        if (findByParamBean.getParameters() == null) {
            findByParamBean.setParameters(new HashMap<>());
        }
        Integer count = tipoModalidadRepository.getRecordCount(findByParamBean.getParameters());
        return count;
    }

    @Override
    public TipoModalidadBean find(BigDecimal id) {

        Optional<TipoModalidad> tipoModalidad = tipoModalidadRepository.findById(id);

        if (!tipoModalidad.isPresent()) {
            return null;
        }

        return TipoModalidadCast.castTipoModalidadToTipoModalidadBean(tipoModalidad.get());

    }

}
