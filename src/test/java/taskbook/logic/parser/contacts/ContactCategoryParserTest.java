package taskbook.logic.parser.contacts;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import taskbook.logic.commands.Command;
import taskbook.logic.commands.contacts.ContactAddCommand;
import taskbook.logic.commands.contacts.ContactDeleteCommand;
import taskbook.logic.commands.contacts.ContactListCommand;

public class ContactCategoryParserTest {

    @Test
    public void parseCommand_add() throws Exception {
        // Note: the space at the start of the arguments is necessary due to ArgumentTokenizer behavior.
        String arguments = " n/John Doe p/98765432 e/johnd@example.com a/John street, block 123, #01-01";
        Command command = ContactCategoryParser.parseCommand(ContactAddCommand.COMMAND_WORD, arguments);
        assertTrue(command instanceof ContactAddCommand);
    }

    @Test
    public void parseCommand_delete() throws Exception {
        // Note: the space at the start of the arguments is necessary due to ArgumentTokenizer behavior.
        String arguments = " i/1";
        Command command = ContactCategoryParser.parseCommand(ContactDeleteCommand.COMMAND_WORD, arguments);
        assertTrue(command instanceof ContactDeleteCommand);
    }

    @Test
    public void parseCommand_list() throws Exception {
        String arguments = "";
        Command command = ContactCategoryParser.parseCommand(ContactListCommand.COMMAND_WORD, arguments);
        assertTrue(command instanceof ContactListCommand);
    }
}
