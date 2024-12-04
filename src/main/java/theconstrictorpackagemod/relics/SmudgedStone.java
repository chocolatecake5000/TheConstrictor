package theconstrictorpackagemod.relics;

import characterclass.MyCharacter;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.BlurPower;
import com.megacrit.cardcrawl.powers.DexterityPower;
import com.megacrit.cardcrawl.powers.PoisonPower;
import com.megacrit.cardcrawl.powers.StrengthPower;
import theconstrictorpackagemod.powers.ConstrictingPower;

import java.util.Iterator;

import static theconstrictorpackagemod.theconstrictormod.makeID;

public class SmudgedStone extends BaseRelic {
    private static final String NAME = "SmudgedStone"; //The name will be used for determining the image file as well as the ID.
    public static final String ID = makeID(NAME); //This adds the mod's prefix to the relic ID, resulting in modID:MyRelic
    private static final RelicTier RARITY = RelicTier.RARE; //The relic's rarity.
    private static final LandingSound SOUND = LandingSound.CLINK; //The sound played when the relic is clicked.

    public SmudgedStone() {
        super(ID, NAME, MyCharacter.Enums.CARD_COLOR, RelicTier.RARE, LandingSound.CLINK);
    }

    public void onUseCard(AbstractCard card, UseCardAction action) {
        ++this.counter;
        if (this.counter == 12) {
            this.counter = 0;
            this.flash();
            this.pulse = false;
            this.addToBot(new RelicAboveCreatureAction(AbstractDungeon.player, this));
            this.addToTop(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new BlurPower(AbstractDungeon.player, 1), 1));
        } else if (this.counter == 11) {
            this.beginPulse();
            this.pulse = true;
        }

    }

    public void atBattleStart() {
        if (this.counter == 11) {
            this.beginPulse();
            this.pulse = true;
        }

    }
    @Override
    public String getUpdatedDescription() {
        return String.format(DESCRIPTIONS[0]);
    }
}