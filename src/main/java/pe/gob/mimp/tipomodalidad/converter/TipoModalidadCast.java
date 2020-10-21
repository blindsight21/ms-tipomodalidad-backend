/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.tipomodalidad.converter;

import pe.gob.mimp.siscap.model.TipoModalidad;
import pe.gob.mimp.tipomodalidad.bean.TipoModalidadBean;

/**
 *
 * @author Omar
 */
public class TipoModalidadCast {

    public static TipoModalidadBean castTipoModalidadToTipoModalidadBean(TipoModalidad tipoObjetivo) {

        if (tipoObjetivo == null) {
            return null;
        }

        TipoModalidadBean tipoObjetivoBean = new TipoModalidadBean();

        tipoObjetivoBean.setNidTipoModalidad(tipoObjetivo.getNidTipoModalidad());
        tipoObjetivoBean.setTxtTipoModalidad(tipoObjetivo.getTxtTipoModalidad());
        tipoObjetivoBean.setFlgActivo(tipoObjetivo.getFlgActivo());
        tipoObjetivoBean.setNidUsuario(tipoObjetivo.getNidUsuario());
        tipoObjetivoBean.setTxtPc(tipoObjetivo.getTxtPc());
        tipoObjetivoBean.setTxtIp(tipoObjetivo.getTxtIp());
        tipoObjetivoBean.setFecEdicion(tipoObjetivo.getFecEdicion());

        return tipoObjetivoBean;
    }
    
    public static TipoModalidad castTipoModalidadBeanToTipoModalidad(TipoModalidadBean tipoObjetivoBean) {

        if (tipoObjetivoBean == null) {
            return null;
        }

        TipoModalidad tipoObjetivo = new TipoModalidad();

        tipoObjetivo.setNidTipoModalidad(tipoObjetivoBean.getNidTipoModalidad());
        tipoObjetivo.setTxtTipoModalidad(tipoObjetivoBean.getTxtTipoModalidad());
        tipoObjetivo.setFlgActivo(tipoObjetivoBean.getFlgActivo());
        tipoObjetivo.setNidUsuario(tipoObjetivoBean.getNidUsuario());
        tipoObjetivo.setTxtPc(tipoObjetivoBean.getTxtPc());
        tipoObjetivo.setTxtIp(tipoObjetivoBean.getTxtIp());
        tipoObjetivo.setFecEdicion(tipoObjetivoBean.getFecEdicion());

        return tipoObjetivo;
    }
}
