package br.com.bhas.icabueta.model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Denuncia {
    private int codigo;
    private Date data;
    private String turno;
    private String descricao;
    private Cadeira cadeira;
    private Professor professor;
    private MetodoFila metodoFila;
    private Estudante denunciante;
    private List<Estudante> denunciados;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Cadeira getCadeira() {
        return cadeira;
    }

    public void setCadeira(Cadeira cadeira) {
        this.cadeira = cadeira;
    }

    public Estudante getDenunciante() {
        return denunciante;
    }

    public void setDenunciante(Estudante denunciante) {
        this.denunciante = denunciante;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public MetodoFila getMetodoFila() {
        return metodoFila;
    }

    public void setMetodoFila(MetodoFila metodoFila) {
        this.metodoFila = metodoFila;
    }

    public List<Estudante> getDenunciados() {
        return denunciados;
    }

    public void setDenunciados(List<Estudante> denunciados) {
        this.denunciados = denunciados;
    }

    public String getDataFormatada() {
        return new SimpleDateFormat("dd/MM/yyyy").format(this.data);
    }
}
