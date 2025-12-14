package felipe.ufpb.br;

import java.util.List;

public class Disciplina {

    private String nome;
    private int codigo;
    private int matriculaProfessor;
    private List<Horario> horarios;

    public Disciplina(String nome, int codigo, int matriculaProfessor, List<Horario> horarios) {
        this.nome = nome;
        this.codigo = codigo;
        this.matriculaProfessor = matriculaProfessor;
        this.horarios = horarios;
    }

    public String getNome() {
        return nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public List<Horario> getHorarios() {
        return horarios;
    }

    public int getMatriculaProfessor() {
        return matriculaProfessor;
    }
}
