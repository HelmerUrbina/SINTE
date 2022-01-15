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
@Table(name = "SINTE_USUARIOS_GRIFOS")
@Data
public class BeanUsuarioGrifo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "CPERIODO_CODIGO", nullable = false)
    private String periodo;

    @Column(name = "NGRIFO_CODIGO")
    private String grifo;

    @Id
    @Column(name = "VUSUARIO_CODIGO", nullable = false)
    private String usuario;

    @Column(name = "CESTADO_CODIGO")
    private String estado;

}
