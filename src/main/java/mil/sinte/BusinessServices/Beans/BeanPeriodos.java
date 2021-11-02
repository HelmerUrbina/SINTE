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
@Table(name = "SINTE_PERIODOS")
@Data
public class BeanPeriodos implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "CPERIODO_CODIGO", nullable = false)
    private String codigo;

    @Column(name = "VPERIODO_DESCRIPCION", nullable = false)
    private String descripcion;

    @Column(name = "VPERIODO_ABREVIATURA", nullable = false)
    private String abreviatura;

    @Column(name = "CESTADO_CODIGO")
    private String estado;

}
