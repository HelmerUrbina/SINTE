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
@Table(name = "SINTE_DIVISION_EJERCITO")
@Data
public class BeanDivisionEjercito implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "NDIVISION_EJERCITO_CODIGO", nullable = false)
    private Integer codigo;

    @Column(name = "VDIVISION_EJERCITO_DESCRIPCION", nullable = false)
    private String descripcion;

    @Column(name = "VDIVISION_EJERCITO_ABREVIATURA", nullable = false)
    private String abreviatura;

    @Column(name = "CESTADO_CODIGO")
    private String estado;

}
