/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.tipomodalidad.ws.rest;

import java.math.BigDecimal;
import java.util.List;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.gob.mimp.tipomodalidad.bean.FindByParamBean;

import pe.gob.mimp.tipomodalidad.bean.ResponseData;
import pe.gob.mimp.tipomodalidad.bean.TipoModalidadBean;
import pe.gob.mimp.tipomodalidad.service.TipoModalidadService;

/**
 *
 * @author BlindSight
 */
@RestController
@RequestMapping(value = "/")
public class TipoModalidadController {

    @Autowired
    private TipoModalidadService tipoModalidadService;

    @PostMapping(value = "/crearTipoModalidad", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> crearTipoModalidad(@RequestBody TipoModalidadBean tipoModalidadBean) throws Exception {

        tipoModalidadService.crearTipoModalidad(tipoModalidadBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.CREATED.value());
        response.setMsg(HttpStatus.CREATED.getReasonPhrase());

        return ResponseEntity.ok(response);

    }

    @PostMapping(value = "/editarTipoModalidad", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> editarTipoModalidad(@RequestBody TipoModalidadBean tipoModalidadBean) throws Exception {

        tipoModalidadService.editarTipoModalidad(tipoModalidadBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());

        return ResponseEntity.ok(response);

    }

    @GetMapping(value = "/obtenerTipoModalidadPorId/{nidTipoModalidad}")
    public ResponseEntity<ResponseData<?>> obtenerTipoModalidadPorId(@PathVariable("nidTipoModalidad") BigDecimal nidTipoModalidad) throws Exception {

        String txtTipoModalidad = tipoModalidadService.obtenerTipoModalidadPorId(nidTipoModalidad);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(txtTipoModalidad);

        return ResponseEntity.ok(response);

    }

    @PostMapping(value = "/loadTipoModalidadList", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> loadTipoModalidadList(@RequestBody FindByParamBean findByParamBean) throws Exception {

        List<TipoModalidadBean> tipoModalidadList = tipoModalidadService.loadTipoModalidadList(findByParamBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(tipoModalidadList);

        return ResponseEntity.ok(response);

    }

    @PostMapping(value = "/getRecordCount", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> getRecordCount(@RequestBody FindByParamBean findByParamBean) throws Exception {

        Integer count = tipoModalidadService.getRecordCount(findByParamBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(count);

        return ResponseEntity.ok(response);

    }

    @GetMapping(value = "/find/{id}")
    public ResponseEntity<ResponseData<?>> find(@PathVariable("id") BigDecimal id) throws Exception {

        TipoModalidadBean tipoModalidadBean = tipoModalidadService.find(id);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(tipoModalidadBean);

        return ResponseEntity.ok(response);

    }

}
