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
@Table(name = "SINTE_ORDEN_PEDIDO")
@Data
public class BeanOrdenPedido implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "CPERIODO_CODIGO", nullable = false)
    private String periodo;

    @Id
    @Column(name = "NORDEN_PEDIDO_CODIGO", nullable = false)
    private Integer ordenPedido;

    @Column(name = "NTIPO_ASIGNACION_CODIGO", nullable = false)
    private String tipoAsignacion;

    @Column(name = "NFUENTE_FINANCIAMIENTO_CODIGO", nullable = false)
    private String fuenteFinanciamiento;

    @Column(name = "DORDEN_PEDIDO_FECHA", nullable = false)
    private String fecha;

    @Column(name = "NGRIFO_CODIGO")
    private String grifo;

    @Column(name = "TOTAL")
    private Double total;

    @Column(name = "CESTADO_CODIGO")
    private String estado;

}
