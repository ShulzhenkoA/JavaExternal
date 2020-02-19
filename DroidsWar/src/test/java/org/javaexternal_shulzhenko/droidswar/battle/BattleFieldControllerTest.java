package org.javaexternal_shulzhenko.droidswar.battle;


import org.javaexternal_shulzhenko.droidswar.droids.DroidB01;
import org.javaexternal_shulzhenko.droidswar.exceptions.InappropriateDroidsException;
import org.javaexternal_shulzhenko.droidswar.factories.DroidFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class BattleFieldControllerTest {

    DroidB01 firstDroid;
    DroidB01 secondDroid;

    @BeforeEach
    void setThis() {
        firstDroid = DroidFactory.getDroidFactory().getBattleDroidBD02();
        secondDroid = DroidFactory.getDroidFactory().getBattleDroidBD02();
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