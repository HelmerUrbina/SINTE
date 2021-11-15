package mil.sinte.DataService.DAO;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanDependencia;
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
public interface DependenciaDAO extends JpaRepository<BeanDependencia, String> {

    @Query(nativeQuery = true, value = "SELECT "
            + "a.NDEPENDENCIA_CODIGO, a.NTIPO_DEPENDENCIA_CODIGO AS NBRIGADA_CODIGO, "
            + "UTIL.FUN_TIPO_DEPENDENCIA_ABREVIATU(a.NTIPO_DEPENDENCIA_CODIGO) TIPO_DEPENDENCIA,"
            + "a.VDEPENDENCIA_DESCRIPCION, a.VDEPENDENCIA_ABREVIATURA, "
            + "UTIL.FUN_ESTADO_DESCRIPCION(a.CESTADO_CODIGO) CESTADO_CODIGO "
            + "FROM SINTE_DEPENDENCIAS a WHERE "
            + "a.NBRIGADA_CODIGO=?1 "
            + "ORDER BY a.NDEPENDENCIA_CODIGO")
    List<BeanDependencia> findByBrigada(Integer brigada);

    @Query(nativeQuery = true, value = "SELECT "
            + "NDEPENDENCIA_CODIGO, VDEPENDENCIA_DESCRIPCION, a.VDEPENDENCIA_ABREVIATURA, "
            + "UTIL.FUN_ESTADO_DESCRIPCION(a.CESTADO_CODIGO) CESTADO_CODIGO "
            + "FROM SINTE_DEPENDENCIAS a WHERE "
            + "NBRIGADA_CODIGO=?1 AND "
            + "NDEPENDENCIA_CODIGO=?2 ")
    public BeanDependencia findByCodigo(Integer brigada, Integer codigo);

    @Transactional
    @Modifying
    @Query(value = "{CALL SP_IDU_DEPENDENCIA(:codigo, :brigada, :tipoDependencia,"
            + ":descripcion, :abreviatura, :usuario, :modo)}", nativeQuery = true)
    void sp_dependencia(
            @Param("codigo") Integer codigo,
            @Param("brigada") Integer brigada,
            @Param("tipoDependencia") String tipoDependencia,
            @Param("descripcion") String descripcion,
            @Param("abreviatura") String abreviatura,
            @Param("usuario") String usuario,
            @Param("modo") String modo);
}
