package test.java.kyu6.kata06;

import main.java.kyu6.kata06.BuildTower;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuildTowerTest {

    @Test
    public void BasicTests() {
        assertEquals(String.join(",", "*"), String.join(",", BuildTower.TowerBuilder(1)));
        assertEquals(String.join(",", " * ", "***"), String.join(",", BuildTower.TowerBuilder(2)));
        assertEquals(String.join(",", "  *  ", " *** ", "*****"), String.join(",", BuildTower.TowerBuilder(3)));
    }

}
