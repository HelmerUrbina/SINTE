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
@Table(name = "SINTE_ASIGNACION_VARIACION")
@Data
public class BeanUsuarioGrifo implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "USUARIO", nullable = false)
    private String usuario;
    
    @Column(name = "NGRIFO_CODIGO")
    private String grifo;
    
    @Column(name = "CPERIODO_CODIGO")
    private String periodo;
    
    @Column(name = "ESTADO")
    private String estado;
    
}
