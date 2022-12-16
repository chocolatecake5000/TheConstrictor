package theconstrictorpackagemod.cards;

import com.megacrit.cardcrawl.actions.defect.ReinforcedBodyAction;
import com.megacrit.cardcrawl.actions.unique.WhirlwindAction;
import theconstrictorpackagemod.util.CardInfo;
import characterclass.MyCharacter;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static theconstrictorpackagemod.theconstrictormod.makeID;

public class GoldenWave extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "GoldenWave",
            -1,
            CardType.ATTACK,
            CardTarget.ALL,
            CardRarity.RARE,
            MyCharacter.Enums.CARD_COLOR);

    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 8;
    private static final int UPG_DAMAGE = 2;

    private static final int BLOCK = 8;
    private static final int UPG_BLOCK = 2;

    public GoldenWave() {
        super(cardInfo);
        this.exhaust = true;
        setDamage(DAMAGE,UPG_DAMAGE);
        setBlock(BLOCK,UPG_BLOCK);

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        this.addToBot(new WhirlwindAction(p, this.multiDamage, this.damageTypeForTurn, this.freeToPlayOnce, this.energyOnUse));
        this.addToBot(new ReinforcedBodyAction(p, this.block, this.freeToPlayOnce, this.energyOnUse));
    }


}

