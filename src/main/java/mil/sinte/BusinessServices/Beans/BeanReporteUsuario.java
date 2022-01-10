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
@Table(name = "SINTE_REPORTE_USUARIO")
@Data
public class BeanReporteUsuario implements Serializable{
    
    @Column(name = "PERIODO")
    private String periodo;
    
    @Column(name = "CODIGO_REPORTE")
    private String codigoReporte;
    
    @Column(name = "REPORTE")
    private String reporte;
    
    @Id
    @Column(name = "USUARIO")
    private String usuario;
    
    @Column(name = "NIVEL")
    private String nivel;
    
    @Column(name = "ESTADO")
    private String estado;
   
}
