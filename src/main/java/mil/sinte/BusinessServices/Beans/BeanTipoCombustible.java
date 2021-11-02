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
@Table(name = "SINTE_TIPO_COMBUSTIBLE")
@Data
public class BeanTipoCombustible implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "NTIPO_COMBUSTIBLE_CODIGO", nullable = false)
    private Integer codigo;

    @Column(name = "VTIPO_COMBUSTIBLE_DESCRIPCION", nullable = false)
    private String descripcion;

    @Column(name = "VTIPO_COMBUSTIBLE_ABREVIATURA", nullable = false)
    private String abreviatura;

    @Column(name = "CESTADO_CODIGO")
    private String estado;

}
