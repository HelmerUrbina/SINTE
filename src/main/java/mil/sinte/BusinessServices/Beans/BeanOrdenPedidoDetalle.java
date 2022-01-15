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
@Table(name = "SINTE_ORDEN_PEDIDO_DETALLE")
@Data
public class BeanOrdenPedidoDetalle implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "COMBUSTIBLE", nullable = false)
    private String combustible;

    @Id
    @Column(name = "NTIPO_COMBUSTIBLE_CODIGO", nullable = false)
    private Integer tipoCombustible;

    @Column(name = "NORDEN_PEDIDO_DETALLE_CANTIDAD")
    private Double cantidad;

    @Column(name = "NORDEN_PEDIDO_DETALLE_PRECIO")
    private Double precio;

    @Column(name = "TOTAL")
    private Double total;

}
