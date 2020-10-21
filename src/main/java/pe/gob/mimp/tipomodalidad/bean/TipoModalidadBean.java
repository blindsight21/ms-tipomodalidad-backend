/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.tipomodalidad.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import pe.gob.mimp.tipomodalidad.util.FormatoFechaConstante;

/**
 *
 * @author Omar
 */
public class TipoModalidadBean implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @JsonInclude(Include.NON_NULL)
    private BigDecimal nidTipoModalidad;
    @JsonInclude(Include.NON_NULL)
    private String txtTipoModalidad;
    @JsonInclude(Include.NON_NULL)
    private BigInteger flgActivo;
    @JsonInclude(Include.NON_NULL)
    private BigInteger nidUsuario;
    @JsonInclude(Include.NON_NULL)
    private String txtPc;
    @JsonInclude(Include.NON_NULL)
    private String txtIp;
    @JsonInclude(Include.NON_NULL)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = FormatoFechaConstante.yyyyMMddTHHmmssSSSXXX, timezone = FormatoFechaConstante.ZONA_HORARIA)
    private Date fecEdicion;

    public BigDecimal getNidTipoModalidad() {
        return nidTipoModalidad;
    }

    public void setNidTipoModalidad(BigDecimal nidTipoModalidad) {
        this.nidTipoModalidad = nidTipoModalidad;
    }

    public String getTxtTipoModalidad() {
        return txtTipoModalidad;
    }

    public void setTxtTipoModalidad(String txtTipoModalidad) {
        this.txtTipoModalidad = txtTipoModalidad;
    }

    public BigInteger getFlgActivo() {
        return flgActivo;
    }

    public void setFlgActivo(BigInteger flgActivo) {
        this.flgActivo = flgActivo;
    }

    public BigInteger getNidUsuario() {
        return nidUsuario;
    }

    public void setNidUsuario(BigInteger nidUsuario) {
        this.nidUsuario = nidUsuario;
    }

    public String getTxtPc() {
        return txtPc;
    }

    public void setTxtPc(String txtPc) {
        this.txtPc = txtPc;
    }

    public String getTxtIp() {
        return txtIp;
    }

    public void setTxtIp(String txtIp) {
        this.txtIp = txtIp;
    }

    public Date getFecEdicion() {
        return fecEdicion;
    }

    public void setFecEdicion(Date fecEdicion) {
        this.fecEdicion = fecEdicion;
    }

    @Override
    public String toString() {
        return "TipoModalidadBean{" + "nidTipoModalidad=" + nidTipoModalidad + ", txtTipoModalidad=" + txtTipoModalidad + ", flgActivo=" + flgActivo + ", nidUsuario=" + nidUsuario + ", txtPc=" + txtPc + ", txtIp=" + txtIp + ", fecEdicion=" + fecEdicion + '}';
    }

}
