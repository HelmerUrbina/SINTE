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
@Table(name = "SINTE_ASIGNACION_COMBUSTIBLE")
@Data
public class BeanAsignacionCombustible implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "CPERIODO_CODIGO", nullable = false)
    private String periodo;

    @Column(name = "NBRIGADA_CODIGO")
    private String brigada;

    @Column(name = "CMES_CODIGO")
    private String mes;

    @Column(name = "NTIPO_ASIGNACION_CODIGO")
    private String tipoAsignacion;

    @Id
    @Column(name = "NTIPO_COMBUSTIBLE_CODIGO")
    private String tipoCombustible;

    @Column(name = "NASIGNACION_CANTIDAD")
    private Integer cantidad;

    @Column(name = "NASIGNACION_SOLICITADO")
    private Integer solicitado;

    @Column(name = "CESTADO_CODIGO")
    private String estado;

}
