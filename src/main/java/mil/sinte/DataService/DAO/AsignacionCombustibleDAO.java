package mil.sinte.DataService.DAO;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanAsignacionCombustible;
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
public interface AsignacionCombustibleDAO extends JpaRepository<BeanAsignacionCombustible, String> {

    @Query(nativeQuery = true, value = "SELECT "
            + "NBRIGADA_CODIGO, CMES_CODIGO, NTIPO_ASIGNACION_CODIGO, "
            + "UTIL.FUN_TIPO_COMBUSTIBLE_ABREVIATU(NTIPO_COMBUSTIBLE_CODIGO) CPERIODO_CODIGO, "
            + "NASIGNACION_CANTIDAD, NASIGNACION_SOLICITADO, CESTADO_CODIGO, NTIPO_COMBUSTIBLE_CODIGO "
            + "FROM SINTE_ASIGNACION_COMBUSTIBLE WHERE "
            + "CPERIODO_CODIGO=?1 AND "
            + "NBRIGADA_CODIGO=?2 AND "
            + "CMES_CODIGO=?3 AND "
            + "NTIPO_ASIGNACION_CODIGO=?4 "
            + "ORDER BY NTIPO_COMBUSTIBLE_CODIGO")
    List<BeanAsignacionCombustible> findAll(String periodo, Integer brigada, String mes, Integer tipoAsignacion);

    @Transactional
    @Modifying
    @Query(value = "{CALL SP_IDU_ASIGNACION_COMBUSTIBLE(:periodo, :brigada, :mes, :tipoAsignacion, :tipoCombustible, :usuario, :modo)}", nativeQuery = true)
    void sp_asignacion_combustible(
            @Param("periodo") String codigo,
            @Param("brigada") Integer nombre,
            @Param("mes") String mes,
            @Param("tipoAsignacion") Integer tipoAsignacion,
            @Param("tipoCombustible") Integer tipoCombustible,
            @Param("usuario") String usuario,
            @Param("modo") String modo);

    @Transactional
    @Modifying
    @Query(value = "{CALL SP_IDU_ASIGNACION_COMBUSTIB_G(:periodo, :brigada, :mes, :tipoAsignacion, :arrayDetalle, :usuario, :modo)}", nativeQuery = true)
    void sp_asignacion_combustible_Aprobacion(
            @Param("periodo") String codigo,
            @Param("brigada") Integer nombre,
            @Param("mes") String mes,
            @Param("tipoAsignacion") Integer tipoAsignacion,
            @Param("arrayDetalle") String arrayDetalle,
            @Param("usuario") String usuario,
            @Param("modo") String modo);

    @Transactional
    @Modifying
    @Query(value = "{CALL SP_IDU_ASIGNACION_COMBUSTIB_G2(:periodo, :mes, :tipoAsignacion, :arrayDetalle, :usuario, :modo)}", nativeQuery = true)
    void sp_asignacion_combustible_Aprobacion2(
            @Param("periodo") String codigo,
            @Param("mes") String mes,
            @Param("tipoAsignacion") Integer tipoAsignacion,
            @Param("arrayDetalle") String arrayDetalle,
            @Param("usuario") String usuario,
            @Param("modo") String modo);

}
