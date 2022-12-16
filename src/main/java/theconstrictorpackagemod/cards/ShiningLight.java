
package theconstrictorpackagemod.cards;

        import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
        import com.megacrit.cardcrawl.actions.common.DrawCardAction;
        import com.megacrit.cardcrawl.powers.VulnerablePower;
        import com.megacrit.cardcrawl.powers.WeakPower;
        import theconstrictorpackagemod.util.CardInfo;
        import characterclass.MyCharacter;
        import com.megacrit.cardcrawl.characters.AbstractPlayer;
        import com.megacrit.cardcrawl.monsters.AbstractMonster;

        import static theconstrictorpackagemod.theconstrictormod.makeID;

public class ShiningLight extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "ShiningLight",
            0,
            CardType.SKILL,
            CardTarget.ENEMY,
            CardRarity.RARE,
            MyCharacter.Enums.CARD_COLOR);

    public static final String ID = makeID(cardInfo.baseId);



    public ShiningLight() {
        super(cardInfo);
        setMagic(2,1);
        this.exhaust = true;

    }
    public void use(AbstractPlayer p, AbstractMonster m) {
        this.addToBot(new ApplyPowerAction(m, p, new WeakPower(m, this.magicNumber, false), this.magicNumber));
        this.addToBot(new ApplyPowerAction(m, p, new VulnerablePower(m, this.magicNumber, false), this.magicNumber));
        this.addToBot(new DrawCardAction(this.magicNumber));

    }
}

