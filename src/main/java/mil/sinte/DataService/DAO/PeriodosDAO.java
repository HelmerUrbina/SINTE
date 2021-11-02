package mil.sinte.DataService.DAO;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanPeriodos;
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
public interface PeriodosDAO extends JpaRepository<BeanPeriodos, String> {

    @Query(nativeQuery = true, value = "SELECT "
            + "a.CPERIODO_CODIGO, a.VPERIODO_DESCRIPCION, "
            + "a.VPERIODO_ABREVIATURA , "
            + "UTIL.FUN_ESTADO_DESCRIPCION(a.CESTADO_CODIGO) CESTADO_CODIGO "
            + "FROM SINTE_PERIODOS a "
            + "ORDER BY a.CPERIODO_CODIGO")
    @Override
    List<BeanPeriodos> findAll();

    public BeanPeriodos findByCodigo(String codigo);

    @Transactional
    @Modifying
    @Query(value = "{CALL SP_IDU_PERIODOS(:codigo, :descripcion, :abreviatura, :usuario, :modo)}", nativeQuery = true)
    void sp_periodo(
            @Param("codigo") String codigo,
            @Param("descripcion") String descripcion,
            @Param("abreviatura") String abreviatura,
            @Param("usuario") String usuario,
            @Param("modo") String modo);
}
