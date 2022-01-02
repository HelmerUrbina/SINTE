/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.sinte.DataService.DAO;

import java.sql.Date;
import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanUsuarioGrifo;
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
public interface UsuarioGrifoDAO extends JpaRepository<BeanUsuarioGrifo, String>{
    
    @Query(nativeQuery = true, value =  "SELECT VUSUARIO_CODIGO USUARIO,\n" +
                                        "       NGRIFO_CODIGO,\n" +
                                        "       CPERIODO_CODIGO,\n" +
                                        "       UTIL.FUN_ESTADO_DESCRIPCION(CESTADO_CODIGO) ESTADO\n" +
                                        "  FROM SINTE_USUARIO_GRIFO\n" +
                                        " WHERE NGRIFO_CODIGO = ?1\n" +
                                        "   AND CPERIODO_CODIGO = ?2\n" +
                                        " ORDER BY USUARIO")
    List<BeanUsuarioGrifo> findAll(Integer grifo, String periodo);  
    
    @Transactional
    @Modifying
    @Query(value = "{CALL SP_IDU_USUARIO_GRIFO(:codigoU, :grifo, :periodo, :usuario, :modo)}", nativeQuery = true)
    void sp_usuario_grifo(
            @Param("codigoU") String codigoU,
            @Param("grifo") Integer grifo,
            @Param("periodo") String periodo,
            @Param("usuario") String usuario,
            @Param("modo") String modo);
    
}
