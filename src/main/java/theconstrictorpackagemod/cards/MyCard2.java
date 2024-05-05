package theconstrictorpackagemod.cards;


import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import theconstrictorpackagemod.powers.ConstrictingPower;
import theconstrictorpackagemod.util.CardInfo;
import characterclass.MyCharacter;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import java.util.Iterator;

import static theconstrictorpackagemod.theconstrictormod.makeID;

public class MyCard2 extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "MyCard2",
            0,
            CardType.SKILL,
            CardTarget.ALL,
            CardRarity.BASIC,
            MyCharacter.Enums.CARD_COLOR);

    public static final String ID = makeID(cardInfo.baseId);


    private static final int BLOCK = 8;
    private static final int UPG_BLOCK = 4;



    public MyCard2() {
        super(cardInfo);

        setBlock(BLOCK, UPG_BLOCK);
        setMagic(4,2);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        this.addToBot(new ApplyPowerAction(p, p, new ConstrictingPower(p, p, this.magicNumber), this.magicNumber));


        addToBot(new GainBlockAction(p, p, block));
        Iterator var3 = AbstractDungeon.getCurrRoom().monsters.monsters.iterator();

        while(var3.hasNext()) {
            AbstractMonster mo = (AbstractMonster)var3.next();
            this.addToBot(new ApplyPowerAction(mo, p, new ConstrictingPower(mo, p, this.magicNumber), this.magicNumber, true, AbstractGameAction.AttackEffect.NONE));

        }

    }

}

