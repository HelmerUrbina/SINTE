package mil.sinte.BusinessServices.Beans;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
@Entity
@Table(name = "SINTE_BRIGADAS_CHOFER")
@Data
public class BeanBrigadasChofer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "NBRIGADA_CODIGO", nullable = false)
    private Integer brigada;

    @Column(name = "CPERSONAL_CIP", nullable = false)
    private String cip;

    @Column(name = "PERSONAL", nullable = false)
    private String personal;

    @Column(name = "GRADO", nullable = false)
    private String grado;

    @Column(name = "DBRIGADA_CHOFER_INGRESO", nullable = false)
    private Date fechaIngreso;

    @Column(name = "DBRIGADA_CHOFER_FIN")
    private Date fechaFin;

    @Column(name = "CESTADO_CODIGO")
    private String estado;
}
