package mil.sinte.DataService.DAO;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanVehiculoTipoCombustible;
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
public interface VehiculoTipoCombustibleDAO extends JpaRepository<BeanVehiculoTipoCombustible, String> {

    @Query(nativeQuery = true, value = "SELECT UTIL.FUN_TIPO_COMBUSTIBLE(NTIPO_COMBUSTIBLE_CODIGO) NVEHICULO_CODIGO, "
            + "NTIPO_COMBUSTIBLE_CODIGO NTIPO_COMBUSTIBLE_CODIGO, NVEHICULO_COMBUSTIBLE_CAP, "
            + "UTIL.FUN_ESTADO_DESCRIPCION(CESTADO_CODIGO) CESTADO_CODIGO "
            + "FROM SINTE_VEHICULOS_TIPO_COMBUSTIB WHERE "
            + "NVEHICULO_CODIGO=?1 "
            + "ORDER BY NTIPO_COMBUSTIBLE_CODIGO")
    List<BeanVehiculoTipoCombustible> findByVehiculo(Integer vehiculo);

    @Query(nativeQuery = true, value = " SELECT "
            + "''||NTIPO_COMBUSTIBLE_CODIGO NVEHICULO_CODIGO,"
            + "''||NTIPO_COMBUSTIBLE_CODIGO NTIPO_COMBUSTIBLE_CODIGO, "
            + "NVEHICULO_COMBUSTIBLE_CAP, "
            + "UTIL.FUN_ESTADO_DESCRIPCION(CESTADO_CODIGO) CESTADO_CODIGO FROM "
            + "SINTE_VEHICULOS_TIPO_COMBUSTIB WHERE "
            + "NVEHICULO_CODIGO=?1 AND "
            + "NTIPO_COMBUSTIBLE_CODIGO=?2")
    public BeanVehiculoTipoCombustible findByCodigo(Integer vehiculo, Integer codigo);

    @Transactional
    @Modifying
    @Query(value = "{CALL SP_IDU_VEHICULO_TIPO_COMBUSTIB(:vehiculo, :tipoCombustible, :capacidad,:usuario,:modo)}", nativeQuery = true)
    void sp_vehiculo_tipo_combustible(
            @Param("vehiculo") Integer vehiculo,
            @Param("tipoCombustible") Integer tipoCombustible,
            @Param("capacidad") Double capacidad,
            @Param("usuario") String usuario,
            @Param("modo") String modo);
}
