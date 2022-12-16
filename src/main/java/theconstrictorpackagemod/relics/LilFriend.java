package theconstrictorpackagemod.relics;

import characterclass.MyCharacter;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.cards.tempCards.Shiv;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.BlurPower;
import com.megacrit.cardcrawl.powers.DexterityPower;
import com.megacrit.cardcrawl.powers.PoisonPower;
import com.megacrit.cardcrawl.powers.StrengthPower;
import theconstrictorpackagemod.cards.MyCard;
import theconstrictorpackagemod.powers.ConstrictingPower;

import java.util.Iterator;

import static theconstrictorpackagemod.theconstrictormod.makeID;

public class LilFriend extends BaseRelic {
    private static final String NAME = "LilFriend"; //The name will be used for determining the image file as well as the ID.
    public static final String ID = makeID(NAME); //This adds the mod's prefix to the relic ID, resulting in modID:MyRelic
    private static final RelicTier RARITY = RelicTier.BOSS; //The relic's rarity.
    private static final LandingSound SOUND = LandingSound.CLINK; //The sound played when the relic is clicked.

    public LilFriend() {
        super(ID, NAME, MyCharacter.Enums.CARD_COLOR, RelicTier.BOSS, LandingSound.CLINK);
    }

    public void atBattleStartPreDraw() {
        this.addToBot(new RelicAboveCreatureAction(AbstractDungeon.player, this));
        this.addToBot(new MakeTempCardInHandAction(new MyCard(), 3, false));
    }
    @Override
    public String getUpdatedDescription() {
        return String.format(DESCRIPTIONS[0]);
    }
}