package mil.sinte.DataService.DAO;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanProgramacionClaseIIITechos;
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
public interface ProgramacionClaseIIITechosDAO extends JpaRepository<BeanProgramacionClaseIIITechos, String> {

    @Query(nativeQuery = true, value = "SELECT "
            + "CPERIODO_CODIGO, NTIPO_ASIGNACION_CODIGO, NBRIGADA_CODIGO, "
            + "UTIL.FUN_BRIGADA_ABREVIATURA(NBRIGADA_CODIGO) AS VBRIGADA_ABREVIATURA, "
            + "NPROGRAMACION_CLASE_III_IMPORT, "
            + "UTIL.FUN_ESTADO_DESCRIPCION(CESTADO_CODIGO) CESTADO_CODIGO "
            + "FROM SINTE_PROG_CLASE_III_TECHOS WHERE "
            + "CPERIODO_CODIGO=?1 AND "
            + "NTIPO_ASIGNACION_CODIGO=?2 "
            + "ORDER BY NTIPO_ASIGNACION_CODIGO")
    List<BeanProgramacionClaseIIITechos> findByPeriodoTipoAsignacion(String periodo, String tipoAsignacion);

    @Transactional
    @Modifying
    @Query(value = "{CALL SP_IDU_PROG_CLASE_III_TECHOS(:periodo, :tipoAsignacion, :brigada, :importe, :usuario, :modo)}", nativeQuery = true)
    void sp_programacionClaseIIITechos(
            @Param("periodo") String periodo,
            @Param("tipoAsignacion") Integer tipoAsignacion,
            @Param("brigada") Integer brigada,
            @Param("importe") Double importe,
            @Param("usuario") String usuario,
            @Param("modo") String modo);
}
