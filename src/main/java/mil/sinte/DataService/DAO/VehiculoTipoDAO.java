package mil.sinte.DataService.DAO;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanVehiculoTipo;
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
public interface VehiculoTipoDAO extends JpaRepository<BeanVehiculoTipo, String> {

    @Query(nativeQuery = true, value = "SELECT NVEHICULO_TIPO_CODIGO, "
            + "VVEHICULO_TIPO_DESCRIPCION, VVEHICULO_TIPO_ABREVIATURA, "
            + "UTIL.FUN_ESTADO_DESCRIPCION(CESTADO_CODIGO) CESTADO_CODIGO "
            + "FROM SINTE_VEHICULO_TIPO "
            + "ORDER BY NVEHICULO_TIPO_CODIGO")
    @Override
    List<BeanVehiculoTipo> findAll();

    @Query(nativeQuery = true, value = "SELECT NVEHICULO_TIPO_CODIGO, "
            + "VVEHICULO_TIPO_DESCRIPCION, VVEHICULO_TIPO_ABREVIATURA, CESTADO_CODIGO "
            + "FROM SINTE_VEHICULO_TIPO WHERE "
            + "NVEHICULO_TIPO_CODIGO =?1 ")
    BeanVehiculoTipo findByCodigo(Integer codigo);

    @Transactional
    @Modifying
    @Query(value = "{CALL SP_IDU_VEHICULO_TIPO(:codigo, :descripcion, :abreviatura, :usuario, :modo)}", nativeQuery = true)
    void sp_vehiculo_tipo(
            @Param("codigo") int codigo,
            @Param("descripcion") String descripcion,
            @Param("abreviatura") String abreviatura,
            @Param("usuario") String usuario,
            @Param("modo") String modo);

}
