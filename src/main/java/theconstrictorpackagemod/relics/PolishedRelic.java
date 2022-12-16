package theconstrictorpackagemod.relics;

import characterclass.MyCharacter;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.HealAction;
import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theconstrictorpackagemod.powers.ConstrictingPower;
import theconstrictorpackagemod.relics.BaseRelic;

import java.util.Iterator;

import static theconstrictorpackagemod.theconstrictormod.makeID;

public class PolishedRelic extends BaseRelic {
    private static final String NAME = "PolishedRelic"; //The name will be used for determining the image file as well as the ID.
    public static final String ID = makeID(NAME); //This adds the mod's prefix to the relic ID, resulting in modID:MyRelic
    private static final RelicTier RARITY = RelicTier.BOSS; //The relic's rarity.
    private static final LandingSound SOUND = LandingSound.CLINK; //The sound played when the relic is clicked.

    public PolishedRelic() {
        super(ID, NAME, MyCharacter.Enums.CARD_COLOR, RelicTier.BOSS, LandingSound.CLINK);
    }

    public void atBattleStart() {
        this.flash();
        this.addToBot(new RelicAboveCreatureAction(AbstractDungeon.player, this));
        this.addToBot(new DrawCardAction(AbstractDungeon.player, 2));
        AbstractPlayer p = AbstractDungeon.player;
        if (p.currentHealth > 0) {
            p.heal(6);
        }
    }

    @Override
    public void obtain() {
        // Replace the starter relic, or just give the relic if starter isn't found
        if (AbstractDungeon.player.hasRelic(DustyRelic.ID)) {
            for (int i=0; i<AbstractDungeon.player.relics.size(); ++i) {
                if (AbstractDungeon.player.relics.get(i).relicId.equals(DustyRelic.ID)) {
                    instantObtain(AbstractDungeon.player, i, true);
                    break;
                }
            }
        } else {
            super.obtain();
        }
    }

    @Override
    public boolean canSpawn()
    {
        // Only spawn if player has the starter relic
        return AbstractDungeon.player.hasRelic(DustyRelic.ID);
    }

    @Override
    public String getUpdatedDescription() {
        return String.format(DESCRIPTIONS[0]);
    }
}