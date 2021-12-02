package mil.sinte.BusinessServices.Beans;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
@Entity
@Data
@Table(name = "SINTE_VEHICULOS_BRIGADAS")
@IdClass(BeanVehiculosBrigada.class)
public class BeanVehiculosBrigada implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "CPERIODO_CODIGO", nullable = false)
    private String periodo;

    @Column(name = "NBRIGADA_CODIGO", nullable = false)
    private String brigada;

    @Id
    @Column(name = "NVEHICULO_CODIGO", nullable = false)
    private Integer vehiculo;
    
    @Id
    @Column(name = "NDEPENDENCIA_CODIGO", nullable = false)
    private Integer dependencia;

    @Column(name = "DVEHICULO_BRIGADA_FECHA", nullable = false)
    private Date fecha;

    @Column(name = "CESTADO_CODIGO")
    private String estado;
}
