package theconstrictorpackagemod.relics;

import characterclass.MyCharacter;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import theconstrictorpackagemod.powers.ConstrictingPower;

import static theconstrictorpackagemod.theconstrictormod.makeID;

public class SlimyShield extends BaseRelic {
    private static final String NAME = "SlimyShield"; //The name will be used for determining the image file as well as the ID.
    public static final String ID = makeID(NAME); //This adds the mod's prefix to the relic ID, resulting in modID:MyRelic
    private static final RelicTier RARITY = RelicTier.COMMON; //The relic's rarity.
    private static final LandingSound SOUND = LandingSound.CLINK; //The sound played when the relic is clicked.

    public SlimyShield() {
        super(ID, NAME, MyCharacter.Enums.CARD_COLOR, RelicTier.COMMON, LandingSound.CLINK);
    }

    public void atPreBattle() {
        this.flash();
        this.addToTop(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new ConstrictingPower(AbstractDungeon.player, AbstractDungeon.player, -6), -6));
        this.addToTop(new RelicAboveCreatureAction(AbstractDungeon.player, this));
    }
    @Override
    public String getUpdatedDescription() {
        return String.format(DESCRIPTIONS[0]);
    }
}