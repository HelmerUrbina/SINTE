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
@Table(name = "SINTE_USUARIOS")
@Data
public class BeanUsuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "VUSUARIO_CODIGO", nullable = false)
    private String usuario;

    @Column(name = "VUSUARIO_PASSWORD")
    private String password;

    @Column(name = "VUSUARIO_PATERNO", nullable = false)
    private String paterno;

    @Column(name = "VUSUARIO_MATERNO", nullable = false)
    private String materno;

    @Column(name = "VUSUARIO_NOMBRES", nullable = false)
    private String nombres;

    @Column(name = "VUSUARIO_CORREO", nullable = false)
    private String correo;

    @Column(name = "VUSUARIO_TELEFONO", nullable = false)
    private String telefono;

    @Column(name = "VUSUARIO_CARGO")
    private String cargo;

    @Column(name = "NAREA_LABORAL_CODIGO")
    private String areaLaboral;

    @Column(name = "CESTADO_CODIGO")
    private String estado;

    @Column(name = "NBRIGADA_CODIGO")
    private String brigada;

    @Column(name = "NUSUARIO_ROL_CODIGO")
    private String Rol;

    @Column(name = "NUSUARIO_AUTORIZACION")
    private Integer autorizacion;

}
