package monopoly;

import org.junit.*;

import static org.junit.Assert.*;

public class DieTest {

    private Die die = new Die(); // Actor : CUT

    @BeforeClass
    public static void globalSetUp() { /* common initialisations (fixtures) */ }

    @AfterClass
    public static void globalTearDown() { /*...*/ }

    @Before
    public void setUp() { /* common initialisations (fixtures) */ }

    @After
    public void tearDown() { /*...*/ }

    @Test
    public void should_have_value_between_1_and_6() {
        // Initailisations specific to the test
        die.roll(); // Actions on Actors
        assertTrue(die.getValue() >= 1); // Assertions
        assertTrue(die.getValue() <= 6);
    }
}