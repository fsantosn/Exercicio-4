package professores;

import felipe.ufpb.br.*;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class SistemaGerenciaProfsMapTest {


    @Test
    public void testaprofessores(){
        SistemaGerenciaProfsMap sistema = new SistemaGerenciaProfsMap();
        try {
             //1
            sistema.cadastraProfessor(111,"josé");
            //2
            List<String> d = sistema.consultaNomesDisciplinasDoProfessor(111);
            assertEquals(0, d.size());
            //3
            List<Horario> n = new LinkedList<>();
            n.add(new Horario(DiaDaSemana.TERCA,10,12));
            n.add(new Horario(DiaDaSemana.TERCA,13,15));
            sistema.cadastraDisciplina("POO",22,111,n);
            //4
            List<Horario> c = sistema.consultaHorariosDeAulaDoProfessor(111);
            assertEquals(2,c.size());
            assertEquals(DiaDaSemana.TERCA,c.getFirst().getDia());
            assertEquals(10,c.getFirst().getHoraInicio());
            assertEquals(12,c.getFirst().getHoraFim());
            assertEquals(DiaDaSemana.TERCA,c.get(1).getDia());
            assertEquals(13, c.getFirst().getHoraInicio());
            assertEquals(15, c.getFirst().getHoraFim());

        } catch (Exception  e){
            fail("não deveria lançar a exeção");
        }
    }
}
