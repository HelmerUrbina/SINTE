package mil.sinte.DataService.DAO;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanTipoOperacion;
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
public interface TipoOperacionDAO extends JpaRepository<BeanTipoOperacion, Integer> {

    @Query(nativeQuery = true, value = "SELECT NTIPO_OPERACION_CODIGO, "
            + "VTIPO_OPERACION_DESCRIPCION, VTIPO_OPERACION_ABREVIATURA, "
            + "UTIL.FUN_ESTADO_DESCRIPCION(CESTADO_CODIGO) CESTADO_CODIGO "
            + "FROM SINTE_TIPO_OPERACION  "
            + "ORDER BY NTIPO_OPERACION_CODIGO")
    @Override
    List<BeanTipoOperacion> findAll();

    @Transactional
    @Modifying
    @Query(value = "{CALL SP_IDU_TIPO_OPERACION(:codigo, :descripcion, :abreviatura, :usuario, :modo)}", nativeQuery = true)
    void sp_tipoOperacion(
            @Param("codigo") Integer codigo,
            @Param("descripcion") String descripcion,
            @Param("abreviatura") String abreviatura,
            @Param("usuario") String usuario,
            @Param("modo") String modo);
}
