package com.martinkondor.textshare;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

@Data
@NoArgsConstructor
@ToString
public class SearchRequest {
    /**
    Used to set search queries, every attribute must have a default value.
     */
    private String searchPhrase = null;
    private long numberOfEntities = 100;

    /**
     * Sort based on timestamp (newest first) and
     * search for a phrase in the TextModels content attribute
     */
    public List<TextModel> search(List<TextModel> entities) {
        Comparator<TextModel> timestampComparator = new Comparator<>() {
            @Override
            public int compare(TextModel o1, TextModel o2) {
                Long t1 = Long.valueOf(o1.getTimestamp());
                Long t2 = Long.valueOf(o2.getTimestamp());
                return t2.compareTo(t1);
            }
        };

        Stream<TextModel> stream = entities.stream().sorted(timestampComparator);
        if (this.getSearchPhrase() != null) {
            stream = stream.filter(t -> t.getContent().contains(this.getSearchPhrase()));
        }
        return stream.limit(this.getNumberOfEntities()).toList();
    }

    public List<TextForView> searchWithVotes(List<TextForView> entities) {
        Comparator<TextForView> timestampComparator = new Comparator<>() {
            @Override
            public int compare(TextForView o1, TextForView o2) {
                Long t1 = Long.valueOf(o1.getTimestamp());
                Long t2 = Long.valueOf(o2.getTimestamp());
                return t2.compareTo(t1);
            }
        };
        Comparator<TextForView> votesComparator = new Comparator<>() {
            @Override
            public int compare(TextForView o1, TextForView o2) {
                Integer i1 = o1.getUpvotes().size() - o1.getDownvotes().size();
                Integer i2 = o2.getUpvotes().size() - o2.getDownvotes().size();
                return i2.compareTo(i1);
            }
        };

        Stream<TextForView> stream = entities.stream().sorted(timestampComparator).sorted(votesComparator);
        if (this.getSearchPhrase() != null) {
            stream = stream.filter(t -> t.getContent().contains(this.getSearchPhrase()));
        }
        return stream.limit(this.getNumberOfEntities()).toList();
    }
}
