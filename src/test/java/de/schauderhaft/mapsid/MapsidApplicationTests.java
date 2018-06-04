package de.schauderhaft.mapsid;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MapsidApplicationTests {

	@Autowired
	Dependents dependents;

	@Autowired
	Parents parents;

	@Autowired
	EntityManager em;

	@Test
	public void contextLoads() {
	}

	@Test
	public void storeParent() {

		createAndSaveParent("Alfred E. Neumann");

		parents.flush();
	}

	@Test
	public void storeDependent() {

		createAndSaveParent("Jens");

		Dependent d = new Dependent();

		Parent p = parents.findById("Jens").orElseThrow(IllegalStateException::new);

		d.setParent(p);
		d.setId(p.getId());

		dependents.save(d);

		parents.flush();
	}

	@Test
	public void storeDependentJpa() {

		Parent p1 = new Parent();
		p1.setId("Spy vs Spy");

		em.persist(p1);

		Dependent d = new Dependent();

		Parent p = parents.findById("Spy vs Spy").orElseThrow(IllegalStateException::new);

		d.setParent(p);
		d.setId(p.getId());

		em.persist(d);

		em.flush();
	}

	private void createAndSaveParent(String id) {
		Parent p = new Parent();
		p.setId(id);

		parents.save(p);
		parents.flush();
	}

}
