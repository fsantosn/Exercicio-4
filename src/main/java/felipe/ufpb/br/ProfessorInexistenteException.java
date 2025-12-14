package felipe.ufpb.br;

public class ProfessorInexistenteException extends Exception {
    public ProfessorInexistenteException (String messagem){
        super(messagem);
    }
}
