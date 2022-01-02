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
@Table(name = "SINTE_PROG_EVENTO_PRINCIPAL")
@Data
public class BeanProgramacionEventoPrincipal implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "CPERIODO_CODIGO", nullable = false)
    private String periodo;

    @Column(name = "NTIPO_ASIGNACION_CODIGO", nullable = false)
    private Integer tipoAsignacion;

    @Column(name = "NBRIGADA_CODIGO", nullable = false)
    private Integer brigada;
    
    @Column(name = "NTIPO_COMBUSTIBLE_CODIGO", nullable = false)
    private Integer tipoCombustible;

    @Id
    @Column(name = "VEVENTO_PRINCIPAL_CODIGO", nullable = false)
    private String eventoPrincipal;

    @Column(name = "VEVENTO_PRINCIPAL_NOMBRE")
    private String eventoPrincipalNombre;

    @Column(name = "VEVENTO_PRINCIPAL_PRINCIPAL")
    private String eventoPrincipalPrincipal;

    @Column(name = "NEVENTO_PRINCIPAL_NIVEL")
    private Integer nivel;

    @Column(name = "NEVENTO_PRINCIPAL_NIVELES")
    private Integer niveles;

    @Column(name = "NEVENTO_PRINCIPAL_TOTAL")
    private Double total;

    @Column(name = "CEVENTO_PRINCIPAL_FINAL")
    private String isFinal;

    @Column(name = "CESTADO_CODIGO")
    private String estado;
}
