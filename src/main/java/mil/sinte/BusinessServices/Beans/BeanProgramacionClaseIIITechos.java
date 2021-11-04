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
@Table(name = "SINTE_PROG_CLASE_III_TECHOS")
@Data
public class BeanProgramacionClaseIIITechos implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "CPERIODO_CODIGO", nullable = false)
    private String periodo;

    @Column(name = "NTIPO_ASIGNACION_CODIGO", nullable = false)
    private Integer tipoAsignacion;

    @Id
    @Column(name = "NBRIGADA_CODIGO", nullable = false)
    private Integer brigada;

    @Column(name = "VBRIGADA_ABREVIATURA", nullable = false)
    private String brigadaNombre;

    @Column(name = "NPROGRAMACION_CLASE_III_IMPORT")
    private Double importe;

    @Column(name = "CESTADO_CODIGO")
    private String estado;
}
