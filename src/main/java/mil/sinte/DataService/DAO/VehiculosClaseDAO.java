package mil.sinte.DataService.DAO;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanVehiculosClase;
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
public interface VehiculosClaseDAO extends JpaRepository<BeanVehiculosClase, String> {

    @Query(nativeQuery = true, value = "SELECT NVEHICULO_CLASE_CODIGO, "
            + "VVEHICULO_CLASE_DESCRIPCION, VVEHICULO_CLASE_ABREVIATURA, "
            + "UTIL.FUN_ESTADO_DESCRIPCION(CESTADO_CODIGO) CESTADO_CODIGO "
            + "FROM SINTE_VEHICULO_CLASE "
            + "ORDER BY NVEHICULO_CLASE_CODIGO")
    @Override
    List<BeanVehiculosClase> findAll();

    @Query(nativeQuery = true, value = "SELECT NVEHICULO_CLASE_CODIGO, "
            + "VVEHICULO_CLASE_DESCRIPCION, VVEHICULO_CLASE_ABREVIATURA, CESTADO_CODIGO "
            + "FROM SINTE_VEHICULO_CLASE WHERE "
            + "NVEHICULO_CLASE_CODIGO=?1")
    BeanVehiculosClase findByCodigo(Integer codigo);

    @Transactional
    @Modifying
    @Query(value = "{CALL SP_IDU_VEHICULO_CLASE(:codigo, :descripcion, :abreviatura, :usuario, :modo)}", nativeQuery = true)
    void sp_vehiculo_clase(
            @Param("codigo") int codigo,
            @Param("descripcion") String descripcion,
            @Param("abreviatura") String abreviatura,
            @Param("usuario") String usuario,
            @Param("modo") String modo);

}
