package mil.sinte.DataService.DAO;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanVehiculos;
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
public interface VehiculoDAO extends JpaRepository<BeanVehiculos, String> {

    @Query(nativeQuery = true, value = "SELECT NVEHICULO_CODIGO, VVEHICULO_PLACA, VVEHICULO_SERIE_CHASIS, "
            + "VVEHICULO_SERIE_MOTOR, UTIL.FUN_TIPO_VEHICULO(NVEHICULO_TIPO_CODIGO) VEHICULO_TIPO, "
            + "UTIL.FUN_CLASE_VEHICULO(NVEHICULO_CLASE_CODIGO) VEHICULO_CLASE, "
            + "UTIL.FUN_MARCAS(NMARCA_CODIGO) MARCA, "
            + "UTIL.FUN_MARCAS_MODELO(NMARCA_CODIGO,NMARCA_MODELO_CODIGO) MODELO, "
            + "CVEHICULO_TRANSMISION, CVEHICULO_FABRICACION, NVEHICULO_PUERTAS, "
            + "UTIL.FUN_COLORES(NCOLOR_CODIGO) COLOR, UTIL.FUN_BRIGADA_VEHICULO(NVEHICULO_CODIGO) BRIGADA, "
            + "UTIL.FUN_ESTADO_DESCRIPCION(CESTADO_CODIGO) CESTADO_CODIGO "
            + "FROM SINTE_VEHICULOS "
            + "ORDER BY NVEHICULO_CODIGO")
    @Override
    List<BeanVehiculos> findAll();

    @Query(nativeQuery = true, value = "SELECT NVEHICULO_CODIGO, VVEHICULO_PLACA, VVEHICULO_SERIE_CHASIS, "
            + "VVEHICULO_SERIE_MOTOR, ''||NVEHICULO_TIPO_CODIGO VEHICULO_TIPO, "
            + "''||NVEHICULO_CLASE_CODIGO VEHICULO_CLASE, ''||NMARCA_CODIGO MARCA, "
            + "''||NMARCA_CODIGO,NMARCA_MODELO_CODIGO MODELO, CVEHICULO_TRANSMISION, '' BRIGADA,"
            + "CVEHICULO_FABRICACION, NVEHICULO_PUERTAS, ''||NCOLOR_CODIGO COLOR, CESTADO_CODIGO "
            + "FROM SINTE_VEHICULOS WHERE "
            + "NVEHICULO_CODIGO=?1")
    public BeanVehiculos findByCodigo(Integer codigo);

    @Transactional
    @Modifying
    @Query(value = "{CALL SP_IDU_VEHICULO(:codigo, :placa, :serieChasis, :serieMotor, :tipoVehiculo, "
            + ":claseVehiculo, :marca, :modelo, :transmision, :fabricacion, :puertas, :color, :usuario, :modo)}", nativeQuery = true)
    void sp_vehiculo(
            @Param("codigo") Integer codigo,
            @Param("placa") String placa,
            @Param("serieChasis") String abreviatura,
            @Param("serieMotor") String serieMotor,
            @Param("tipoVehiculo") Integer tipoVehiculo,
            @Param("claseVehiculo") Integer claseVehiculo,
            @Param("marca") Integer marca,
            @Param("modelo") Integer modelo,
            @Param("transmision") String transmision,
            @Param("fabricacion") String fabricacion,
            @Param("puertas") Integer puertas,
            @Param("color") Integer color,
            @Param("usuario") String usuario,
            @Param("modo") String modo);

}
