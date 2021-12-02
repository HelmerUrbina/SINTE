package mil.sinte.BusinessServices.Beans;

import java.io.Serializable;
import java.sql.Date;
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
@Table(name = "SINTE_VEHICULOS_SOAT")
@Data
public class BeanVehiculoSoat implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "NVEHICULO_CODIGO", nullable = false)
    private String vehiculo;

    @Id
    @Column(name = "NVEHICULO_SOAT_CODIGO", nullable = false)
    private Integer codigo;

    @Column(name = "CVEHICULO_SOAT_TIPO")
    private String tipo;

    @Column(name = "NSOAT_ASEGURADORA_CODIGO", nullable = false)
    private String aseguradora;

    @Column(name = "VVEHICULO_SOAT_CERTIFICADO")
    private String certificado;

    @Column(name = "DVEHICULO_SOAT_INICIO")
    private Date inicio;

    @Column(name = "DVEHICULO_SOAT_FIN")
    private Date fin;

    @Column(name = "CESTADO_CODIGO")
    private String estado;

}
