package mil.sinte.DataService.DAO;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanAreaLaboral;
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
public interface AreaLaboralDAO extends JpaRepository<BeanAreaLaboral, String> {

    @Query(nativeQuery = true, value = "SELECT "
            + "a.NAREA_LABORAL_CODIGO, a.VAREA_LABORAL_DESCRIPCION, "
            + "a.VAREA_LABORAL_ABREVIATURA , "
            + "UTIL.FUN_ESTADO_DESCRIPCION(a.CESTADO_CODIGO) CESTADO_CODIGO "
            + "FROM SINTE_AREA_LABORAL a "
            + "ORDER BY a.NAREA_LABORAL_CODIGO")
    @Override
    List<BeanAreaLaboral> findAll();

    public BeanAreaLaboral findByCodigo(Integer codigo);

    @Transactional
    @Modifying
    @Query(value = "{CALL SP_IDU_AREA_LABORAL(:codigo, :descripcion, :abreviatura, :usuario, :modo)}", nativeQuery = true)
    void sp_areaLaboral(
            @Param("codigo") int codigo,
            @Param("descripcion") String descripcion,
            @Param("abreviatura") String abreviatura,
            @Param("usuario") String usuario,
            @Param("modo") String modo);

}
