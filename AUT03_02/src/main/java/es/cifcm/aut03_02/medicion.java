package es.cifcm.aut03_02;

import java.sql.Date;

/**
 *
 * @author yasie
 */
public class medicion {

    private Integer idMedicion;
    private Integer Cliente;
    private Date FechaHora;
    private Double KW;

    public medicion() {
    }

    public medicion(Integer idMedicion, Integer Cliente, Date FechaHora, Double KW) {
        this.idMedicion = idMedicion;
        this.Cliente = Cliente;
        this.FechaHora = FechaHora;
        this.KW = KW;
    }

    public Integer getIdMedicion() {
        return idMedicion;
    }

    public void setIdMedicion(Integer idMedicion) {
        this.idMedicion = idMedicion;
    }

    public Integer getCliente() {
        return Cliente;
    }

    public void setCliente(Integer Cliente) {
        this.Cliente = Cliente;
    }

    public Date getFechaHora() {
        return FechaHora;
    }

    public void setFechaHora(Date FechaHora) {
        this.FechaHora = FechaHora;
    }

    public Double getKW() {
        return KW;
    }

    public void setKW(Double KW) {
        this.KW = KW;
    }

}
