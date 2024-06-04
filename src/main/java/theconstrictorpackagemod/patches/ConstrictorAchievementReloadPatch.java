package theconstrictorpackagemod.patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePostfixPatch;
import com.megacrit.cardcrawl.screens.stats.AchievementItem;
import theconstrictorpackagemod.achievements.ConstrictorAchievementItem;

@SpirePatch(
        clz = AchievementItem.class,
        method = "reloadImg"
)
public class ConstrictorAchievementReloadPatch {
    public ConstrictorAchievementReloadPatch() {
    }

    @SpirePostfixPatch
    public static void Postfix(AchievementItem __instance) {
        if (__instance instanceof ConstrictorAchievementItem) {
            ((ConstrictorAchievementItem)__instance).currentImg = ConstrictorAchievementItem.atlas.findRegion(((ConstrictorAchievementItem)__instance).currentImg.name);
        }

    }
}
