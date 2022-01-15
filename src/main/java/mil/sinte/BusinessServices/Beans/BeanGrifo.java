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
public class BeanGrifo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "NGRIFO_CODIGO", nullable = false)
    private Integer codigo;

    @Column(name = "NBRIGADA_CODIGO", nullable = false)
    private Integer brigada;

    @Column(name = "VBRIGADA_DESCRIPCION")
    private String brigadaNombre;

    @Column(name = "VGRIFO_NOMBRE", nullable = false)
    private String grifoNombre;

    @Column(name = "VGRIFO_DIRECCION", nullable = false)
    private String grifoDireccion;

    @Column(name = "CESTADO_CODIGO")
    private String estado;

    @Column(name = "DEPARTAMENTO")
    private String departamento;

    @Column(name = "PROVINCIA")
    private String provincia;

    @Column(name = "UBIGEO")
    private String ubigeo;

}
