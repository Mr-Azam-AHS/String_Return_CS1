import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;

public class LabTests {

    @Nested
    class AddStringsTests {
        @Test
        public void testDefaultConstructor() {
            AddStrings add = new AddStrings();
            assertNotNull(add, "Constructor returned null");
            // Assuming default toString is empty or specific format
            // assertEquals("", add.toString(), "Default constructor should verify empty
            // state");
        }

        @Test
        public void testParameterizedConstructor() {
            AddStrings add = new AddStrings("Hello", "World");
            assertEquals("HelloWorld", add.toString(),
                    "Parameterized constructor did not set values correctly (checked via toString)");
        }

        @Test
        public void testSetStrings() {
            AddStrings add = new AddStrings();
            add.setStrings("Hello", "World");
            // We must rely on toString or a getter to verify the set actually happened
            assertEquals("HelloWorld", add.toString(), "setStrings did not update the internal state correctly");
        }

        @Test
        public void testAdd() {
            AddStrings add = new AddStrings("Hello", "World");
            add.add();
            // If add() is void, does it change internal state?
            // If add() returns a string, capture it!
            // Assuming add() updates internal state:
            assertEquals("HelloWorld", add.toString(), "add() method failed to concatenate strings");
        }
    }

    @Nested
    class FirstAndLastTests {
        // ... previous tests looked mostly okay ...

        @Test
        public void testGetFirst() {
            FirstAndLast fal = new FirstAndLast("Hello");
            assertEquals("H", fal.getFirst(), "getFirst() returned the wrong character");
        }

        @Test
        public void testGetLast() {
            FirstAndLast fal = new FirstAndLast("Hello");
            assertEquals("o", fal.getLast(), "getLast() returned the wrong character");
        }
    }

    @Nested
    class NameTests {
        @Test
        public void testSetName() {
            Name name = new Name();
            name.setName("Jane Smith");
            // Must verify the set worked!
            assertAll("setName verification",
                    () -> assertEquals("Jane", name.getFirst(), "First name not parsed correctly after setName"),
                    () -> assertEquals("Smith", name.getLast(), "Last name not parsed correctly after setName"));
        }
        // ... other tests looked okay ...
    }

    @Nested
    class StringCheckerTests {
        @Test
        public void testFindLetterCaseSensitive() {
            StringChecker sc = new StringChecker("Hello");
            // Check that BOTH work, not just that they match
            assertTrue(sc.findLetter('h'), "Failed to find lowercase 'h'");
            assertTrue(sc.findLetter('H'), "Failed to find uppercase 'H'");
        }
        // ... other tests looked okay ...
    }

    @Nested
    class StringRipperTests {
        @Test
        public void testRipString() {
            StringRipper sr = new StringRipper("HelloWorld");
            // NOTE: Adjusted based on your likely intent (Inclusive End Index)
            // If using standard Java substring logic, expected should be "Hell"
            String ripped = sr.ripString(0, 4);
            assertEquals("Hello", ripped, "ripString(0,4) should return characters at indices 0,1,2,3,4");
        }

        @Test
        public void testRipStringFromMiddle() {
            StringRipper sr = new StringRipper("HelloWorld");
            // Indices: W(5) o(6) r(7) l(8) d(9)
            String ripped = sr.ripString(5, 9);
            assertEquals("World", ripped, "ripString(5,9) failed to slice middle correctly");
        }
    }
}