package mil.sinte.DataService.DAO;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanPeriodoTipoAsignacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
public interface PeriodoTipoAsignacionDAO extends JpaRepository<BeanPeriodoTipoAsignacion, String> {

    @Query(nativeQuery = true, value = "SELECT "
            + "CPERIODO_CODIGO, NTIPO_ASIGNACION_CODIGO, "
            + "UTIL.FUN_TIPO_ASIGNACION_ABREVIATUR(NTIPO_ASIGNACION_CODIGO) AS VTIPO_ASIGNACION_ABREVIATURA, "
            + "UTIL.FUN_ESTADO_DESCRIPCION(CESTADO_CODIGO) CESTADO_CODIGO "
            + "FROM SINTE_PERIODO_TIPO_ASIGNACION WHERE "
            + "CPERIODO_CODIGO=?1 "
            + "ORDER BY NTIPO_ASIGNACION_CODIGO")
    List<BeanPeriodoTipoAsignacion> findByPeriodo(String periodo);

    @Transactional
    @Modifying
    @Query(value = "{CALL SP_IDU_PERIODO_TIPO_ASIGNACION(:periodo, :tipoAsignacion, :usuario, :modo)}", nativeQuery = true)
    void sp_periodoTipoAsignacion(
            @Param("periodo") String periodo,
            @Param("tipoAsignacion") String tipoAsignacion,
            @Param("usuario") String usuario,
            @Param("modo") String modo);
}
