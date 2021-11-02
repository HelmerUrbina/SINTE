package mil.sinte.DataService.DAO;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanTipoCombustible;
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
public interface TipoCombustibleDAO extends JpaRepository<BeanTipoCombustible, Integer> {

    @Query(nativeQuery = true, value = "SELECT "
            + "a.NTIPO_COMBUSTIBLE_CODIGO, a.VTIPO_COMBUSTIBLE_DESCRIPCION, "
            + "a.VTIPO_COMBUSTIBLE_ABREVIATURA , "
            + "UTIL.FUN_ESTADO_DESCRIPCION(a.CESTADO_CODIGO) CESTADO_CODIGO "
            + "FROM SINTE_TIPO_COMBUSTIBLE a "
            + "ORDER BY a.NTIPO_COMBUSTIBLE_CODIGO")
    @Override
    List<BeanTipoCombustible> findAll();

    public BeanTipoCombustible findByCodigo(Integer codigo);

    @Transactional
    @Modifying
    @Query(value = "{CALL SP_IDU_TIPO_COMBUSTIBLE(:codigo, :descripcion, :abreviatura, :usuario, :modo)}", nativeQuery = true)
    void sp_tipoCombustible(
            @Param("codigo") int codigo,
            @Param("descripcion") String descripcion,
            @Param("abreviatura") String abreviatura,
            @Param("usuario") String usuario,
            @Param("modo") String modo);
}
