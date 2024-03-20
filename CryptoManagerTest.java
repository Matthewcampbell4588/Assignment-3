import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CryptoManagerTest {
	CryptoManager cryptoManager;

	@BeforeEach
	public void setUp() throws Exception {
	}

	@AfterEach
	public void tearDown() throws Exception {
	}

	@Test
	public void testStringInBounds() {
		assertTrue(CryptoManager.isStringInBounds("PYTHON"));
		assertTrue(CryptoManager.isStringInBounds("\"#### \""));
		assertFalse(CryptoManager.isStringInBounds("python"));
		assertFalse(CryptoManager.isStringInBounds("{"));
		assertFalse(CryptoManager.isStringInBounds("\"THIS TEST SHOULD FAIL CAUSE rust IS OUT SIDE OF THE RANGE\""));
	}

	@Test
	public void testEncryptCaesar() {
		assertEquals("The selected string is not in bounds, Try again.", CryptoManager.caesarEncryption("aye", 3));
		assertEquals("LQWHO", CryptoManager.caesarEncryption("INTEL", 3));
		assertEquals("!-$", CryptoManager.caesarEncryption("AMD", 96));
		assertEquals("62,;8<8/=", CryptoManager.caesarEncryption("MICROSOFT", 105));
		assertEquals("DPNQUJB!", CryptoManager.caesarEncryption("COMPTIA ", 1));
		assertEquals("PRV9835", CryptoManager.caesarEncryption("MOS6502", 3));
	}

	@Test
	public void testDecryptCaesar() {
		assertEquals("INTEL", CryptoManager.caesarDecryption("LQWHO", 3));
		assertEquals("AMD", CryptoManager.caesarDecryption("!-$", 96));
		assertEquals("MICROSOFT", CryptoManager.caesarDecryption("62,;8<8/=", 105));
		assertEquals("COMPTIA ", CryptoManager.caesarDecryption("DPNQUJB!", 1));
	}

	@Test
	public void testEncryptBellaso() {
		assertEquals("VWWW[\\]ZY", CryptoManager.bellasoEncryption("MICROSOFT", "INTEL"));
		assertEquals("P><A=O(\"", CryptoManager.bellasoEncryption("ZILOGZ80", "6502"));
		assertEquals("O>Q:K:", CryptoManager.bellasoEncryption("VEXARA", "99"));

	}

	@Test
	public void testDecryptBellaso() {
		assertEquals("MICROSOFT", CryptoManager.bellasoDecryption("VWWW[\\]ZY", "INTEL"));
		assertEquals("ZILOGZ80", CryptoManager.bellasoDecryption("P><A=O(\"", "6502"));
		assertEquals("VEXARA", CryptoManager.bellasoDecryption("O>Q:K:", "99"));

	}

}
