
package theconstrictorpackagemod.cards;

import basemod.helpers.dynamicvariables.MagicNumberVariable;
import characterclass.MyCharacter;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.ThornsPower;
import com.megacrit.cardcrawl.powers.watcher.FreeAttackPower;
import theconstrictorpackagemod.powers.ConstrictingPower;
import theconstrictorpackagemod.util.CardInfo;

import static theconstrictorpackagemod.theconstrictormod.makeID;

public class SlackTide extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "SlackTide",
            2,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.UNCOMMON,
            MyCharacter.Enums.CARD_COLOR);

    public static final String ID = makeID(cardInfo.baseId);

    private static final int BLOCK = 10;  // Updated block value
    private static final int UPG_BLOCK = 3;

    public SlackTide() {
        super(cardInfo);
        setBlock(BLOCK, UPG_BLOCK);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        int currentBlock = p.currentBlock; // Capture the current block before gaining more

        // Gain block first
        addToBot(new GainBlockAction(p, p, block));

        // Apply negative Constricting based on block gained
        addToBot(new AbstractGameAction() {
            @Override
            public void update() {
                int blockGained = p.currentBlock - currentBlock; // Calculate the actual block gained
                if (blockGained > 0) {
                    // Apply negative Constricting equal to the block gained
                    addToBot(new ApplyPowerAction(p, p, new ConstrictingPower(p, p, -blockGained), -blockGained));
                }
                isDone = true;
            }
        });
    }
}
