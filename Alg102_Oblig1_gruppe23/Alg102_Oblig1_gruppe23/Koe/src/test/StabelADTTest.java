package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import no.hvl.dat102.tabell.*;
import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.exception.EmptyCollectionException;
import no.hvl.dat102.kjedet.KjedetKoe;

/**
 * Test for StackADT.
 * 
 * @author Ole Olsen
 */
public class StabelADTTest {

	/**
	 * Size of the tested stabel.
	 */
	protected static final int SIZE = 4;

	// The koe
	private KoeADT<Integer> s,k,t;

	// Test data
	private Integer e0 = 1;
	private Integer e1 = 2;
	private Integer e2 = 3;
	private Integer e3 = 4;
	private Integer e4 = 5;
	private Integer e5 = 6;

	/**
	 * Get a new koe for each test.
	 */
	@Before
	public final void setup() {
		s= new SirkulaerKoe();
		
		k= new KjedetKoe();
	}
	
	@After
	public void tearDown() {
		s=null;
		k=null;
	}
	
	@Test
	public void testFjernPerson() {
		s.innKoe(e0);
		k.innKoe(e0);
		s.utKoe();
		k.utKoe();
	}

	/**
	 * Test that a new koe is empty.
	 */
	@Test
	public final void newStackIsEmpty() {
		assertTrue(s.erTom());
	}

	/**
	 * Test on innKoe and utKoe.
	 */
	@Test
	public final void pushAndPop() {

		s.innKoe(e0);
		s.innKoe(e1);
		s.innKoe(e2);
		s.innKoe(e3);

		try {
			assertEquals(e0, s.utKoe());
			assertEquals(e1, s.utKoe());
			assertEquals(e2, s.utKoe());
			assertEquals(e3, s.utKoe());
		} catch (EmptyCollectionException e) {
			fail("pop failed unexpectedly " + e.getMessage());
		}
	}

	/**
	 * Test on innKoe and utKoe with duplicated values.
	 */
	@Test
	public final void pushAndPopWithDuplicates() {

		s.innKoe(e0);
		s.innKoe(e1);
		s.innKoe(e1);
		s.innKoe(e2);

		try {
			assertEquals(e0, s.utKoe());
			assertEquals(e1, s.utKoe());
			assertEquals(e1, s.utKoe());
			assertEquals(e2, s.utKoe());
		} catch (EmptyCollectionException e) {
			fail("pop failed unexpectedly " + e.getMessage());
		}
	}


	/**
	 * Test that a koe with element(s) is not empty.
	 */
	@Test
	public final void isNotEmpty() {
		s.innKoe(e0);
		assertFalse(s.erTom());
	}
	/**
	 * Test that a koe with element(s) is full.
	 */
	@Test
	public final void isFull() {
		s.innKoe(e0);
		s.innKoe(e1);
		s.innKoe(e2);
		s.innKoe(e2);
		assertEquals(SIZE,s.antall());
	}

	@Test
	public final void firstElement() {
		s.innKoe(e0);
		assertEquals(e0,s.foerste());
	}
	/**
	 * Test that a innKoe - utKoe operation on an empty koe gives an empty
	 * stabel.
	 */
	@Test
	public final void pushPopIsEmpty() {
		try {
			s.innKoe(e0);
			s.utKoe();
			assertTrue(s.erTom());
		} catch (EmptyCollectionException e) {
			fail("pop failed unexpectedly " + e.getMessage());
		}
	}
	
	
	/**
	 * Trying to utKoe an element from an empty koe, should give an underflow
	 * exception.
	 * 
	 * 	 */
	@Test(expected = EmptyCollectionException.class)
	public final void popFromEmptyIsUnderflowed() {
		s.utKoe();
	}
	
	/**
     * Tester om koen utvider seg riktig. Koer på to flere elementer 
     * enn koetabellen har plass til, sjekker om antallet er riktig,
     * tar ut og sjekker første element, tar ut de i "midten",
     * tar ut og sjekker det siste elementet og sjekker til slutt
     * at koe er tom slik det forventes.
     */
	
    @Test
    public final void utviderKoeSeg() {
        s.innKoe(e0);
        s.innKoe(e1);
        s.innKoe(e2);
        s.innKoe(e3);
        s.innKoe(e4);
        assertEquals(SIZE+1,s.antall());
        assertFalse(s.erTom());
        for (int i = 0; i < SIZE; i++) {
            s.utKoe();
        }
        assertFalse(s.erTom());
    }

}
