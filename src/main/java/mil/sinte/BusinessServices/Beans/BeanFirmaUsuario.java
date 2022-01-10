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
@Table(name = "SINTE_GRIFO")
@Data
public class BeanFirmaUsuario implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Column(name = "PERIODO", nullable = false)
    private String periodo;
    
    @Id
    @Column(name = "USUARIO")
    private String usuario;
    
    @Column(name = "SERIE")
    private String serie;
    
    @Column(name = "NOMBRE")
    private String nombre;
    
    @Column(name = "CODIGO_GRADO")
    private String codigoGrado;
    
    @Column(name = "GRADO")
    private String grado;
    
    @Column(name = "CARGO")
    private String cargo;
    
    @Column(name = "ESTADO")
    private String estado;
    
}
