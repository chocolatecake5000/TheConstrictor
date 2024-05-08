package theconstrictorpackagemod.patches;

import characterclass.MyCharacter;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePostfixPatch;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.MonsterGroup;
import com.megacrit.cardcrawl.screens.VictoryScreen;
import com.megacrit.cardcrawl.unlock.UnlockTracker;

@SpirePatch(clz = VictoryScreen.class, method = SpirePatch.CONSTRUCTOR, paramtypez = {MonsterGroup.class})
public class ConstrictorMasteryPatch {
    public ConstrictorMasteryPatch() {
    }

    @SpirePostfixPatch
    public static void Postfix(VictoryScreen __instance, MonsterGroup m) {
        AbstractPlayer p = AbstractDungeon.player;
        if (p != null && p instanceof MyCharacter && AbstractDungeon.ascensionLevel == 20 && AbstractDungeon.actNum == 4) {
            UnlockTracker.unlockAchievement(theconstrictorpackagemod.theconstrictormod.makeID("CONSTRICTOR_MASTERY"));
        }
    }
}