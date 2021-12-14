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
@Table(name = "SINTE_ASIGNACION_VARIACION_DET")
@Data
public class BeanVariacionDet implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Column(name = "NDEPENDENCIA_CODIGO")
    private String dependencia;
    
    @Column(name = "CODIGO_DEPENDENCIA")
    private String codigoDependencia;
    
    @Column(name = "NVEHICULO_CODIGO")
    private String vehiculo;
    
    @Id
    @Column(name = "CODIGO_VEHICULO", nullable = false)
    private String codigoVehiculo;
    
    @Column(name = "CASIGNACION_VARIACION_TIPO")
    private String tipoVariacion;
    
    @Column(name = "CODIGO_TIPO_ASIGNACION")
    private String codigoTipoVariacion;
    
    @Column(name = "NASIGNACION_VARIACION_CANTIDAD")
    private String cantidad;
    
    @Column(name = "VASIGNACION_VARIACION_JUSTIFIC")
    private String justificacion;
 
}
