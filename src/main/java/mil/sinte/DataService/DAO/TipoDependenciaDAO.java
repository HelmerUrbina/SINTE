package mil.sinte.DataService.DAO;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanTipoDependencia;
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
public interface TipoDependenciaDAO extends JpaRepository<BeanTipoDependencia, String> {

    @Query(nativeQuery = true, value = "SELECT NTIPO_DEPENDENCIA_CODIGO, "
            + "VTIPO_DEPENDENCIA_DESCRIPCION, VTIPO_DEPENDENCIA_ABREVIATURA, "
            + "UTIL.FUN_ESTADO_DESCRIPCION(CESTADO_CODIGO) CESTADO_CODIGO "
            + "FROM SINTE_TIPO_DEPENDENCIA "
            + "ORDER BY NTIPO_DEPENDENCIA_CODIGO")
    @Override
    List<BeanTipoDependencia> findAll();

    public BeanTipoDependencia findByCodigo(Integer codigo);

    @Transactional
    @Modifying
    @Query(value = "{CALL SP_IDU_TIPO_DEPENDENCIA(:codigo, :descripcion, :abreviatura, :usuario, :modo)}", nativeQuery = true)
    void sp_tipoDependencia(
            @Param("codigo") Integer codigo,
            @Param("descripcion") String descripcion,
            @Param("abreviatura") String abreviatura,
            @Param("usuario") String usuario,
            @Param("modo") String modo);

}
