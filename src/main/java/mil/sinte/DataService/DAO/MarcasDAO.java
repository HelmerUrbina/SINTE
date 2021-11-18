/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.sinte.DataService.DAO;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanMarcas;
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
public interface MarcasDAO extends JpaRepository<BeanMarcas, String>{
    
    @Query(nativeQuery = true, value =  "SELECT NMARCA_CODIGO,\n" +
                                        "       VMARCA_NOMBRE,\n" +
                                        "       UTIL.FUN_ESTADO_DESCRIPCION(CESTADO_CODIGO) CESTADO_CODIGO\n" +
                                        "  FROM SINTE_MARCAS\n" +
                                        " ORDER BY NMARCA_CODIGO")
    @Override
    List<BeanMarcas> findAll();
    
    @Query(nativeQuery = true, value =  "SELECT NMARCA_CODIGO,\n" +
                                        "       VMARCA_NOMBRE,\n" +
                                        "       '' CESTADO_CODIGO\n" +
                                        "  FROM SINTE_MARCAS\n" +
                                        " WHERE NMARCA_CODIGO =?1")
    BeanMarcas findByCodigo(Integer codigo);
    
    
    @Transactional
    @Modifying
    @Query(value = "{CALL SP_IDU_MARCAS(:codigo, :nombre, :usuario, :modo)}", nativeQuery = true)
    void sp_marcas(
            @Param("codigo") int codigo,
            @Param("nombre") String nombre,
            @Param("usuario") String usuario,
            @Param("modo") String modo);
}
