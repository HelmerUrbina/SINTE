package mil.sinte.DataService.DAO;

import java.sql.Date;
import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanOrdenPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
@Repository
public interface OrdenPedidoDAO extends JpaRepository<BeanOrdenPedido, String> {

    @Query(nativeQuery = true, value = "SELECT "
            + "CPERIODO_CODIGO, NORDEN_PEDIDO_CODIGO, "
            + "UTIL.FUN_TIPO_ASIGNACION_ABREVIATUR(NTIPO_ASIGNACION_CODIGO) NTIPO_ASIGNACION_CODIGO, "
            + "UTIL.FUN_FUENTE_FINANCIAMIENTO(NFUENTE_FINANCIAMIENTO_CODIGO) NFUENTE_FINANCIAMIENTO_CODIGO, TO_CHAR(DORDEN_PEDIDO_FECHA,'DD/MM/YYYY') AS DORDEN_PEDIDO_FECHA, "
            + "UTIL.FUN_GRIFO_NOMBRE(NGRIFO_CODIGO) NGRIFO_CODIGO, "
            + "PK_SINTE.FUN_TOTAL_ORDEN_PEDIDO(CPERIODO_CODIGO, NORDEN_PEDIDO_CODIGO) AS TOTAL, "
            + "UTIL.FUN_ESTADO_DESCRIPCION(CESTADO_CODIGO) CESTADO_CODIGO "
            + "FROM SINTE_ORDEN_PEDIDO WHERE "
            + "CPERIODO_CODIGO=?1 AND "
            + "CMES_CODIGO=?2 "
            + "ORDER BY NORDEN_PEDIDO_CODIGO")
    List<BeanOrdenPedido> findByPeriodoAndMes(String periodo, String mes);

    @Query(nativeQuery = true, value = "SELECT "
            + "CPERIODO_CODIGO, NORDEN_PEDIDO_CODIGO,  NTIPO_ASIGNACION_CODIGO, "
            + "NFUENTE_FINANCIAMIENTO_CODIGO, TO_CHAR(DORDEN_PEDIDO_FECHA,'MM/DD/YYYY') AS DORDEN_PEDIDO_FECHA, "
            + "NGRIFO_CODIGO, CESTADO_CODIGO, 0 TOTAL "
            + "FROM SINTE_ORDEN_PEDIDO WHERE "
            + "CPERIODO_CODIGO=?1 AND "
            + "NORDEN_PEDIDO_CODIGO=?2 ")
    BeanOrdenPedido findByPeriodoAndOrdenPedido(String periodo, Integer ordenPedido);

    @Transactional
    @Modifying
    @Query(value = "{CALL SP_IDU_ORDEN_PEDIDO(:periodo, :ordenPedido, :tipoAsignacion,"
            + " :fuenteFinanciamiento, :fecha, :grifo, :lista, :usuario, :modo)}", nativeQuery = true)
    void sp_ordenPedido(
            @Param("periodo") String periodo,
            @Param("ordenPedido") Integer ordenPedido,
            @Param("tipoAsignacion") Integer tipoAsignacion,
            @Param("fuenteFinanciamiento") Integer fuenteFinanciamiento,
            @Param("fecha") Date fecha,
            @Param("grifo") Integer grifo,
            @Param("lista") String lista,
            @Param("usuario") String usuario,
            @Param("modo") String modo);
}
