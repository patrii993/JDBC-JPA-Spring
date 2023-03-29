import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Test;

import com.dawes.modelo.MedicamentoVO;
import com.dawes.modelo.PacienteMedicamentoVO;
import com.dawes.modelo.PacienteVO;
import com.dawes.servicios.ServicioMedicamento;
import com.dawes.servicios.ServicioMedicamentoImpl;
import com.dawes.servicios.ServicioPM;
import com.dawes.servicios.ServicioPMImpl;
import com.dawes.servicios.ServicioPaciente;
import com.dawes.servicios.ServicioPacienteImpl;

public class TestHospital {

	static ServicioPaciente sp=new ServicioPacienteImpl();
	static ServicioMedicamento sm=new ServicioMedicamentoImpl();
	static ServicioPM spm=new ServicioPMImpl();
	
	@Test
	public void test01() {
		assertEquals(1,sp.insertar(new PacienteVO("1","Pedro",LocalDate.of(1962, 3, 16),new ArrayList())));
	}
	
	@Test
	public void test02() {
		assertEquals(0,sp.insertar(new PacienteVO("1","Saúl",LocalDate.of(2000, 3, 16),new ArrayList())));
	}

	@Test
	public void test03() {
		sm.insertar(new MedicamentoVO("Paracetamol","Bayer",new ArrayList()));
		assertEquals(1,sm.insertar(new MedicamentoVO("Aspirina","Bayer",new ArrayList())));
	}
	
	@Test
	public void test04() {
		spm.insertar(new PacienteMedicamentoVO(sm.findByDenominacion("Aspirina").get()
				,sp.findByDni("1").get(),LocalDate.now(),1f,"pastilla 1 gr"));
		assertEquals(1,spm.insertar(new PacienteMedicamentoVO(sm.findByDenominacion("Paracetamol").get()
				,sp.findByDni("1").get(),LocalDate.now(),0.3f,"jarabe")));
		
	}
	@Test
	public void test05() {
		assertEquals(2,sp.findByDni("1").get().getMedicamentos().size());
	}
	
	@Test
	public void test06() {
		assertEquals(1,spm.findPacienteMayor60(sp.findByDni("1").get()).get().size());
	}
}
