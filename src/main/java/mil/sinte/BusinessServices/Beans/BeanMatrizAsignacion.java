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
@Table(name = "SINTE_ASIGNACION_COMBUSTIBLE")
@Data
public class BeanMatrizAsignacion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "BRIGADA", nullable = false)
    private String brigada;

    @Column(name = "NBRIGADA_CODIGO", nullable = false)
    private String brigadaCodigo;

    @Column(name = "ESTADO", nullable = false)
    private String estado;

    @Column(name = "CESTADO_CODIGO", nullable = false)
    private String estadoCodigo;

    @Column(name = "COMBUSTIBLE_1_S", nullable = false)
    private String solicitado1;

    @Column(name = "COMBUSTIBLE_1_C", nullable = false)
    private String cantidad1;

    @Column(name = "COMBUSTIBLE_2_S", nullable = false)
    private String solicitado2;

    @Column(name = "COMBUSTIBLE_2_C", nullable = false)
    private String cantidad2;

    @Column(name = "COMBUSTIBLE_3_S", nullable = false)
    private String solicitado3;

    @Column(name = "COMBUSTIBLE_3_C", nullable = false)
    private String cantidad3;

    @Column(name = "COMBUSTIBLE_4_S", nullable = false)
    private String solicitado4;

    @Column(name = "COMBUSTIBLE_4_C", nullable = false)
    private String cantidad4;

    @Column(name = "COMBUSTIBLE_5_S", nullable = false)
    private String solicitado5;

    @Column(name = "COMBUSTIBLE_5_C", nullable = false)
    private String cantidad5;

}
