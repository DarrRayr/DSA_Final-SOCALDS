import sun.awt.image.ImageWatched;

import javax.naming.InsufficientResourcesException;
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
        /**
        Map<Person, Integer> compatibilityScores = new LinkedHashMap<>();
        ArrayList<Integer> scores = new ArrayList<>();

        for (Person candidate :  candidates) {
            int score = calculateCompatibility(user, candidate);
            compatibilityScores.put(candidate, score);
        }


        List<Map.Entry<Person, Integer>> entries = new ArrayList<Map.Entry<Person, Integer>>(map.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<Person, Integer>>() {
            public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b){
                return a.getValue().compareTo(b.getValue());
            }
        });
        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        for (Map.Entry<Person, Integer> entry : entries) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }



        for(int i = 0; i < 10; i++){
            return entryList.get(i);
        }



        Collections.sort(scores);



        **/
        //
        List<Person> ret = new ArrayList<Person>();
        ArrayList<Integer> scores = new ArrayList<Integer>();
        for (Person candidate :  candidates) {
            int score = calculateCompatibility(user, candidate);
            //compatibilityScores.put(candidate, score);
            scores.add(candidate.getCompatibilityScore());
        }
        scores.sort(Comparator.naturalOrder());

        for(int i : scores){
            for(Person e : candidates){
                if(e.getCompatibilityScore() == i && !ret.contains(e)){
                    ret.add(e);
                }
            }
        }
        return ret;
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

        if (user.getGender().equalsIgnoreCase(candidate.getGender())) score -= 10;
        if (user.getFavoriteFood().equalsIgnoreCase(candidate.getFavoriteFood())) score += 15;
        if (user.getEthnicity().equalsIgnoreCase(candidate.getEthnicity())) score += 5;
        if (Math.abs(user.getAge() - candidate.getAge()) == 5) score += 20;

        return score;
    }
}
