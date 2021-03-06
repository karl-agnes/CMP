package warborn.model;

import static org.junit.Assert.*;
import javax.swing.ImageIcon;
import org.junit.Test;

public class CardTest {

	@Test
	public void testCard() {
		String troop1 = "SortOfTroop", troop2 = "OtherTroop"; 
		ImageIcon img1 = new ImageIcon();
		ImageIcon img2 = new ImageIcon();
		int one=1, two=2;
		Card card1 = new Card(troop1, img1, one);
		Card card2 = new Card(troop2, img2, two);
		assertTrue(card1.getName() == troop1);
		assertTrue(card1.getImage() == img1);
		assertTrue(card1.getIndex() == 1);
		assertTrue(card2.getName() == troop2);
		assertTrue(card2.getImage() == img2);
		assertTrue(card2.getIndex() == 2);
	}

}
