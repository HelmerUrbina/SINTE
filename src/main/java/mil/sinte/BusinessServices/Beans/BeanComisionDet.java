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
@Table(name = "SINTE_ASIGNACION_COMISION_DETA")
@Data
public class BeanComisionDet implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "CODIGO", nullable = false)
    private String codigo;
    
    @Column(name = "DEPENDENCIA")
    private String dependencia;
    
    @Column(name = "CODIGO_DEPENDENCIA")
    private String codigoDependencia;
    
    @Column(name = "VEHICULO")
    private String vehiculo;
    
    @Column(name = "CODIGO_VEHICULO")
    private String codigoVehiculo;
    
    @Column(name = "COMBUSTIBLE")
    private String combustible;
    
    @Column(name = "CODIGO_COMBUSTIBLE")
    private String codigoCombustible;
    
    @Column(name = "NASIGNACION_COMISION_CANTIDAD")
    private String cantidad;
    
    @Column(name = "NASIGNACION_COMISION_DISTANCIA")
    private String distancia;
    
}
