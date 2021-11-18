/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.sinte.DataService.DAO;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanColores;
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
public interface ColoresDAO extends JpaRepository<BeanColores,String>{
    
    @Query(nativeQuery = true, value =  "SELECT NCOLOR_CODIGO,\n" +
                                        "       VCOLOR_DESCRIPCION,\n" +
                                        "       UTIL.FUN_ESTADO_DESCRIPCION(CESTADO_CODIGO) CESTADO_CODIGO\n" +
                                        "  FROM SINTE_COLORES\n" +
                                        " ORDER BY NCOLOR_CODIGO")
    @Override
    List<BeanColores> findAll();
    
    @Query(nativeQuery = true, value =  "SELECT NCOLOR_CODIGO,\n" +
                                        "       VCOLOR_DESCRIPCION,\n" +
                                        "       CESTADO_CODIGO\n" +
                                        "  FROM SINTE_COLORES\n" +
                                        " WHERE NCOLOR_CODIGO =?1")
    BeanColores findByCodigo(Integer codigo);
    
    
    @Transactional
    @Modifying
    @Query(value = "{CALL SP_IDU_COLORES(:codigo, :nombre, :usuario, :modo)}", nativeQuery = true)
    void sp_colores(
            @Param("codigo") int codigo,
            @Param("nombre") String nombre,
            @Param("usuario") String usuario,
            @Param("modo") String modo);
    
}
