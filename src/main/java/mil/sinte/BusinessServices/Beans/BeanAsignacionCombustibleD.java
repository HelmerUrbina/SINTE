/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.sinte.BusinessServices.Beans;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
@Entity
@Table(name = "SINTE_ASIGNACION_COMBUSTIBLE_D")
@Data
public class BeanAsignacionCombustibleD implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Column(name = "CPERIODO_CODIGO", nullable = false)
    private String periodo;

    @Column(name = "NBRIGADA_CODIGO")
    private String brigada;

    @Column(name = "CMES_CODIGO")
    private String mes;
    
    @Column(name = "NTIPO_ASIGNACION_CODIGO")
    private String tipoAsignacion;
    
    @Column(name = "NTIPO_COMBUSTIBLE_CODIGO")
    private String tipoCombustible;
    
    @Column(name = "NDEPENDENCIA_CODIGO")
    private String dependencia;
    
    @Id
    @Column(name = "NVEHICULO_CODIGO")
    private String vehiculo;
    
    @Column(name = "NASIGNACION_DETALLE_CANTIDAD")
    private Integer cantidad;
    
    @Column(name = "NASIGNACION_DETALLE_SOLICITADO")
    private Integer solicitado;
    
    @Column(name = "VUSUARIO_CREADOR")
    private String usuarioCreador;
    
    @Column(name = "DUSUARIO_CREADOR")
    private String fechaCreador;
    
    @Column(name = "VUSUARIO_CODIGO")
    private String usuarioCodigo;
    
}
