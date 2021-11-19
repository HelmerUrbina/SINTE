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
@Data
@Table(name = "SINTE_VEHICULOS_BRIGADAS")
public class BeanVehiculosBrigada implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "CPERIODO_CODIGO")
    private String periodo;

    @Column(name = "NBRIGADA_CODIGO")
    private String brigada;

    @Id
    @Column(name = "NVEHICULO_CODIGO", nullable = false)
    private String vehiculo;

    @Column(name = "NDEPENDENCIA_CODIGO")
    private String dependencia;

    @Column(name = "DVEHICULO_BRIGADA_FECHA")
    private String fecha;

    @Column(name = "CESTADO_CODIGO")
    private String estado;
}
