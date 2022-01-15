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
@Table(name = "SINTE_PROG_EVENTO_FINAL")
@Data
public class BeanProgramacionEventoFinal implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "CPERIODO_CODIGO", nullable = false)
    private String periodo;

    @Column(name = "NTIPO_ASIGNACION_CODIGO", nullable = false)
    private Integer tipoAsignacion;

    @Column(name = "NBRIGADA_CODIGO", nullable = false)
    private Integer brigada;

    @Column(name = "NTIPO_COMBUSTIBLE_CODIGO", nullable = false)
    private Integer tipoCombustible;

    @Column(name = "VEVENTO_PRINCIPAL_CODIGO", nullable = false)
    private String eventoPrincipal;

    @Id
    @Column(name = "NEVENTO_FINAL_CODIGO", nullable = false)
    private Integer eventoFinal;

    @Column(name = "VEVENTO_FINAL_NOMBRE")
    private String eventoFinalNombre;
    
    @Column(name = "NTIPO_OPERACION_CODIGO")
    private String tipoOperacion;

    @Column(name = "NEVENTO_FINAL_PRIORIDAD")
    private Integer prioridad;

    @Column(name = "CESTADO_CODIGO")
    private String estado;
}
