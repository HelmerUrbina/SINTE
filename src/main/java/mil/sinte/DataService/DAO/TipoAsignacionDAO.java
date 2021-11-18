package mil.sinte.DataService.DAO;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanTipoAsignacion;
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
public interface TipoAsignacionDAO extends JpaRepository<BeanTipoAsignacion, String> {

    @Query(nativeQuery = true, value = "SELECT NTIPO_ASIGNACION_CODIGO, "
            + "VTIPO_ASIGNACION_DESCRIPCION, VTIPO_ASIGNACION_ABREVIATURA, "
            + "UTIL.FUN_ESTADO_DESCRIPCION(CESTADO_CODIGO) CESTADO_CODIGO "
            + "FROM SINTE_TIPO_ASIGNACION "
            + "ORDER BY NTIPO_ASIGNACION_CODIGO")
    @Override
    List<BeanTipoAsignacion> findAll();

    public BeanTipoAsignacion findByCodigo(Integer codigo);

    @Transactional
    @Modifying
    @Query(value = "{CALL SP_IDU_TIPO_ASIGNACION(:codigo, :descripcion, :abreviatura, :usuario, :modo)}", nativeQuery = true)
    void sp_tipoAsignacion(
            @Param("codigo") int codigo,
            @Param("descripcion") String descripcion,
            @Param("abreviatura") String abreviatura,
            @Param("usuario") String usuario,
            @Param("modo") String modo);

}
