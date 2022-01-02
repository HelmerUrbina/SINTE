package mil.sinte.DataService.DAO;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanProgramacionCNV;
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
public interface ProgramacionCNVDAO extends JpaRepository<BeanProgramacionCNV, String> {

    @Query(nativeQuery = true, value = "SELECT "
            + "CPERIODO_CODIGO, NTIPO_ASIGNACION_CODIGO, NBRIGADA_CODIGO, NTIPO_COMBUSTIBLE_CODIGO, VEVENTO_PRINCIPAL_CODIGO, "
            + "NEVENTO_FINAL_CODIGO, NDEPENDENCIA_CODIGO||'+++'||NVEHICULO_CODIGO AS CODIGO, "
            + "UTIL.FUN_DEPENDENCIA_ABREVIATURA(NBRIGADA_CODIGO, NDEPENDENCIA_CODIGO) AS NDEPENDENCIA_CODIGO, "
            + "UTIL.FUN_VEHICULO(NVEHICULO_CODIGO) AS NVEHICULO_CODIGO, "
            + "NCNV_CANTIDAD, NCNV_PRECIO, NCNV_DEMANDA_GLOBAL, "
            + "(NCNV_PRECIO*NCNV_CANTIDAD) NCNV_TOTAL, (NCNV_PRECIO*NCNV_DEMANDA_GLOBAL) NCNV_TOTAL_DEMANDA_GLOBAL, "
            + "UTIL.FUN_ESTADO_DESCRIPCION(CESTADO_CODIGO) CESTADO_CODIGO "
            + "FROM SINTE_PROG_CNV WHERE "
            + "CPERIODO_CODIGO=?1 AND "
            + "NTIPO_ASIGNACION_CODIGO=?2 AND "
            + "NBRIGADA_CODIGO=?3 AND "
            + "NTIPO_COMBUSTIBLE_CODIGO=?4 AND "
            + "VEVENTO_PRINCIPAL_CODIGO=?5 AND "
            + "NEVENTO_FINAL_CODIGO=?6 "
            + "ORDER BY NDEPENDENCIA_CODIGO, NVEHICULO_CODIGO")
    List<BeanProgramacionCNV> findByPeriodoTipoAsignacionBrigadaEventoPrincipalEventoFinal(
            String periodo, Integer tipoAsignacion, Integer brigada, Integer tipoCombustible, String eventoPrincipal, Integer eventoFinal);

    @Transactional
    @Modifying
    @Query(value = "{CALL SP_IDU_PROG_CNV(:periodo, :tipoAsignacion, :brigada, :tipoCombustible, :eventoPrincipal, :eventoFinal, :codigo, "
            + ":dependencia, :vehiculo, :cantidad, :precio, :demandaGobal, :usuario, :modo)}", nativeQuery = true)
    void sp_programacionCNV(
            @Param("periodo") String periodo,
            @Param("tipoAsignacion") Integer tipoAsignacion,
            @Param("brigada") Integer brigada,
            @Param("tipoCombustible") String tipoCombustible,
            @Param("eventoPrincipal") String eventoPrincipal,
            @Param("eventoFinal") Integer eventoFinal,
            @Param("codigo") String codigo,
            @Param("dependencia") String dependencia,
            @Param("vehiculo") String vehiculo,
            @Param("cantidad") Double cantidad,
            @Param("precio") Double precio,
            @Param("demandaGobal") Double demandaGobal,
            @Param("usuario") String usuario,
            @Param("modo") String modo);
}
