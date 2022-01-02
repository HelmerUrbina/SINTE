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
            + "CPERIODO_CODIGO, NTIPO_ASIGNACION_CODIGO, NTIPO_COMBUSTIBLE_CODIGO, NBRIGADA_CODIGO, "
            + "UTIL.FUN_BRIGADA_ABREVIATURA(NBRIGADA_CODIGO) AS VBRIGADA_ABREVIATURA, "
            + "NPROGRAMACION_TECHOS_PRECIO, NPROGRAMACION_TECHOS_CANTIDAD, "
            + "(NPROGRAMACION_TECHOS_PRECIO*NPROGRAMACION_TECHOS_CANTIDAD) NPROGRAMACION_TECHOS_IMPORTE, "
            + "UTIL.FUN_ESTADO_DESCRIPCION(CESTADO_CODIGO) CESTADO_CODIGO "
            + "FROM SINTE_PROG_CLASE_III_TECHOS WHERE "
            + "CPERIODO_CODIGO=?1 AND "
            + "NTIPO_ASIGNACION_CODIGO=?2 AND "
            + "NTIPO_COMBUSTIBLE_CODIGO=?3 "
            + "ORDER BY VBRIGADA_ABREVIATURA")
    List<BeanProgramacionClaseIIITechos> findByPeriodoAndTipoAsignacionAndTipoCombustible(String periodo, Integer tipoAsignacion, Integer tipoCombustible);

    @Transactional
    @Modifying
    @Query(value = "{CALL SP_IDU_PROG_CLASE_III_TECHOS(:periodo, :tipoAsignacion, :tipoCombustible, :brigada, :precio, :cantidad, :usuario, :modo)}", nativeQuery = true)
    void sp_programacionClaseIIITechos(
            @Param("periodo") String periodo,
            @Param("tipoAsignacion") Integer tipoAsignacion,
            @Param("tipoCombustible") Integer tipoCombustible,
            @Param("brigada") Integer brigada,
            @Param("precio") Double precio,
            @Param("cantidad") Double cantidad,
            @Param("usuario") String usuario,
            @Param("modo") String modo);
}
