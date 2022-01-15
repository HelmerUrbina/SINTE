package mil.sinte.BusinessServices.Beans;

import java.io.Serializable;
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
@Table(name = "SINTE_DESPACHO_COMBUSTIBLE")
@Data
public class BeanGrifoDespacho implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "PERIODO")
    private String periodo;

    @Column(name = "MES")
    private String mes;

    @Column(name = "TIPO_ASIGNACION")
    private String tipoAsignacion;

    @Column(name = "DIVISION")
    private String division;

    @Column(name = "BRIGADA")
    private String brigada;

    @Column(name = "UNIDAD")
    private String unidad;

    @Column(name = "TIPO_COMBUSTIBLE")
    private String tipoCombustible;

    @Column(name = "CANTIDAD")
    private Double cantidad;

    @Column(name = "GRIFO")
    private String grifo;

    @Id
    @Column(name = "FECHA")
    private String fecha;

}
