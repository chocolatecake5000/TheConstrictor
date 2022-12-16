package theconstrictorpackagemod.cards;

import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import theconstrictorpackagemod.util.CardInfo;
import characterclass.MyCharacter;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static theconstrictorpackagemod.theconstrictormod.makeID;

public class PacificSailfishStrike extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "PacificSailfishStrike",
            1,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.COMMON,
            MyCharacter.Enums.CARD_COLOR);

    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 9;
    private static final int UPG_DAMAGE = 2;


    public PacificSailfishStrike() {
        super(cardInfo);
        setDamage(DAMAGE, UPG_DAMAGE);
        setMagic(1,1);
        tags.add(CardTags.STRIKE);

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.SLASH_VERTICAL));
        addToBot(new DrawCardAction(magicNumber));

    }


}

