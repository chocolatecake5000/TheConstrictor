package theconstrictorpackagemod.patches;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePostfixPatch;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.UIStrings;
import com.megacrit.cardcrawl.screens.stats.AchievementGrid;
import theconstrictorpackagemod.achievements.ConstrictorAchievementItem;

@SpirePatch(clz = AchievementGrid.class, method = "<ctor>")
public class AchievementGridConstructorPatch {
    public AchievementGridConstructorPatch() {}

    @SpirePostfixPatch
    public static void Postfix(AchievementGrid instance) {
        ConstrictorAchievementItem.atlas = new TextureAtlas(Gdx.files.internal("theconstrictorpackagemod/achievements/ConstrictorAchievements.atlas"));
        loadAchievement(instance, "chokedout", theconstrictorpackagemod.theconstrictormod.makeID("CHOKED_OUT"), false);
        loadAchievement(instance, "iamthetide", theconstrictorpackagemod.theconstrictormod.makeID("I_AM_THE_TIDE"), false);
        loadAchievement(instance, "constrictormastery", theconstrictorpackagemod.theconstrictormod.makeID("CONSTRICTOR_MASTERY"), false);
    }

    private static void loadAchievement(AchievementGrid instance, String imgName, String id, boolean isHidden) {
        UIStrings uiStrings = CardCrawlGame.languagePack.getUIString(id);
        String name = uiStrings.TEXT[0];
        String description = uiStrings.TEXT[1];

        TextureAtlas.AtlasRegion AchievementImageUnlocked = ConstrictorAchievementItem.atlas.findRegion("unlocked/" + imgName);
        TextureAtlas.AtlasRegion AchievementImageLocked = ConstrictorAchievementItem.atlas.findRegion("locked/" + imgName);

        instance.items.add(new ConstrictorAchievementItem(name, description, id, isHidden, AchievementImageUnlocked, AchievementImageLocked));
    }
}
