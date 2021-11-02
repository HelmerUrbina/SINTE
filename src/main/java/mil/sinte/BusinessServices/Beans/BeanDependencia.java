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
@Table(name = "SINTE_DEPENDENCIAS")
@Data
public class BeanDependencia implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "NDEPENDENCIA_CODIGO", nullable = false)
    private Integer codigo;

    @Column(name = "NBRIGADA_CODIGO", nullable = false)
    private Integer brigada;

    @Column(name = "TIPO_DEPENDENCIA")
    private String tipoDependencia;

    @Column(name = "VDEPENDENCIA_DESCRIPCION", nullable = false)
    private String descripcion;

    @Column(name = "VDEPENDENCIA_ABREVIATURA", nullable = false)
    private String abreviatura;

    @Column(name = "CESTADO_CODIGO")
    private String estado;

}
