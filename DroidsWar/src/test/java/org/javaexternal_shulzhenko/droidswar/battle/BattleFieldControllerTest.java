package org.javaexternal_shulzhenko.droidswar.battle;


import org.javaexternal_shulzhenko.droidswar.droids.Droid;
import org.javaexternal_shulzhenko.droidswar.exceptions.InappropriateDroidsException;
import org.javaexternal_shulzhenko.droidswar.factories.DroidFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class BattleFieldControllerTest {

    Droid firstDroid;
    Droid secondDroid;
    static DroidFactory factory;

    @BeforeAll
    static void setUp(){
        factory = new DroidFactory();
    }

    @BeforeEach
    void setThis() {
        firstDroid = factory.getBattleDroidBD02();
        secondDroid = factory.getBattleDroidBD02();
    }
    @Test
    void fightSingleRound_WithSameDroid_ThrowInappropriateDroidsException(){
        Assertions.assertThrows(InappropriateDroidsException.class, () ->
                BattleFieldController.fightSingleRound(firstDroid,firstDroid));
    }

    @Test
    void fightSingleRound_WithDestroyedDroid_ThrowInappropriateDroidsException(){
        secondDroid.setAlive(false);
        Assertions.assertThrows(InappropriateDroidsException.class, () ->
                BattleFieldController.fightSingleRound(firstDroid,secondDroid));
    }

    @Test
    void fightToEnd_WithTwoDroids_AtLestOneIsDestroyed() throws InappropriateDroidsException {
        BattleFieldController.fightToEnd(firstDroid,secondDroid);
        Assertions.assertTrue(!firstDroid.isAlive() || !secondDroid.isAlive());
    }

    @Test
    void fightToEnd_WithWithDestroyedDroid_ThrowInappropriateDroidsException() {
        firstDroid.setAlive(false);
        Assertions.assertThrows(InappropriateDroidsException.class, () ->
                BattleFieldController.fightToEnd(firstDroid,secondDroid));
    }

    @Test
    void fightToEnd_WithSameDroid_ThrowInappropriateDroidsException() {
        Assertions.assertThrows(InappropriateDroidsException.class, () ->
                BattleFieldController.fightToEnd(secondDroid,secondDroid));
    }
}