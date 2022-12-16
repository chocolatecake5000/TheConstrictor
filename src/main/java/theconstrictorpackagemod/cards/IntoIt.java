package theconstrictorpackagemod.cards;

import characterclass.MyCharacter;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.vfx.combat.VerticalImpactEffect;
import theconstrictorpackagemod.powers.ConstrictingPower;
import theconstrictorpackagemod.util.CardInfo;

import static theconstrictorpackagemod.theconstrictormod.makeID;

public class IntoIt extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "IntoIt",
            1,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.SPECIAL,
            MyCharacter.Enums.CARD_COLOR);

    public static final String ID = makeID(cardInfo.baseId);




    public IntoIt() {
        super(cardInfo);
        this.baseBlock = 3;
        this.baseMagicNumber = (12);
        this.magicNumber = this.baseMagicNumber;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        this.addToBot(new GainBlockAction(p,p,this.block));
    }
    public void applyPowers() {
        AbstractPower ConPower = AbstractDungeon.player.getPower(ConstrictingPower.POWER_ID);
        int Block = this.baseBlock;
        if (ConPower != null) {
            if (ConPower.amount > 0) {
                this.baseBlock = this.magicNumber;
            }


        }
        super.applyPowers();
        this.baseBlock = Block;
        this.isBlockModified = this.baseBlock != this.block;
    }

    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeMagicNumber(3);
        }

    }
}