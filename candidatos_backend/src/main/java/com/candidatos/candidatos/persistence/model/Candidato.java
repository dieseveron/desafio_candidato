package com.candidatos.candidatos.persistence.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "candidato")
        public class Candidato {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "NOMBRE_APELLIDO")
    private String nombreYapellido;

    @Column(name = "DNI")
    private Integer dni;

    @Column(name = "FECHA_NAC")
    private Date fechaNac;

    @Column(name = "DOMICILIO")
    private String domicilio;

    @Column(name = "TELEFONO")
    private String telefono;

    @Column(name = "MAIL")
    private String mail;

    @Column(name = "FOTO")
    private String foto;

    @Column(name = "EXPERIENCIA")
    private String experiencia;

    public Candidato(String nombreYapellido, Integer dni, Date fechaNac, String domicilio, String telefono, String mail, String foto, String experiencia) {
        this.nombreYapellido = nombreYapellido;
        this.dni = dni;
        this.fechaNac = fechaNac;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.mail = mail;
        this.foto = foto;
        this.experiencia = experiencia;
    }

    public Candidato() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombreYapellido() {
        return nombreYapellido;
    }

    public void setNombreYapellido(String nombreYapellido) {
        this.nombreYapellido = nombreYapellido;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }
}
