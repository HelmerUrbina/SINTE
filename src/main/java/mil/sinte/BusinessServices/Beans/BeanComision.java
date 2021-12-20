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
@Table(name = "SINTE_ASIGNACION_COMISION")
@Data
public class BeanComision implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "CODIGO", nullable = false)
    private String codigo;
    
    @Column(name = "DESCRIPCION")
    private String descripcion;
    
    @Column(name = "ESTADO")
    private String estado;
    
    @Column(name = "CPERIODO_CODIGO")
    private String codigoPeriodo;
    
    @Column(name = "NBRIGADA_CODIGO")
    private String codigoBrigada;
    
    @Column(name = "CMES_CODIGO")
    private String codigoMes;
    
    @Column(name = "NTIPO_ASIGNACION_CODIGO")
    private String codigoAsignacion;
    
}
