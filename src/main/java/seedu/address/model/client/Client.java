package seedu.address.model.client;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import seedu.address.model.policy.Policy;
import seedu.address.model.tag.Tag;

/**
 * Represents a Client in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Client {

    // Identity fields
    private final Name name;
    private final Phone phone;
    private final Email email;
    private final Address address;
    private Date birthday;
    private DateTime lastContacted;

    // Data fields
    private final Set<Tag> tags = new HashSet<>();
    private final List<Policy> policies = new ArrayList<>();
    private Note note = new Note("");
    private final PreferenceMap preferences = new PreferenceMap();

    /**
     * Every field must be present and not null.
     */
    public Client(Name name, Phone phone, Email email, Address address, Set<Tag> tags) {
        requireAllNonNull(name, phone, email, address, tags);
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.tags.addAll(tags);
    }

    /**
     * Every field must be present and not null.
     * Overloaded constructor for AddPolicyCommand.
     */
    public Client(Name name, Phone phone, Email email, Address address, Set<Tag> tags, List<Policy> policies) {
        requireAllNonNull(name, phone, email, address, tags, policies);
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.tags.addAll(tags);
        this.policies.addAll(policies);
    }

    /**
     * Every field must be present and not null.
     * Overloaded constructor for AddNoteCommand.
     */
    public Client(Name name, Phone phone, Email email, Address address, Set<Tag> tags, Note note) {
        requireAllNonNull(name, phone, email, address, tags, note);
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.tags.addAll(tags);
        this.note = note;
    }

    /**
     * Every field must be present and not null.
     * Overloaded constructor for all commands except PreferenceMap.
     */
    public Client(Name name, Phone phone, Email email, Address address, Set<Tag> tags,
                  List<Policy> policies, Note note) {
        requireAllNonNull(name, phone, email, address, tags, policies, note);
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.tags.addAll(tags);
        this.policies.addAll(policies);
        this.note = note;
    }

    /**
     * Every field must be present and not null.
     * Overloaded constructor for all commands.
     */
    public Client(Name name, Phone phone, Email email, Address address, Set<Tag> tags,
                  List<Policy> policies, Note note, PreferenceMap preferences) {
        requireAllNonNull(name, phone, email, address, tags, policies, note, preferences);
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.tags.addAll(tags);
        this.policies.addAll(policies);
        this.note = note;
        this.preferences.addAllPreferences(preferences);
    }

    /**
     * Every field must be present and not null.
     * Overloaded constructor for all commands.
     */
    public Client(Name name, Phone phone, Email email, Address address, Date birthday, DateTime lastContacted,
                  Set<Tag> tags, List<Policy> policies) {
        requireAllNonNull(name, phone, email, address, tags, policies);
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.birthday = birthday;
        this.lastContacted = lastContacted;
        this.tags.addAll(tags);
        this.policies.addAll(policies);
    }

    /**
     * Every field must be present and not null.
     * Overloaded constructor for all commands.
     */
    public Client(Name name, Phone phone, Email email, Address address, Date birthday, DateTime lastContacted,
                  Set<Tag> tags, List<Policy> policies, Note note, PreferenceMap preferences) {
        requireAllNonNull(name, phone, email, address, tags, policies, note, preferences);
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.birthday = birthday;
        this.lastContacted = lastContacted;
        this.tags.addAll(tags);
        this.policies.addAll(policies);
        this.note = note;
        this.preferences.addAllPreferences(preferences);
    }

    public Name getName() {
        return name;
    }

    public Phone getPhone() {
        return phone;
    }

    public Email getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    public Date getBirthday() {
        return birthday;
    }

    public DateTime getLastContacted() {
        return lastContacted;
    }

    public PreferenceMap getPreferenceMap() {
        return this.preferences;
    }

    /**
     * Returns an immutable tag set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<Tag> getTags() {
        return Collections.unmodifiableSet(tags);
    }

    /**
     * Returns an immutable policy list, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public List<Policy> getPolicies() {
        return Collections.unmodifiableList(policies);
    }

    /**
     * Returns a note
     */
    public Note getNote() {
        return note;
    }
    /**
     * Returns true if both clients have the same name.
     * This defines a weaker notion of equality between two clients.
     */
    public boolean isSameClient(Client otherClient) {
        if (otherClient == this) {
            return true;
        }

        return otherClient != null
                && otherClient.getName().equals(getName());
    }

    /**
     * Adds the key, value pair to the PreferenceMap for this client
     */
    public void addPreference(String key, String value) {
        this.preferences.addPreference(key, value);
    }

    /**
     * Deletes the key from the PreferenceMap for this client
     * @param key - the key to be deleted from the PreferenceMap
     */
    public void deletePreference(String key) {
        this.preferences.deletePreference(key);
    }

    /**
     * Returns true if both clients have the same identity and data fields.
     * This defines a stronger notion of equality between two clients.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Client)) {
            return false;
        }

        Client otherClient = (Client) other;
        return otherClient.getName().equals(getName())
                && otherClient.getPhone().equals(getPhone())
                && otherClient.getEmail().equals(getEmail())
                && otherClient.getAddress().equals(getAddress())
                && otherClient.getTags().equals(getTags());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, phone, email, address, birthday, lastContacted, tags, policies, preferences, note);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getName())
                .append("; Phone: ")
                .append(getPhone())
                .append("; Email: ")
                .append(getEmail())
                .append("; Address: ")
                .append(getAddress())
                .append("; Birthday: ")
                .append(getBirthday())
                .append("; Last Contacted: ")
                .append(getLastContacted())
                .append("; Policies: ")
                .append(getPolicies().size())
                .append("; Note: ")
                .append(getNote())
                .append("; Preferences: ")
                .append(getPreferenceMap().size());

        Set<Tag> tags = getTags();
        if (!tags.isEmpty()) {
            builder.append("; Tags: ");
            tags.forEach(builder::append);
        }
        return builder.toString();
    }

    /**
     * Returns a formatted string displaying the full details of all policies purchased by this client.
     */
    public String displayPolicyList() {
        final StringBuilder builder = new StringBuilder();
        builder.append("[");
        List<Policy> policies = getPolicies();
        if (!policies.isEmpty()) {
            int counter = 0;
            for (Policy p : policies) {
                builder.append(p.fullDetails());
                counter++;
                if (counter < policies.size()) {
                    builder.append(", ");
                }
            }
        }
        builder.append("]");
        return builder.toString();
    }
}
