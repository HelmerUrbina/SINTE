/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.sinte.DataService.DAO;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanSoatAseguradora;
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
public interface SoatAseguradoraDAO extends JpaRepository<BeanSoatAseguradora, String>{
    
    @Query(nativeQuery = true, value =  "SELECT NSOAT_ASEGURADORA_CODIGO,\n" +
                                        "       VSOAT_ASEGURADORA_NOMBRE,\n" +
                                        "       VSOAT_ASEGURADORA_TELEFONO,\n" +
                                        "       VSOAT_ASEGURADORA_DIRECCION,\n" +
                                        "       UTIL.FUN_ESTADO_DESCRIPCION(CESTADO_CODIGO) CESTADO_CODIGO\n" +
                                        "  FROM SINTE_SOAT_ASEGURADORA\n" +
                                        " ORDER BY NSOAT_ASEGURADORA_CODIGO")
    @Override
    List<BeanSoatAseguradora> findAll();
    
    @Query(nativeQuery = true, value =  "SELECT NSOAT_ASEGURADORA_CODIGO,\n" +
                                        "       VSOAT_ASEGURADORA_NOMBRE,\n" +
                                        "       VSOAT_ASEGURADORA_TELEFONO,\n" +
                                        "       VSOAT_ASEGURADORA_DIRECCION,\n" +
                                        "       UTIL.FUN_ESTADO_DESCRIPCION(CESTADO_CODIGO) CESTADO_CODIGO\n" +
                                        "  FROM SINTE_SOAT_ASEGURADORA\n" +
                                        " WHERE NSOAT_ASEGURADORA_CODIGO =?1")
    BeanSoatAseguradora findByCodigo(Integer codigo);
    
    
    @Transactional
    @Modifying
    @Query(value = "{CALL SP_IDU_SOAT_ASEGURADORA(:codigo, :nombre, :telefono, :direccion, :usuario, :modo)}", nativeQuery = true)
    void sp_soat_aseguradora(
            @Param("codigo") int codigo,
            @Param("nombre") String nombre,
            @Param("telefono") String telefono,
            @Param("direccion") String direccion,
            @Param("usuario") String usuario,
            @Param("modo") String modo);
}
