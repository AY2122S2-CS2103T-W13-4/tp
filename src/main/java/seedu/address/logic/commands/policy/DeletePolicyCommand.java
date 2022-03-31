package seedu.address.logic.commands.policy;

import static java.util.Objects.requireNonNull;

import java.util.List;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.client.Client;
import seedu.address.model.policy.Policy;
import seedu.address.model.policy.exceptions.InvalidPolicyIndexException;

/**
 * Deletes a client identified using it's displayed index from the address book.
 */
public class DeletePolicyCommand extends Command {

    public static final String COMMAND_WORD = "deletePolicy";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Deletes the policy identified by the client index number used in the displayed client list and "
            + "policy index number used in the displayed client card.\n"
            + "Parameters: INDEX pi/POLICY_INDEX\n"
            + "Example: " + COMMAND_WORD + " 1";

    public static final String MESSAGE_DELETE_POLICY_SUCCESS = "Deleted Policy: %s from %s's policy list";

    private final Index clientIndex;
    private final Index policyIndex;

    /**
     * @param clientIndex index of the client to remove policy from
     * @param policyIndex index of the policy to be removed
     */
    public DeletePolicyCommand(Index clientIndex, Index policyIndex) {
        this.clientIndex = clientIndex;
        this.policyIndex = policyIndex;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Client> lastShownList = model.getClientList();

        if (clientIndex.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_CLIENT_DISPLAYED_INDEX);
        }

        Client clientToDeletePolicy = lastShownList.get(clientIndex.getZeroBased());
        Policy policyToDelete;
        try {
            policyToDelete = clientToDeletePolicy.getPolicy(policyIndex.getZeroBased());
            model.setClient(clientToDeletePolicy, clientToDeletePolicy.removePolicy(policyToDelete));
        } catch (InvalidPolicyIndexException e) {
            throw new CommandException(Messages.MESSAGE_INVALID_POLICY_DISPLAYED_INDEX);
        }

        assert policyToDelete != null;
        model.setClient(clientToDeletePolicy, clientToDeletePolicy);

        return new CommandResult(String.format(MESSAGE_DELETE_POLICY_SUCCESS, policyToDelete,
                clientToDeletePolicy.getName()), false, false, false,
                false, false, null, clientToDeletePolicy);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof DeletePolicyCommand // instanceof handles nulls
                && clientIndex.equals(((DeletePolicyCommand) other).clientIndex) // state check
                && policyIndex.equals(((DeletePolicyCommand) other).policyIndex));
    }
}
