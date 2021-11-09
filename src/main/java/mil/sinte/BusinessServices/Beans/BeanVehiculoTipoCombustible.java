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
@Table(name = "SINTE_VEHICULOS_TIPO_COMBUSTIB")
@Data
public class BeanVehiculoTipoCombustible implements Serializable{
       
    private static final long serialVersionUID = 1L;
    
    @Column(name = "NVEHICULO_CODIGO", nullable = false)
    private String vehiculo;
    
    @Id
    @Column(name = "NTIPO_COMBUSTIBLE_CODIGO", nullable = false)
    private String tipoCombustible;
    
    @Column(name = "NVEHICULO_COMBUSTIBLE_CAP")
    private double capacidad;
    
    @Column(name = "CESTADO_CODIGO")
    private String estado;
    
}
