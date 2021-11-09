/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.sinte.DataService.DAO;

import java.util.Date;
import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanVehiculoSoat;
import mil.sinte.BusinessServices.Beans.BeanVehiculoTipoCombustible;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
public interface VehiculoSoatDAO extends JpaRepository<BeanVehiculoSoat, Integer>{
    
    @Query(nativeQuery = true, value =  "    SELECT NVEHICULO_SOAT_CODIGO,\n" +
                                        "           NSOAT_ASEGURADORA_CODIGO NVEHICULO_CODIGO,\n" +
                                        "           UTIL.FUN_SOAT_ASEGURADO(NSOAT_ASEGURADORA_CODIGO) NSOAT_ASEGURADORA_CODIGO,\n" +
                                        "           VVEHICULO_SOAT_CERTIFICADO,\n" +
                                        "           TO_CHAR(DVEHICULO_SOAT_INICIO, 'YYYY/MM/DD') DVEHICULO_SOAT_INICIO,\n" +
                                        "           TO_CHAR(DVEHICULO_SOAT_FIN, 'YYYY/MM/DD') DVEHICULO_SOAT_FIN,\n" +
                                        "           CVEHICULO_SOAT_TIPO,\n" +
                                        "           UTIL.FUN_ESTADO_DESCRIPCION(CESTADO_CODIGO) CESTADO_CODIGO\n" +
                                        "      FROM SINTE_VEHICULOS_SOAT\n" +
                                        "     WHERE NVEHICULO_CODIGO =?1 \n" +
                                        "     ORDER BY NVEHICULO_SOAT_CODIGO")
    List<BeanVehiculoSoat> findByVehiculo(Integer vehiculo);

    @Query(nativeQuery = true, value =  "    SELECT NVEHICULO_SOAT_CODIGO,\n" +
                                        "           NSOAT_ASEGURADORA_CODIGO NVEHICULO_CODIGO,\n" +
                                        "           UTIL.FUN_SOAT_ASEGURADO(NSOAT_ASEGURADORA_CODIGO) NSOAT_ASEGURADORA_CODIGO,\n" +
                                        "           VVEHICULO_SOAT_CERTIFICADO,\n" +
                                        "           TO_CHAR(DVEHICULO_SOAT_INICIO, 'YYYY/MM/DD') DVEHICULO_SOAT_INICIO,\n" +
                                        "           TO_CHAR(DVEHICULO_SOAT_FIN, 'YYYY/MM/DD') DVEHICULO_SOAT_FIN,\n" +
                                        "           CVEHICULO_SOAT_TIPO,\n" +
                                        "           UTIL.FUN_ESTADO_DESCRIPCION(CESTADO_CODIGO) CESTADO_CODIGO\n" +
                                        "      FROM SINTE_VEHICULOS_SOAT\n" +
                                        "     WHERE NVEHICULO_CODIGO =?1 \n" +
                                        "       AND NSOAT_ASEGURADORA_CODIGO =?2 \n" +
                                        "     ORDER BY NVEHICULO_SOAT_CODIGO")
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
