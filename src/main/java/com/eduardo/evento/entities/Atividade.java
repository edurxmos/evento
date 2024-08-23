package com.eduardo.evento.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity(name = "tb_atividade")
public class Atividade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    private Double price;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @Getter
    @ManyToMany
    @JoinTable(name = "tb_participante_atividade",
            joinColumns = @JoinColumn(name = "participante_id"),
            inverseJoinColumns = @JoinColumn(name = "atividade_id"))
    private List<Participante> participantes = new ArrayList<>();

    @OneToMany(mappedBy = "atividade")
    private List<Bloco> blocos = new ArrayList<>();

}
