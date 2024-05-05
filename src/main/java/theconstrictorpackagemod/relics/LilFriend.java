package theconstrictorpackagemod.relics;

import basemod.helpers.CardPowerTip;
import characterclass.MyCharacter;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
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
    public static final String ID = makeID(NAME);

    public LilFriend() {
        super(ID, NAME, MyCharacter.Enums.CARD_COLOR, RelicTier.BOSS, LandingSound.CLINK);
        tips.add(new CardPowerTip(new MyCard()));
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