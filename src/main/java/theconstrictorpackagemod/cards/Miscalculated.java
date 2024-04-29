package theconstrictorpackagemod.cards;


import com.megacrit.cardcrawl.actions.common.*;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import theconstrictorpackagemod.powers.ConstrictingPower;
import theconstrictorpackagemod.util.CardInfo;
import characterclass.MyCharacter;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static theconstrictorpackagemod.theconstrictormod.makeID;

public class Miscalculated extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Miscalculated",
            0,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.COMMON,
            MyCharacter.Enums.CARD_COLOR);

    public static final String ID = makeID(cardInfo.baseId);




    public Miscalculated() {
        super(cardInfo);
        setMagic(1,1);
    }
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
            this.addToBot(new GainEnergyAction(magicNumber));
        this.addToBot(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new ConstrictingPower(AbstractDungeon.player, p, 4), 4));
    }



}

