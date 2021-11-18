/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.sinte.DataService.DAO;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanModelos;
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
public interface ModelosDAO extends JpaRepository<BeanModelos, String> {

    @Query(nativeQuery = true, value = "SELECT NMARCA_MODELO_CODIGO||','||NMARCA_CODIGO NMARCA_MODELO_CODIGO, "
            + "UTIL.FUN_MARCAS(NMARCA_CODIGO) NMARCA_CODIGO, VMARCA_MODELO_DESCRIPCION, "
            + "UTIL.FUN_ESTADO_DESCRIPCION(CESTADO_CODIGO) CESTADO_CODIGO "
            + "FROM SINTE_MARCAS_MODELOS "
            + "ORDER BY NMARCA_CODIGO")
    @Override
    List<BeanModelos> findAll();

    @Query(nativeQuery = true, value = "SELECT NMARCA_MODELO_CODIGO, "
            + "NMARCA_CODIGO NMARCA_CODIGO, VMARCA_MODELO_DESCRIPCION, CESTADO_CODIGO "
            + "FROM SINTE_MARCAS_MODELOS WHERE "
            + "NMARCA_MODELO_CODIGO||','||NMARCA_CODIGO=?1")
    BeanModelos findByCodigo(String codigo);

    @Transactional
    @Modifying
    @Query(value = "{CALL SP_IDU_MODELOS(:codigo, :marca, :nombre, :usuario, :modo)}", nativeQuery = true)
    void sp_modelos(
            @Param("codigo") int codigo,
            @Param("marca") int marca,
            @Param("nombre") String nombre,
            @Param("usuario") String usuario,
            @Param("modo") String modo);

}
