package com.sevilla.clubtor.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "partido")
public class MatchModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private TeamModel equipoLocal;

    @ManyToOne
    private TeamModel equipoVisitante;

    @NotNull
    private Date fechaHora;

    @NotBlank
    private String lugar;

    private String resultado;

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TeamModel getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(TeamModel equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public TeamModel getEquipoVisitante() {
        return equipoVisitante;
    }

    public void setEquipoVisitante(TeamModel equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
}
