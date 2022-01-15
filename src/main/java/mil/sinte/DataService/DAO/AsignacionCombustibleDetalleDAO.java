package mil.sinte.DataService.DAO;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanAsignacionCombustibleDetalle;
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
public interface AsignacionCombustibleDetalleDAO extends JpaRepository<BeanAsignacionCombustibleDetalle, String> {

    @Query(nativeQuery = true, value = "SELECT "
            + "NDEPENDENCIA_CODIGO CPERIODO_CODIGO, NVEHICULO_CODIGO NBRIGADA_CODIGO, NTIPO_ASIGNACION_CODIGO, "
            + "NTIPO_COMBUSTIBLE_CODIGO, "
            + "UTIL.FUN_DEPENDENCIA_ABREVIATURA(NBRIGADA_CODIGO, NDEPENDENCIA_CODIGO) NDEPENDENCIA_CODIGO,"
            + "UTIL.FUN_VEHICULO(NVEHICULO_CODIGO) NVEHICULO_CODIGO, "
            + "UTIL.FUN_TIPO_OPERACION_ABREVIATUR(NTIPO_OPERACION_CODIGO) NTIPO_OPERACION_CODIGO, "
            + "NASIGNACION_DETALLE_CANTIDAD, NASIGNACION_DETALLE_SOLICITADO, CMES_CODIGO "
            + "FROM SINTE_ASIGNACION_DETALLE WHERE "
            + "CPERIODO_CODIGO=?1 AND "
            + "NBRIGADA_CODIGO=?2 AND "
            + "CMES_CODIGO=?3 AND "
            + "NTIPO_ASIGNACION_CODIGO=?4 AND "
            + "NTIPO_COMBUSTIBLE_CODIGO =?5 "
            + "ORDER BY NDEPENDENCIA_CODIGO, NVEHICULO_CODIGO")
    List<BeanAsignacionCombustibleDetalle> findAll(String periodo, Integer brigada, String mes, Integer tipoAsignacion, Integer tipoCombustible);

    @Query(nativeQuery = true, value = "SELECT "
            + "NDEPENDENCIA_CODIGO CPERIODO_CODIGO, NVEHICULO_CODIGO NBRIGADA_CODIGO, CMES_CODIGO, NTIPO_ASIGNACION_CODIGO, "
            + "NTIPO_COMBUSTIBLE_CODIGO, "
            + "UTIL.FUN_DEPENDENCIA_ABREVIATURA(NBRIGADA_CODIGO, NDEPENDENCIA_CODIGO) NDEPENDENCIA_CODIGO, "
            + "UTIL.FUN_VEHICULO(NVEHICULO_CODIGO) NVEHICULO_CODIGO, "
            + "UTIL.FUN_TIPO_OPERACION_ABREVIATUR(NTIPO_OPERACION_CODIGO) NTIPO_OPERACION_CODIGO, "
            + "NASIGNACION_DETALLE_CANTIDAD, NASIGNACION_DETALLE_SOLICITADO "
            + "FROM SINTE_ASIGNACION_DETALLE WHERE "
            + "CPERIODO_CODIGO=?1 AND "
            + "NBRIGADA_CODIGO=?2 AND "
            + "CMES_CODIGO=?3 AND "
            + "NTIPO_ASIGNACION_CODIGO=?4 AND "
            + "NTIPO_COMBUSTIBLE_CODIGO=?5 "
            + "ORDER BY NDEPENDENCIA_CODIGO, NVEHICULO_CODIGO")
    List<BeanAsignacionCombustibleDetalle> findAllAprobacion(String periodo, Integer brigada, String mes, Integer tipoAsignacion, Integer tipoCombustible);

    @Transactional
    @Modifying
    @Query(value = "{CALL SP_IDU_ASIGNACION_DETALLE(:periodo, :brigada, :mes, :tipoAsignacion, :tipoCombustible, :dependencia, :vehiculo, :tipoOperacion, :cantidad, :solicitud, :usuario, :modo)}", nativeQuery = true)
    void sp_asignacionCombustibleDetalle(
            @Param("periodo") String codigo,
            @Param("brigada") Integer nombre,
            @Param("mes") String mes,
            @Param("tipoAsignacion") Integer tipoAsignacion,
            @Param("tipoCombustible") Integer tipoCombustible,
            @Param("dependencia") Integer dependencia,
            @Param("vehiculo") Integer vehiculo,
            @Param("tipoOperacion") Integer tipoOperacion,
            @Param("cantidad") Integer cantidad,
            @Param("solicitud") Integer solicitud,
            @Param("usuario") String usuario,
            @Param("modo") String modo);

    @Transactional
    @Modifying
    @Query(value = "{CALL SP_IDU_ASIGNACION_APROBACION(:periodo, :brigada, :mes, :tipoAsignacion, :tipoCombustible, :arrayDetalle, :usuario, :modo)}", nativeQuery = true)
    void sp_asignacionCombustibleDetalleAprobacion(
            @Param("periodo") String codigo,
            @Param("brigada") Integer nombre,
            @Param("mes") String mes,
            @Param("tipoAsignacion") Integer tipoAsignacion,
            @Param("tipoCombustible") Integer tipoCombustible,
            @Param("arrayDetalle") String arrayDetalle,
            @Param("usuario") String usuario,
            @Param("modo") String modo);

}
