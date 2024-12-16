import java.util.*;

/**
 * Class used in order to execute the algorithm used to determine compatibility
 * @author Sreyas Prabu
 */
class CompatibilityBasedAlgorithm extends CompatibilityAlgorithm {
    @Override

    /**
     * Method used to get the top candidates of all the candidates
     * @author Sreyas Prabu
     * @param user the person using the SOCALDS
     * @param candidates list of all the users/candidates in SOCALDS excluding the user
     * @returns list of the top candidates
     */
    public List<Person> getTopCandidates(Person user, List<Person> candidates) {
        Map<Person, Integer>compatibilityScores = new HashMap();

        for (Person candidate: candidates) {
            int score = calculateCompatibility(user, candidate);
            compatibilityScores.put(candidate, score);
        }

        List<Person> sortedCandidates = new ArrayList(candidates);
        //Collections.sort(sortedCandidates);


        return sortedCandidates.subList(0, Math.min(10, sortedCandidates.size()));
    }

    /**
     * Method used to calculate the user's probability with another candidate/user
     * @author Sreyas Prabu
     * @param user the person using SOCALDS
     * @param candidate the other person being compared to
     * @return compatibility score used to rank
     */
    private int calculateCompatibility(Person user, Person candidate) {
        int score = 0;

        if (user.getGender().equalsIgnoreCase(candidate.getGender())) score += 10;
        if (user.getFavoriteFood().equalsIgnoreCase(candidate.getFavoriteFood())) score += 15;
        if (user.getEthnicity().equalsIgnoreCase(candidate.getEthnicity())) score += 5;
        if (Math.abs(user.getAge() - candidate.getAge()) == 5) score += 20;

        return score;
    }
}
