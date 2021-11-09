/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public interface VehiculoDAO extends JpaRepository<BeanVehiculos, String>{
    
    @Query(nativeQuery = true, value =  "SELECT NVEHICULO_CODIGO,\n" +
                                        "       VVEHICULO_PLACA,\n" +
                                        "       VVEHICULO_SERIE_CHASIS,\n" +
                                        "       VVEHICULO_SERIE_MOTOR,\n" +
                                        "       UTIL.FUN_TIPO_VEHICULO(NVEHICULO_TIPO_CODIGO) VEHICULO_TIPO,\n" +
                                        "       UTIL.FUN_CLASE_VEHICULO(NVEHICULO_CLASE_CODIGO) VEHICULO_CLASE,\n" +
                                        "       UTIL.FUN_MARCAS(NMARCA_CODIGO) MARCA,\n" +
                                        "       UTIL.FUN_MARCAS_MODELO(NMARCA_CODIGO,NMARCA_MODELO_CODIGO) MODELO,\n" +
                                        "       CVEHICULO_TRANSMISION,\n" +
                                        "       CVEHICULO_FABRICACION,\n" +
                                        "       NVEHICULO_PUERTAS,\n" +
                                        "       UTIL.FUN_COLORES(NCOLOR_CODIGO) COLOR,\n" +
                                        "       UTIL.FUN_ESTADO_DESCRIPCION(CESTADO_CODIGO) CESTADO_CODIGO\n" +
                                        "  FROM SINTE_VEHICULOS\n" +
                                        " ORDER BY NVEHICULO_CODIGO")
    @Override
    List<BeanVehiculos> findAll();
    
    @Query(nativeQuery = true, value =  "SELECT NVEHICULO_CODIGO,\n" +
                                        "       VVEHICULO_PLACA,\n" +
                                        "       VVEHICULO_SERIE_CHASIS,\n" +
                                        "       VVEHICULO_SERIE_MOTOR,\n" +
                                        "       ''||NVEHICULO_TIPO_CODIGO VEHICULO_TIPO,\n" +
                                        "       ''||NVEHICULO_CLASE_CODIGO VEHICULO_CLASE,\n" +
                                        "       ''||NMARCA_CODIGO MARCA,\n" +
                                        "       ''||NMARCA_CODIGO,NMARCA_MODELO_CODIGO MODELO,\n" +
                                        "       CVEHICULO_TRANSMISION,\n" +
                                        "       CVEHICULO_FABRICACION,\n" +
                                        "       NVEHICULO_PUERTAS,\n" +
                                        "       ''||NCOLOR_CODIGO COLOR,\n" +
                                        "       UTIL.FUN_ESTADO_DESCRIPCION(CESTADO_CODIGO) CESTADO_CODIGO\n" +
                                        "  FROM SINTE_VEHICULOS\n" +
                                        " WHERE NVEHICULO_CODIGO =?1")
    public BeanVehiculos findByCodigo(Integer codigo);
    
    @Transactional
    @Modifying
    @Query(value = "{CALL SP_IDU_VEHICULO(:codigo, :placa, :serieChasis, :serieMotor, :tipoVehiculo,"
            + ":claseVehiculo,:marca,:modelo,:transmision,:fabricacion,:puertas,:color,:usuario,:modo)}", nativeQuery = true)
    void sp_vehiculo(
            @Param("codigo") int codigo,
            @Param("placa") String placa,
            @Param("serieChasis") String abreviatura,
            @Param("serieMotor") String serieMotor,
            @Param("tipoVehiculo") int tipoVehiculo,
            @Param("claseVehiculo") int claseVehiculo,
            @Param("marca") int marca,
            @Param("modelo") int modelo,
            @Param("transmision") String transmision,
            @Param("fabricacion") String fabricacion,
            @Param("puertas") int puertas,
            @Param("color") int color,
            @Param("usuario") String usuario,
            @Param("modo") String modo);
    
}
