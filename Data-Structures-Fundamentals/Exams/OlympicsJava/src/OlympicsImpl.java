import java.util.*;
import java.util.stream.Collectors;

public class OlympicsImpl implements Olympics {

    private final Map<Integer, Competitor> competitorMap;
    private final Map<Integer, Competition> competitionMap;
    private final SortedMap<String, SortedSet<Integer>> sortedNameAndId;

    public OlympicsImpl() {
        this.competitionMap = new HashMap<>();
        this.competitorMap = new HashMap<>();
        this.sortedNameAndId = new TreeMap<>();
    }

    @Override
    public void addCompetitor(int id, String name) {
        if (this.competitorMap.containsKey(id)) {
            throw new IllegalArgumentException();
        }

        this.competitorMap.put(id, new Competitor(id, name));
        this.sortedNameAndId.putIfAbsent(name, new TreeSet<>());
        this.sortedNameAndId.get(name).add(id);
    }

    @Override
    public void addCompetition(int id, String name, int score) {
        if (this.competitionMap.containsKey(id)) {
            throw new IllegalArgumentException();
        }

        this.competitionMap.put(id, new Competition(name, id, score));
    }

    @Override
    public void compete(int competitorId, int competitionId) {
        if (!this.competitionMap.containsKey(competitionId) || !this.competitorMap.containsKey(competitorId)) {
            throw new IllegalArgumentException();
        }

        this.competitionMap.get(competitionId).addCompetitor(this.competitorMap.get(competitorId));
    }

    @Override
    public void disqualify(int competitionId, int competitorId) {

        if (!this.competitionMap.containsKey(competitionId) || !this.competitorMap.containsKey(competitorId)) {
            throw new IllegalArgumentException();
        }

        boolean disqualify = this.competitionMap.get(competitionId).disqualify(this.competitorMap.get(competitorId));

        if (!disqualify) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Iterable<Competitor> findCompetitorsInRange(long min, long max) {
        return this.competitorMap.values()
                .stream()
                .filter(c -> c.getTotalScore() > min && c.getTotalScore() <= max)
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Competitor> getByName(String name) {
        if (!this.sortedNameAndId.containsKey(name)) {
            throw new IllegalArgumentException();
        }

        SortedSet<Integer> integers = this.sortedNameAndId.get(name);
        List<Competitor> result = new ArrayList<>(integers.size());

        for (Integer integer : integers) {
            result.add(this.competitorMap.get(integer));
        }
        return result;
    }

    @Override
    public Iterable<Competitor> searchWithNameLength(int minLength, int maxLength) {
        Set<String> filter = this.sortedNameAndId.keySet().stream()
                .filter(n -> n.length() >= minLength && n.length() <= maxLength)
                .collect(Collectors.toSet());

        if (filter.isEmpty()) {
            return Collections.emptyList();
        }

        List<Competitor> result = new ArrayList<>(filter.size());
        for (String s : filter) {
            SortedSet<Integer> integers = this.sortedNameAndId.get(s);

            for (Integer integer : integers) {
                result.add(this.competitorMap.get(integer));
            }
        }
        result.sort(Comparator.comparingInt(Competitor::getId));
        return result;
    }

    @Override
    public Boolean contains(int competitionId, Competitor comp) {
        if (!this.competitionMap.containsKey(competitionId)) {
            throw new IllegalArgumentException();
        }
        if (!this.competitorMap.containsKey(comp.getId())) {
            throw new IllegalArgumentException();
        }

        return this.competitionMap.get(competitionId).getCompetitors().contains(comp);
    }

    @Override
    public int competitionsCount() {
        return this.competitionMap.size();
    }

    @Override
    public int competitorsCount() {
        return this.competitorMap.size();
    }

    @Override
    public Competition getCompetition(int id) {
        if (!this.competitionMap.containsKey(id)) {
            throw new IllegalArgumentException();
        }

        return this.competitionMap.get(id);
    }
}
