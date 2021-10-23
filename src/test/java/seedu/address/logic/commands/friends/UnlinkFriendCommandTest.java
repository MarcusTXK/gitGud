package seedu.address.logic.commands.friends;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalFriends.ALICE;
import static seedu.address.testutil.TypicalFriends.AMY;
import static seedu.address.testutil.TypicalFriends.getTypicalFriendsList;
import static seedu.address.testutil.TypicalGames.CSGO;
import static seedu.address.testutil.TypicalGames.GENSHIN_IMPACT;
import static seedu.address.testutil.TypicalGames.getTypicalGamesList;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_ITEM;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.Messages;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.friend.Friend;
import seedu.address.model.gamefriendlink.GameFriendLink;
import seedu.address.model.gamefriendlink.UserName;

public class UnlinkFriendCommandTest {

    private Model model = new ModelManager(getTypicalFriendsList(), getTypicalGamesList(), new UserPrefs());

    @Test
    public void execute_validFriendIdUnfilteredList_success() {
        Model model = new ModelManager(getTypicalFriendsList(), getTypicalGamesList(), new UserPrefs());
        Friend friendToUnlink = model.getFilteredFriendsList().get(INDEX_FIRST_ITEM.getZeroBased());
        GameFriendLink gameFriendLink = new GameFriendLink(GENSHIN_IMPACT.getGameId(), friendToUnlink.getFriendId(),
                new UserName("GoldNova"));
        ModelManager expectedModel = new ModelManager(model.getFriendsList(), model.getGamesList(),
                model.getUserPrefs());
        UnlinkFriendCommand unlinkFriendCommand = new UnlinkFriendCommand(friendToUnlink.getFriendId(),
                GENSHIN_IMPACT.getGameId());

        model.linkFriend(friendToUnlink, gameFriendLink);
        assertCommandSuccess(unlinkFriendCommand, model, unlinkFriendCommand.generateSuccessMessage(friendToUnlink),
                expectedModel);
    }

    @Test
    public void execute_nonExistentFriendIdUnfilteredList_throwsCommandException() {
        UnlinkFriendCommand unlinkFriendCommand = new UnlinkFriendCommand(AMY.getFriendId(),
                GENSHIN_IMPACT.getGameId());
        assertCommandFailure(unlinkFriendCommand, model, Messages.MESSAGE_NONEXISTENT_FRIEND_ID);
    }

    @Test
    public void execute_nonExistentGameIdUnfilteredList_throwsCommandException() {
        UnlinkFriendCommand unlinkFriendCommand = new UnlinkFriendCommand(ALICE.getFriendId(), CSGO.getGameId());
        assertCommandFailure(unlinkFriendCommand, model, Messages.MESSAGE_NONEXISTENT_GAME_ID);
    }

    @Test
    public void execute_gameNotAssociatedWithFriend_throwsCommandException() {
        UnlinkFriendCommand unlinkFriendCommand = new UnlinkFriendCommand(ALICE.getFriendId(),
                GENSHIN_IMPACT.getGameId());

        assertCommandFailure(unlinkFriendCommand, model, Messages.MESSAGE_GAME_NOT_ASSOCIATED);
    }
}