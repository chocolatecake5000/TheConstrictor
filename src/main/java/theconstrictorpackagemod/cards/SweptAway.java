package theconstrictorpackagemod.cards;

import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import theconstrictorpackagemod.util.CardInfo;
import characterclass.MyCharacter;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static theconstrictorpackagemod.theconstrictormod.makeID;

public class SweptAway extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "SweptAway",
            1,
            CardType.ATTACK,
            CardTarget.ALL_ENEMY,
            CardRarity.UNCOMMON,
            MyCharacter.Enums.CARD_COLOR);


    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 11;
    private static final int UPG_DAMAGE = 3;


    public SweptAway() {
        super(cardInfo);
        setDamage(DAMAGE, UPG_DAMAGE);

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        this.addToBot(new DamageAllEnemiesAction(p, this.multiDamage, this.damageTypeForTurn, AbstractGameAction.AttackEffect.NONE));

    }


}

