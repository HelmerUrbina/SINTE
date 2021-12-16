/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.sinte.BusinessServices.Beans;

import java.io.Serializable;
import java.sql.Date;
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
@Table(name = "SINTE_ASIGNACION_VARIACION")
@Data
public class BeanVariacion implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "NASIGNACION_VARIACION_CODIGO", nullable = false)
    private String codigo;
    
    @Column(name = "CPERIODO_CODIGO")
    private String codigoPeriodo;
    
    @Column(name = "NBRIGADA_CODIGO")
    private String brigada;
    
    @Column(name = "CODIGO_BRIGADA")
    private String codigoBrigada;
    
    @Column(name = "CMES_CODIGO")
    private String mes;
    
    @Column(name = "CODIGO_MES")
    private String codigoMes;

    @Column(name = "NTIPO_ASIGNACION_CODIGO")
    private String asignacion;

    @Column(name = "CODIGO_ASIGNACION")
    private String codigoAsignacion;

    @Column(name = "NTIPO_COMBUSTIBLE_CODIGO")
    private String combustible;

    @Column(name = "CODIGO_COMBUSTIBLE")
    private String codigoCombustible;

    @Column(name = "DASIGNACION_VARIACION_FECHA")
    private Date fecha;

    @Column(name = "VASIGNACION_VARIACION_JUSTIFIC")
    private String justificacion;
    
    @Column(name = "VASIGNACION_VARIACION_RECHAZO")
    private String rechazo;

    @Column(name = "CESTADO_CODIGO")
    private String estado;
}
