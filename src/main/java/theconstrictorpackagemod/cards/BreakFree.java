package theconstrictorpackagemod.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import theconstrictorpackagemod.powers.ConstrictingPower;
import theconstrictorpackagemod.util.CardInfo;
import characterclass.MyCharacter;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static theconstrictorpackagemod.theconstrictormod.makeID;

public class BreakFree extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "BreakFree",
            1,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.COMMON,
            MyCharacter.Enums.CARD_COLOR);

    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 8;
    private static final int UPG_DAMAGE = 3;


    public BreakFree() {
        super(cardInfo);
        setDamage(DAMAGE, UPG_DAMAGE);
        setMagic(4,2);

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.SLASH_VERTICAL));
        this.addToBot(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new ConstrictingPower(AbstractDungeon.player, p, -magicNumber), -magicNumber));
    }


}

