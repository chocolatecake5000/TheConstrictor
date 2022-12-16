
package theconstrictorpackagemod.cards;

        import theconstrictorpackagemod.util.CardInfo;
        import characterclass.MyCharacter;
        import com.megacrit.cardcrawl.actions.AbstractGameAction;
        import com.megacrit.cardcrawl.actions.common.DamageAction;
        import com.megacrit.cardcrawl.cards.DamageInfo;
        import com.megacrit.cardcrawl.characters.AbstractPlayer;
        import com.megacrit.cardcrawl.monsters.AbstractMonster;

        import static theconstrictorpackagemod.theconstrictormod.makeID;

public class Multihit extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Multihit",
            1,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.UNCOMMON,
            MyCharacter.Enums.CARD_COLOR);

    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 3;
    private static final int UPG_DAMAGE = 1;


    public Multihit() {
        super(cardInfo);
        setDamage(DAMAGE, UPG_DAMAGE);

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        this.addToBot(new DamageAction(m, new DamageInfo(p, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.SLASH_HORIZONTAL));
        this.addToBot(new DamageAction(m, new DamageInfo(p, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.SLASH_VERTICAL));
        this.addToBot(new DamageAction(m, new DamageInfo(p, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.SLASH_HORIZONTAL));
    }


}
