package atividadeTestes;

import static org.junit.Assert.*;

import org.junit.Test;

public class CustomerTest {
	
	
	@Test
	public void test() {
		Customer c = new Customer("Marcio");
		Movie m = new Movie("Missao impossivel", 1);
		Rental r = new Rental(m,5);
		
		//teste getName
		assertEquals("Marcio", c.getName());
		
		//teste getDaysRented
		assertEquals(5,r.getDaysRented());
		
		//teste title Filme
		assertEquals("Missao impossivel",m.getTitle());

		//teste nome cliente
		assertEquals("Marcio", c.getName());
		
		//teste satement()
		int thisAmount = 0;
		String result = "Rental Record for Marcio\n";
		switch (r.getMovie().getPriceCode()) {
			case Movie.REGULAR:
				thisAmount += 2;
				if (r.getDaysRented() > 2) 
					thisAmount += (r.getDaysRented() - 2) * 1.5;
			break;
			case Movie.NEW_RELEASE:
				thisAmount += r.getDaysRented() * 3;	
			break;
			case Movie.CHILDRENS:
				thisAmount += 1.5;
				if (r.getDaysRented() > 3)
					thisAmount += (r.getDaysRented() - 3) * 1.5;
			break;
		}
		
		result += "Amount owed is " + String.valueOf(thisAmount) + "\n"; //o valor total eh o valor da unica locacao
		result += "You earned 0 frequent renter points"; //so houve 1 locacao
		assertEquals(result,c.statement());
		
		
		
		
	}
	


}
