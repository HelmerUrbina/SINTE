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
@Table(name = "SINTE_BRIGADAS")
@Data
public class BeanBrigadas implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "NBRIGADA_CODIGO", nullable = false)
    private Integer codigo;

    @Column(name = "CBRIGADA_CODIGO", nullable = false)
    private String brigadaCodigo;

    @Column(name = "VBRIGADA_DESCRIPCION", nullable = false)
    private String descripcion;

    @Column(name = "VBRIGADA_ABREVIATURA", nullable = false)
    private String abreviatura;

    @Column(name = "DIVISION_EJERCITO", nullable = false)
    private String divisionEjercito;

    @Column(name = "CESTADO_CODIGO")
    private String estado;

    @Column(name = "DEPARTAMENTO")
    private String departamento;

    @Column(name = "PROVINCIA")
    private String provincia;

    @Column(name = "UBIGEO")
    private String ubigeo;

}
