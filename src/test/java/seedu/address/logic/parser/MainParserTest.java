package seedu.address.logic.parser;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.commons.core.Messages.MESSAGE_UNKNOWN_COMMAND;
import static seedu.address.logic.commands.CommandTestUtil.RECOMMEND_VALID_VALORANT_VALID_HOUR_ZERO_MONDAY_DESC;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.ClearCommand;
import seedu.address.logic.commands.ExitCommand;
import seedu.address.logic.commands.HelpCommand;
import seedu.address.logic.commands.RecommendCommand;
import seedu.address.logic.parser.exceptions.ParseException;

public class MainParserTest {

    private final MainParser parser = new MainParser();

    @Test
    public void parseCommand_addFriend() throws Exception {
        // TODO Update after add command is updated
        // Friend friend = new FriendBuilder().build();
        // AddFriendCommand command = (AddFriendCommand) parser.parseCommand(FriendUtil.getAddFriendCommand(friend));
        // assertEquals(new AddFriendCommand(friend), command);
    }

    @Test
    public void parseCommand_recommendFriends() throws ParseException {
        String recommendFriendsCommandString = RecommendCommand.COMMAND_WORD + " "
                + RECOMMEND_VALID_VALORANT_VALID_HOUR_ZERO_MONDAY_DESC;
        assertTrue(parser.parseCommand(recommendFriendsCommandString) instanceof RecommendCommand);
    }

    @Test
    public void parseCommand_clear() throws Exception {
        assertTrue(parser.parseCommand(ClearCommand.COMMAND_WORD) instanceof ClearCommand);
        assertTrue(parser.parseCommand(ClearCommand.COMMAND_WORD + " 3") instanceof ClearCommand);
    }

    @Test
    public void parseCommand_delete() throws Exception {
        // TODO Update after delete command is updated
        // DeleteFriendCommand command = (DeleteFriendCommand) parser.parseCommand(
        //      DeleteFriendCommand.COMMAND_WORD + " " + AMY.getFriendId().toString());
        // assertEquals(new DeleteFriendCommand(AMY.getFriendId()), command);
    }

    //    @Test
    //    public void parseCommand_edit() throws Exception {
    //        Friend friend = new FriendBuilder().build();
    //        EditFriendDescriptor descriptor = new EditFriendDescriptorBuilder(friend).build();
    //        EditCommand command = (EditCommand) parser.parseCommand(EditCommand.COMMAND_WORD + " "
    //                + INDEX_FIRST_PERSON.getOneBased() + " " + FriendUtil.getEditFriendDescriptorDetails(descriptor));
    //        assertEquals(new EditCommand(INDEX_FIRST_PERSON, descriptor), command);
    //    }

    @Test
    public void parseCommand_exit() throws Exception {
        assertTrue(parser.parseCommand(ExitCommand.COMMAND_WORD) instanceof ExitCommand);
        assertTrue(parser.parseCommand(ExitCommand.COMMAND_WORD + " 3") instanceof ExitCommand);
    }

    @Test
    public void parseCommand_help() throws Exception {
        assertTrue(parser.parseCommand(HelpCommand.COMMAND_WORD) instanceof HelpCommand);
        assertTrue(parser.parseCommand(HelpCommand.COMMAND_WORD + " 3") instanceof HelpCommand);
    }

    @Test
    public void parseCommand_list() throws Exception {
        // TODO Update after list command is updated
        // assertTrue(parser.parseCommand(ListFriendCommand.COMMAND_WORD) instanceof ListFriendCommand);
        // assertTrue(parser.parseCommand(ListFriendCommand.COMMAND_WORD + " 3") instanceof ListFriendCommand);
    }

    @Test
    public void parseCommand_unrecognisedInput_throwsParseException() {
        assertThrows(ParseException.class, String.format(MESSAGE_INVALID_COMMAND_FORMAT, HelpCommand.MESSAGE_USAGE), ()
            -> parser.parseCommand(""));
    }

    @Test
    public void parseCommand_unknownCommand_throwsParseException() {
        assertThrows(ParseException.class, MESSAGE_UNKNOWN_COMMAND, () -> parser.parseCommand("unknownCommand"));
    }
}