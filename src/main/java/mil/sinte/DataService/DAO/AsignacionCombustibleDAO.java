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

    @Query(nativeQuery = true, value = "SELECT CPERIODO_CODIGO,\n"
            + "       UTIL.FUN_BRIGADA_ABREVIATURA(NBRIGADA_CODIGO) NBRIGADA_CODIGO,\n"
            + "       UTIL.FUN_MESES_ABREVIATURA(CMES_CODIGO) CMES_CODIGO,\n"
            + "       UTIL.FUN_TIPO_ASIGNACION_ABREVIATUR(NTIPO_ASIGNACION_CODIGO) NTIPO_ASIGNACION_CODIGO,\n"
            + "       UTIL.FUN_TIPO_COMBUSTIBLE_ABREVIATU(NTIPO_COMBUSTIBLE_CODIGO) NTIPO_COMBUSTIBLE_CODIGO,\n"
            + "       NASIGNACION_CANTIDAD,\n"
            + "       NASIGNACION_SOLICITADO,\n"
            + "       CESTADO_CODIGO,\n"
            + "       NBRIGADA_CODIGO VUSUARIO_CREADOR,\n"
            + "       CMES_CODIGO DUSUARIO_CREADOR,\n"
            + "       NTIPO_ASIGNACION_CODIGO VUSUARIO_CODIGO,\n"
            + "       NTIPO_COMBUSTIBLE_CODIGO DUSUARIO_FECHA\n"
            + "  FROM SINTE_ASIGNACION_COMBUSTIBLE\n"
            + " WHERE CPERIODO_CODIGO =?1\n"
            + "   AND NBRIGADA_CODIGO =?2\n"
            + "   AND CMES_CODIGO =?3\n"
            + "   AND NTIPO_ASIGNACION_CODIGO =?4")
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
