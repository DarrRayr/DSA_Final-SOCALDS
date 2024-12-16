import java.util.*;

/**
 * Class used to set up the CompabilityBasedAlgorithm class
 * @author Sreyas Prabu
 */
abstract class CompatibilityAlgorithm {
    public abstract List<Person> getTopCandidates(Person user, List<Person> candidates);
}

