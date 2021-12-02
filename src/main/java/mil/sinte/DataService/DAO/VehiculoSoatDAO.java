package mil.sinte.DataService.DAO;

import java.sql.Date;
import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanVehiculoSoat;
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
public interface VehiculoSoatDAO extends JpaRepository<BeanVehiculoSoat, Integer> {

    @Query(nativeQuery = true, value = "SELECT NVEHICULO_SOAT_CODIGO, NSOAT_ASEGURADORA_CODIGO NVEHICULO_CODIGO, "
            + "UTIL.FUN_SOAT_ASEGURADO(NSOAT_ASEGURADORA_CODIGO) NSOAT_ASEGURADORA_CODIGO, "
            + "VVEHICULO_SOAT_CERTIFICADO, DVEHICULO_SOAT_INICIO, DVEHICULO_SOAT_FIN, CVEHICULO_SOAT_TIPO, "
            + "UTIL.FUN_ESTADO_DESCRIPCION(CESTADO_CODIGO) CESTADO_CODIGO "
            + "FROM SINTE_VEHICULOS_SOAT WHERE "
            + "NVEHICULO_CODIGO=?1 "
            + "ORDER BY NVEHICULO_SOAT_CODIGO")
    List<BeanVehiculoSoat> findByVehiculo(Integer vehiculo);

    @Transactional
    @Modifying
    @Query(value = "{CALL SP_IDU_VEHICULO_SOAT(:vehiculo, :codigo, :aseguradora, :tipo, :certificado, :inicio, :fin, :usuario, :modo)}", nativeQuery = true)
    void sp_vehiculo_soat(
            @Param("vehiculo") Integer vehiculo,
            @Param("codigo") Integer codigo,
            @Param("aseguradora") Integer aseguradora,
            @Param("tipo") String tipo,
            @Param("certificado") String certificado,
            @Param("inicio") Date inicio,
            @Param("fin") Date fin,
            @Param("usuario") String usuario,
            @Param("modo") String modo);

}
