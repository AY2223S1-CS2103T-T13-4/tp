package taskbook.logic.commands;

import org.junit.jupiter.api.Test;

import taskbook.model.Model;
import taskbook.model.ModelManager;
import taskbook.model.TaskBook;
import taskbook.model.UserPrefs;
import taskbook.testutil.TypicalPersons;

public class ClearCommandTest {

    @Test
    public void execute_emptytaskBook_success() {
        Model model = new ModelManager();
        Model expectedModel = new ModelManager();

        CommandTestUtil.assertCommandSuccess(new ClearCommand(), model, ClearCommand.MESSAGE_SUCCESS, expectedModel);
    }

    @Test
    public void execute_nonEmptytaskBook_success() {
        Model model = new ModelManager(TypicalPersons.getTypicaltaskBook(), new UserPrefs());
        Model expectedModel = new ModelManager(TypicalPersons.getTypicaltaskBook(), new UserPrefs());
        expectedModel.setTaskBook(new TaskBook());

        CommandTestUtil.assertCommandSuccess(new ClearCommand(), model, ClearCommand.MESSAGE_SUCCESS, expectedModel);
    }

}
