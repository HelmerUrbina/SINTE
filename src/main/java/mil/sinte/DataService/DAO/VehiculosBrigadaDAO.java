/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.sinte.DataService.DAO;

import java.util.List;

import mil.sinte.BusinessServices.Beans.BeanVehiculosBrigada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;



/**
 *
 * @author MERCANTIL GROUP SAC
 */
@Repository
public interface VehiculosBrigadaDAO extends  JpaRepository<BeanVehiculosBrigada, String>{
    
    @Query(nativeQuery = true, value =  "SELECT NVEHICULO_CODIGO NBRIGADA_CODIGO,NDEPENDENCIA_CODIGO CPERIODO_CODIGO,UTIL.FUN_VEHICULO(NVEHICULO_CODIGO) NVEHICULO_CODIGO,\n" +
                                        "       UTIL.FUN_DEPENDENCIA_ABREVIATURA(NBRIGADA_CODIGO,NDEPENDENCIA_CODIGO) NDEPENDENCIA_CODIGO,\n" +
                                        "       TO_CHAR(DVEHICULO_BRIGADA_FECHA, 'YYYY/MM/DD') DVEHICULO_BRIGADA_FECHA,\n" +
                                        "       UTIL.FUN_ESTADO_DESCRIPCION(CESTADO_CODIGO) CESTADO_CODIGO\n" +
                                        "  FROM SINTE_VEHICULOS_BRIGADAS\n" +
                                        " WHERE NBRIGADA_CODIGO =?1 \n" +
                                        "   AND CPERIODO_CODIGO =?2")
    public List<BeanVehiculosBrigada> findAll(Integer brigada, String perido);
    
    
    @Query(nativeQuery = true, value =  "SELECT '' NBRIGADA_CODIGO,''CPERIODO_CODIGO,NVEHICULO_CODIGO,\n" +
                                        "       NDEPENDENCIA_CODIGO,\n" +
                                        "       TO_CHAR(DVEHICULO_BRIGADA_FECHA, 'YYYY/MM/DD') DVEHICULO_BRIGADA_FECHA,\n" +
                                        "       '' CESTADO_CODIGO\n" +
                                        "  FROM SINTE_VEHICULOS_BRIGADAS\n" +
                                        " WHERE NBRIGADA_CODIGO =?1\n" +
                                        "   AND CPERIODO_CODIGO =?2")
    public BeanVehiculosBrigada findByDetalle(Integer brigada, String perido);
    
    @Transactional
    @Modifying
    @Query(value = "{CALL SP_IDU_VEHICULOS_BRIGADA(:periodo, :brigada, :dependencia, :vehiculo, :fecha, :usuario, :modo)}", nativeQuery = true)
    void sp_vehiculos_brigadas(
            @Param("periodo") String periodo,
            @Param("brigada") int brigada,
            @Param("dependencia") int dependencia,
            @Param("vehiculo") int vehiculo,
            @Param("fecha") String fecha,
            @Param("usuario") String usuario,
            @Param("modo") String modo);  
        
}
