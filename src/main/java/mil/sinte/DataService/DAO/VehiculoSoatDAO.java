/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.sinte.DataService.DAO;

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
            + "VVEHICULO_SOAT_CERTIFICADO, TO_CHAR(DVEHICULO_SOAT_INICIO, 'YYYY/MM/DD') DVEHICULO_SOAT_INICIO, "
            + "TO_CHAR(DVEHICULO_SOAT_FIN, 'YYYY/MM/DD') DVEHICULO_SOAT_FIN, "
            + "CVEHICULO_SOAT_TIPO, "
            + "UTIL.FUN_ESTADO_DESCRIPCION(CESTADO_CODIGO) CESTADO_CODIGO "
            + "FROM SINTE_VEHICULOS_SOAT WHERE "
            + "NVEHICULO_CODIGO=?1 "
            + "ORDER BY NVEHICULO_SOAT_CODIGO")
    List<BeanVehiculoSoat> findByVehiculo(Integer vehiculo);

    @Query(nativeQuery = true, value = "SELECT NVEHICULO_SOAT_CODIGO, "
            + "NSOAT_ASEGURADORA_CODIGO NVEHICULO_CODIGO, "
            + "UTIL.FUN_SOAT_ASEGURADO(NSOAT_ASEGURADORA_CODIGO) NSOAT_ASEGURADORA_CODIGO, "
            + "VVEHICULO_SOAT_CERTIFICADO, "
            + "TO_CHAR(DVEHICULO_SOAT_INICIO, 'YYYY/MM/DD') DVEHICULO_SOAT_INICIO, "
            + "TO_CHAR(DVEHICULO_SOAT_FIN, 'YYYY/MM/DD') DVEHICULO_SOAT_FIN, "
            + "CVEHICULO_SOAT_TIPO, UTIL.FUN_ESTADO_DESCRIPCION(CESTADO_CODIGO) CESTADO_CODIGO "
            + "FROM SINTE_VEHICULOS_SOAT WHERE "
            + "NVEHICULO_CODIGO=?1 AND "
            + "NSOAT_ASEGURADORA_CODIGO=?2")
    public BeanVehiculoSoat findByCodigo(Integer vehiculo, Integer codigo);

    @Transactional
    @Modifying
    @Query(value = "{CALL SP_IDU_VEHICULO_SOAT(:codigo, :vehiculo, :soat, :certificado, :inicio, :fin, :tipo, :usuario, :modo)}", nativeQuery = true)
    void sp_vehiculo_soat(
            @Param("codigo") int codigo,
            @Param("vehiculo") int vehiculo,
            @Param("soat") int soat,
            @Param("certificado") String certificado,
            @Param("inicio") String inicio,
            @Param("fin") String fin,
            @Param("tipo") String tipo,
            @Param("usuario") String usuario,
            @Param("modo") String modo);

}
