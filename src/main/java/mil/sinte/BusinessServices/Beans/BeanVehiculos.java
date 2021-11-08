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
@Table(name = "SINTE_VEHICULOS")
@Data
public class BeanVehiculos implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "NVEHICULO_CODIGO", nullable = false)
    private Integer codigo;

    @Column(name = "VVEHICULO_PLACA", nullable = false)
    private String placa;

    @Column(name = "VVEHICULO_SERIE_CHASIS", nullable = false)
    private String serieChasis;
    
    @Column(name = "VVEHICULO_SERIE_MOTOR", nullable = false)
    private String serieMotor;
    
    @Column(name = "VEHICULO_TIPO", nullable = false)
    private String tipo;
    
    @Column(name = "VEHICULO_CLASE", nullable = false)
    private String clase;
    
    @Column(name = "MARCA", nullable = false)
    private String marca;
    
    @Column(name = "MODELO", nullable = false)
    private String modelo;
    
    @Column(name = "CVEHICULO_TRANSMISION", nullable = false)
    private String transmision;
    
    @Column(name = "CVEHICULO_FABRICACION", nullable = false)
    private String fabricacion;
    
    @Column(name = "NVEHICULO_PUERTAS", nullable = false)
    private Integer puertas;
    
    @Column(name = "COLOR", nullable = false)
    private String color;
    
    @Column(name = "CESTADO_CODIGO")
    private String estado;
    
}
