package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PREFERENCE_KEY;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.DeletePreferenceCommand;
import seedu.address.logic.parser.exceptions.ParseException;

import java.util.stream.Stream;

public class DeletePreferenceCommandParser implements Parser<DeletePreferenceCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of DeletePreferenceCommand
     * and returns a DeletePreferenceCommand object for execution
     * @throws ParseException if the user input does not conform to the expected format
     */
    public DeletePreferenceCommand parse(String args) throws ParseException {
        requireNonNull(args);
        ArgumentMultimap argumentMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_PREFERENCE_KEY);

        if (!arePrefixesPresent(argumentMultimap, PREFIX_PREFERENCE_KEY)) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    DeletePreferenceCommand.MESSAGE_USAGE));
        }

        Index index;

        try {
            index = ParserUtil.parseIndex(argumentMultimap.getPreamble());
        } catch (ParseException pe) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    DeletePreferenceCommand.MESSAGE_USAGE));
        }

        return new DeletePreferenceCommand(index, argumentMultimap.getValue(PREFIX_PREFERENCE_KEY).get());
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultiMap}
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }
}
