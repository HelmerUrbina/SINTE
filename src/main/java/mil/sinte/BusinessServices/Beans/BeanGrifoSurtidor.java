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
@Table(name = "SINTE_GRIFO_SURTIDOR")
@Data
public class BeanGrifoSurtidor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "NGRIFO_CODIGO", nullable = false)
    private Integer grifo;

    @Id
    @Column(name = "NGRIFO_SURTIDOR_CODIGO", nullable = false)
    private Integer grifoSurtidor;

    @Column(name = "NTIPO_COMBUSTIBLE_CODIGO", nullable = false)
    private Integer tipoCombustible;

    @Column(name = "VGRIFO_SURTIDOR_NOMBRE", nullable = false)
    private String surtidor;

    @Column(name = "VTIPO_COMBUSTIBLE_DESCRIPCION")
    private String tipoCombustibleNombre;

    @Column(name = "NGRIFO_SUTIDOR_CAPACIDAD")
    private Integer capacidad;

    @Column(name = "CESTADO_CODIGO")
    private String estado;

}
