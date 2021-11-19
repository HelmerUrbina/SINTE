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
@Table(name = "SINTE_PERIODO_TIPO_ASIGNACION")
@Data
public class BeanPeriodoTipoAsignacion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "CPERIODO_CODIGO", nullable = false)
    private String periodo;

    @Id
    @Column(name = "NTIPO_ASIGNACION_CODIGO", nullable = false)
    private String tipoAsignacion;
    
    @Column(name = "VTIPO_ASIGNACION_ABREVIATURA", nullable = false)
    private String tipoAsignacionAbreviatura;

    @Column(name = "CESTADO_CODIGO")
    private String estado;
}
