package seedu.address.logic.parser.friends;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.friends.LinkFriendCommand;
import seedu.address.model.friend.FriendId;
import seedu.address.model.game.GameId;
import seedu.address.model.gamefriendlink.UserName;

class LinkFriendCommandParserTest {
    private LinkFriendCommandParser parser = new LinkFriendCommandParser();
    private final String invalidCommandFormatMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT,
            LinkFriendCommand.MESSAGE_USAGE);

    @Test
    public void parse_validArgs_returnsLinkCommand() {
        String userInput = " " + LinkFriendCommand.COMMAND_WORD + " Draco --game CSGO --user GoldNova";
        FriendId friendId = new FriendId("Draco");
        GameId gameId = new GameId("CSGO");
        UserName userName = new UserName("GoldNova");
        assertParseSuccess(parser, userInput, new LinkFriendCommand(friendId, gameId, userName));
    }

    @Test
    public void parse_validArgsInDifferentOrder_returnsLinkCommand() {
        String userInput = " " + LinkFriendCommand.COMMAND_WORD + " Draco --game CSGO --user GoldNova";
        FriendId friendId = new FriendId("Draco");
        GameId gameId = new GameId("CSGO");
        UserName userName = new UserName("GoldNova");
        assertParseSuccess(parser, userInput, new LinkFriendCommand(friendId, gameId, userName));
    }

    @Test
    public void parse_compulsoryFieldsMissing_failure() {
        String userInput = " " + LinkFriendCommand.COMMAND_WORD + " --game CSGO --user SmurfLord";
        assertParseFailure(parser, userInput, FriendId.MESSAGE_EMPTY_FRIEND_ID);
    }

    @Test
    public void parse_noInput_failure() {
        // no input
        assertParseFailure(parser, "", invalidCommandFormatMessage);

        // whitespace only
        assertParseFailure(parser, " ", invalidCommandFormatMessage);
    }
}