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
@Table(name = "SINTE_VEHICULO_TIPO")
@Data
public class BeanVehiculoTipo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "NVEHICULO_TIPO_CODIGO", nullable = false)
    private String codigo;

    @Column(name = "VVEHICULO_TIPO_DESCRIPCION")
    private String descripcion;

    @Column(name = "VVEHICULO_TIPO_ABREVIATURA")
    private String abreviatura;

    @Column(name = "CESTADO_CODIGO")
    private String estado;

}
