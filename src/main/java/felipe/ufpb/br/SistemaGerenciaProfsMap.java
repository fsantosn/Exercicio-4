package felipe.ufpb.br;

import java.util.*;

public class SistemaGerenciaProfsMap implements SistemaGerenciaProfs {

    private Map<Integer, Professor> professores = new HashMap<>();
    private Map<Integer, Disciplina> disciplinas = new HashMap<>();

    public List<Horario> consultaHorariosDeAulaDoProfessor(int matriculaProf) throws ProfessorInexistenteException{
        List<Horario> horario = new LinkedList<>();
        if (!professores.containsKey(matriculaProf)){
            throw new ProfessorInexistenteException("Professor Inexistente");
        }
        for (Disciplina d: disciplinas.values()){
           if(d.getMatriculaProfessor()== matriculaProf){
               horario.addAll(d.getHorarios());
           }
        } return horario;
    }

    public List<String> consultaNomesDisciplinasDoProfessor(int matriculaProf){
        List<String> n = new LinkedList<>();
        for (Disciplina c: disciplinas.values()){
            if(c.getMatriculaProfessor() == matriculaProf){
                n.add(c.getNome());
            }
        } return n;
    }

    public void cadastraProfessor(int matriculaProf, String nome) throws ProfessorJaExisteException{
        if(professores.containsKey(matriculaProf)){
            throw new ProfessorJaExisteException("Professor: "+nome+", com matricula: "+ matriculaProf+" já está cadastrado");
        }
        Professor n = new Professor(nome,matriculaProf);
        professores.put(matriculaProf,n);
    }

    public void cadastraDisciplina(String nomeDisciplina, int codigoDisciplina,  int matriculaProfessor, List<Horario> horarios) throws
            DisciplinaJaExisteException{
        Disciplina d = new Disciplina(nomeDisciplina,codigoDisciplina,matriculaProfessor,horarios);
        if (disciplinas.containsKey(codigoDisciplina)){
            throw new DisciplinaJaExisteException("Disciplina já cadastrada");
        }
        disciplinas.put(codigoDisciplina, d);
    }
    public Disciplina pesquisaDisciplina(int codigoDisciplina) throws
            DisciplinaInexistenteException{
        if(!disciplinas.containsKey(codigoDisciplina)){
            throw new DisciplinaInexistenteException("DIsciplina Inexistente");
        }
        return disciplinas.get(codigoDisciplina);
    }
    public Professor pesquisaProfessor(int matriculaProfessor) throws
            ProfessorInexistenteException{
        if(!professores.containsKey(matriculaProfessor)){
            throw new ProfessorInexistenteException("Professor Inexistente");
        }
        return professores.get(matriculaProfessor);
    }
}
