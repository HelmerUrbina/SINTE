package mil.sinte.DataService.DAO;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanOrdenPedidoDetalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
@Repository
public interface OrdenPedidoDetalleDAO extends JpaRepository<BeanOrdenPedidoDetalle, String> {

    @Query(nativeQuery = true, value = "SELECT "
            + "UTIL.FUN_TIPO_COMBUSTIBLE_ABREVIATU(NTIPO_COMBUSTIBLE_CODIGO) COMBUSTIBLE, "
            + "NTIPO_COMBUSTIBLE_CODIGO, NORDEN_PEDIDO_DETALLE_CANTIDAD, NORDEN_PEDIDO_DETALLE_PRECIO, "
            + "NORDEN_PEDIDO_DETALLE_CANTIDAD*NORDEN_PEDIDO_DETALLE_PRECIO TOTAL "
            + "FROM SINTE_ORDEN_PEDIDO_DETALLE WHERE "
            + "CPERIODO_CODIGO=?1 AND "
            + "NORDEN_PEDIDO_CODIGO=?2 "
            + "ORDER BY NTIPO_COMBUSTIBLE_CODIGO")
    List<BeanOrdenPedidoDetalle> findByPeriodoAndOrdenPedido(String periodo, Integer ordenPedido);
}
