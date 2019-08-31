package Model.Beans;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "datos_de_contacto", schema = "loteria")
public class DatosDeContacto_Bean {
    private Integer idContacto;
    private String correoElectronico;
    private String direccion;
    private String numeroCelular;
    private Collection<DatosParticipante_Bean> datosParticipantesByIdContacto;

    @Id
    @Column(name = "id_contacto", nullable = false)
    public Integer getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(Integer idContacto) {
        this.idContacto = idContacto;
    }

    @Basic
    @Column(name = "correo_electronico", nullable = true, length = 50)
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    @Basic
    @Column(name = "direccion", nullable = false, length = 100)
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Basic
    @Column(name = "numero_celular", nullable = false, length = 10)
    public String getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DatosDeContacto_Bean that = (DatosDeContacto_Bean) o;
        return Objects.equals(idContacto, that.idContacto) &&
                Objects.equals(correoElectronico, that.correoElectronico) &&
                Objects.equals(direccion, that.direccion) &&
                Objects.equals(numeroCelular, that.numeroCelular);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idContacto, correoElectronico, direccion, numeroCelular);
    }

    @OneToMany(mappedBy = "datosDeContactoByIdContacto")
    public Collection<DatosParticipante_Bean> getDatosParticipantesByIdContacto() {
        return datosParticipantesByIdContacto;
    }

    public void setDatosParticipantesByIdContacto(Collection<DatosParticipante_Bean> datosParticipantesByIdContacto) {
        this.datosParticipantesByIdContacto = datosParticipantesByIdContacto;
    }
}
